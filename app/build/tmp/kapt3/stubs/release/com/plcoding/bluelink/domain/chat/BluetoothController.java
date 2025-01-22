package com.plcoding.bluelink.domain.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0011\u001a\u00020\u0012H&J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\u0012H&J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&J\b\u0010\u0019\u001a\u00020\u0012H&J\b\u0010\u001a\u001a\u00020\u0012H&J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\nR\u001e\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001e\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/plcoding/bluelink/domain/chat/BluetoothController;", "", "errors", "Lkotlinx/coroutines/flow/SharedFlow;", "", "getErrors", "()Lkotlinx/coroutines/flow/SharedFlow;", "isConnected", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "pairedDevices", "", "Lcom/plcoding/bluelink/domain/chat/BluetoothDevice;", "getPairedDevices", "scannedDevices", "getScannedDevices", "closeConnection", "", "connectToDevice", "Lkotlinx/coroutines/flow/Flow;", "Lcom/plcoding/bluelink/domain/chat/ConnectionResult;", "device", "release", "startBluetoothServer", "startDiscovery", "stopDiscovery", "trySendMessage", "Lcom/plcoding/bluelink/domain/chat/BluetoothMessage;", "message", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public abstract interface BluetoothController {
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isConnected();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.StateFlow<java.util.List<com.plcoding.bluelink.domain.chat.BluetoothDevice>> getScannedDevices();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.StateFlow<java.util.List<com.plcoding.bluelink.domain.chat.BluetoothDevice>> getPairedDevices();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.SharedFlow<java.lang.String> getErrors();
    
    public abstract void startDiscovery();
    
    public abstract void stopDiscovery();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.plcoding.bluelink.domain.chat.ConnectionResult> startBluetoothServer();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.plcoding.bluelink.domain.chat.ConnectionResult> connectToDevice(@org.jetbrains.annotations.NotNull
    com.plcoding.bluelink.domain.chat.BluetoothDevice device);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object trySendMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.plcoding.bluelink.domain.chat.BluetoothMessage> continuation);
    
    public abstract void closeConnection();
    
    public abstract void release();
}