package com.plcoding.bluelink.data.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/plcoding/bluelink/data/chat/BluetoothDataTransferService;", "", "socket", "Landroid/bluetooth/BluetoothSocket;", "(Landroid/bluetooth/BluetoothSocket;)V", "listenForIncomingMessages", "Lkotlinx/coroutines/flow/Flow;", "Lcom/plcoding/bluelink/domain/chat/BluetoothMessage;", "sendMessage", "", "bytes", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class BluetoothDataTransferService {
    private final android.bluetooth.BluetoothSocket socket = null;
    
    public BluetoothDataTransferService(@org.jetbrains.annotations.NotNull
    android.bluetooth.BluetoothSocket socket) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.plcoding.bluelink.domain.chat.BluetoothMessage> listenForIncomingMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object sendMessage(@org.jetbrains.annotations.NotNull
    byte[] bytes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}