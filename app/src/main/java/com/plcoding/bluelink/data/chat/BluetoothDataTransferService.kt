//package com.plcoding.bluelink.data.chat
//
//import android.bluetooth.BluetoothSocket
//import com.plcoding.bluelink.domain.chat.BluetoothMessage
//import com.plcoding.bluelink.domain.chat.TransferFailedException
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOn
//import kotlinx.coroutines.withContext
//import java.io.*
//
//class BluetoothDataTransferService(
//    private val socket: BluetoothSocket
//) {
//
//    fun listenForIncomingMessages(saveFileDir: File): Flow<BluetoothMessage> {
//        return flow {
//            if (!socket.isConnected) return@flow
//            val inputStream = socket.inputStream
//            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
//
//            while (true) {
//                val header = bufferedReader.readLine() ?: break
//
//                if (header.startsWith("FILE::")) {
//                    val fileName = header.removePrefix("FILE::")
//                    val file = File(saveFileDir, fileName)
//                    val fileOutputStream = FileOutputStream(file)
//
//                    try {
//                        val buffer = ByteArray(4096)
//                        var bytesRead: Int
//                        while (true) {
//                            bytesRead = inputStream.read(buffer)
//                            if (bytesRead == -1) break
//                            fileOutputStream.write(buffer, 0, bytesRead)
//                        }
//                    } catch (e: IOException) {
//                        throw TransferFailedException()
//                    } finally {
//                        fileOutputStream.close()
//                    }
//                    delay(100)
//                    emit(
//                        BluetoothMessage(
//                            message = file.absolutePath,
//                            senderName = "Remote Device",
//                            isFromLocalUser = false,
//                            isFile = true,
//                            fileName = fileName,
//                        )
//
//                    )
//                } else {
//                    emit(header.toBluetoothMessage(isFromLocalUser = false))
//                }
//            }
//        }.flowOn(Dispatchers.IO)
//    }
//
//    suspend fun sendMessage(bytes: ByteArray): Boolean {
//        return withContext(Dispatchers.IO) {
//            try {
//                socket.outputStream.write(bytes)
//                true
//            } catch (e: IOException) {
//                false
//            }
//        }
//    }
//
//    suspend fun sendFile(file: File, senderName: String): Boolean {
//        return withContext(Dispatchers.IO) {
//            try {
//                val outputStream = socket.outputStream
//
//                // Send header
//                val header = "FILE::${file.name}\n"
//                outputStream.write(header.toByteArray())
//
//                // Stream file content
//                val buffer = ByteArray(4096)
//                val inputStream = FileInputStream(file)
//                var bytes = inputStream.read(buffer)
//                while (bytes >= 0) {
//                    outputStream.write(buffer, 0, bytes)
//                    bytes = inputStream.read(buffer)
//                }
//                inputStream.close()
//
//                true
//            } catch (e: IOException) {
//                false
//            }
//        }
//    }
//}

package com.plcoding.bluelink.data.chat

import android.bluetooth.BluetoothSocket
import com.plcoding.bluelink.domain.chat.BluetoothMessage
import com.plcoding.bluelink.domain.chat.TransferFailedException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.*

class BluetoothDataTransferService(
    private val socket: BluetoothSocket
) {

    fun listenForIncomingMessages(saveFileDir: File): Flow<BluetoothMessage> {
        return flow {
            if (!socket.isConnected) return@flow
            val input = DataInputStream(BufferedInputStream(socket.inputStream))

            while (true) {
                val type = input.readUTF() // "MSG" or "FILE"

                when (type) {
                    "MSG" -> {
                        val sender = input.readUTF()
                        val message = input.readUTF()
                        emit(
                            BluetoothMessage(
                                message = message,
                                senderName = sender,
                                isFromLocalUser = false
                            )
                        )
                    }

                    "FILE" -> {
                        val sender = input.readUTF()
                        val fileName = input.readUTF()
                        val fileSize = input.readLong()

                        val file = File(saveFileDir, fileName)
                        val outputStream = FileOutputStream(file)
                        val buffer = ByteArray(4096)
                        var remaining = fileSize

                        while (remaining > 0) {
                            val read = input.read(buffer, 0, minOf(buffer.size.toLong(), remaining).toInt())
                            outputStream.write(buffer, 0, read)
                            remaining -= read
                        }

                        outputStream.close()

                        emit(
                            BluetoothMessage(
                                message = file.absolutePath,
                                senderName = sender,
                                isFromLocalUser = false,
                                isFile = true,
                                fileName = fileName
                            )
                        )
                    }

                    else -> throw IOException("Unknown data type: $type")
                }
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun sendMessage(sender: String, message: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val output = DataOutputStream(BufferedOutputStream(socket.outputStream))
                output.writeUTF("MSG")
                output.writeUTF(sender)
                output.writeUTF(message)
                output.flush()
                true
            } catch (e: IOException) {
                false
            }
        }
    }

    suspend fun sendFile(file: File, senderName: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val output = DataOutputStream(BufferedOutputStream(socket.outputStream))

                output.writeUTF("FILE")
                output.writeUTF(senderName)
                output.writeUTF(file.name)
                output.writeLong(file.length())

                val inputStream = FileInputStream(file)
                val buffer = ByteArray(4096)
                var bytes = inputStream.read(buffer)

                while (bytes >= 0) {
                    output.write(buffer, 0, bytes)
                    bytes = inputStream.read(buffer)
                }

                inputStream.close()
                output.flush()
                true
            } catch (e: IOException) {
                throw TransferFailedException()
            }
        }
    }
}
