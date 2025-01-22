package com.plcoding.bluelink.data.chat

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.plcoding.bluelink.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain(): BluetoothDeviceDomain {
    return BluetoothDeviceDomain(
        name = name,
        address = address,
        isPaired = this.bondState == BluetoothDevice.BOND_BONDED
    )
}