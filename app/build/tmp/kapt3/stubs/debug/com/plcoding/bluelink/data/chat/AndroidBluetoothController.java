package com.plcoding.bluelink.data.chat;

import java.lang.System;

@android.annotation.SuppressLint(value = {"MissingPermission"})
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u00101\u001a\u000202H\u0016J\u001a\u00103\u001a\b\u0012\u0004\u0012\u000205042\n\u00106\u001a\u00060\rj\u0002`\u000eH\u0016J\u0010\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u000202H\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\b\u0010;\u001a\u000202H\u0016J\b\u0010<\u001a\u000202H\u0016J\u001b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010@J\b\u0010A\u001a\u000202H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R#\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010,R$\u0010-\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f0+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010,R$\u0010/\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\f0+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006C"}, d2 = {"Lcom/plcoding/bluelink/data/chat/AndroidBluetoothController;", "Lcom/plcoding/bluelink/domain/chat/BluetoothController;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_errors", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_isConnected", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_pairedDevices", "", "Lcom/plcoding/bluelink/domain/chat/BluetoothDevice;", "Lcom/plcoding/bluelink/domain/chat/BluetoothDeviceDomain;", "_scannedDevices", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter$delegate", "Lkotlin/Lazy;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "kotlin.jvm.PlatformType", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "bluetoothManager$delegate", "bluetoothStateReceiver", "Lcom/plcoding/bluelink/data/chat/BluetoothStateReceiver;", "currentClientSocket", "Landroid/bluetooth/BluetoothSocket;", "currentServerSocket", "Landroid/bluetooth/BluetoothServerSocket;", "dataTransferService", "Lcom/plcoding/bluelink/data/chat/BluetoothDataTransferService;", "errors", "Lkotlinx/coroutines/flow/SharedFlow;", "getErrors", "()Lkotlinx/coroutines/flow/SharedFlow;", "foundDeviceReceiver", "Lcom/plcoding/bluelink/data/chat/FoundDeviceReceiver;", "isConnected", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "pairedDevices", "getPairedDevices", "scannedDevices", "getScannedDevices", "closeConnection", "", "connectToDevice", "Lkotlinx/coroutines/flow/Flow;", "Lcom/plcoding/bluelink/domain/chat/ConnectionResult;", "device", "hasPermission", "permission", "release", "startBluetoothServer", "startDiscovery", "stopDiscovery", "trySendMessage", "Lcom/plcoding/bluelink/domain/chat/BluetoothMessage;", "message", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePairedDevices", "Companion", "app_debug"})
public final class AndroidBluetoothController implements com.plcoding.bluelink.domain.chat.BluetoothController {
    private final android.content.Context context = null;
    private final kotlin.Lazy bluetoothManager$delegate = null;
    private final kotlin.Lazy bluetoothAdapter$delegate = null;
    private com.plcoding.bluelink.data.chat.BluetoothDataTransferService dataTransferService;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isConnected = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.plcoding.bluelink.domain.chat.BluetoothDevice>> _scannedDevices = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.plcoding.bluelink.domain.chat.BluetoothDevice>> _pairedDevices = null;
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> _errors = null;
    private final com.plcoding.bluelink.data.chat.FoundDeviceReceiver foundDeviceReceiver = null;
    private final com.plcoding.bluelink.data.chat.BluetoothStateReceiver bluetoothStateReceiver = null;
    private android.bluetooth.BluetoothServerSocket currentServerSocket;
    private android.bluetooth.BluetoothSocket currentClientSocket;
    @org.jetbrains.annotations.NotNull
    public static final com.plcoding.bluelink.data.chat.AndroidBluetoothController.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String SERVICE_UUID = "27b7d1da-08c7-4505-a6d1-2459987e5e2d";
    
    public AndroidBluetoothController(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final android.bluetooth.BluetoothManager getBluetoothManager() {
        return null;
    }
    
    private final android.bluetooth.BluetoothAdapter getBluetoothAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isConnected() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.StateFlow<java.util.List<com.plcoding.bluelink.domain.chat.BluetoothDevice>> getScannedDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.StateFlow<java.util.List<com.plcoding.bluelink.domain.chat.BluetoothDevice>> getPairedDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.SharedFlow<java.lang.String> getErrors() {
        return null;
    }
    
    @java.lang.Override
    public void startDiscovery() {
    }
    
    @java.lang.Override
    public void stopDiscovery() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<com.plcoding.bluelink.domain.chat.ConnectionResult> startBluetoothServer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<com.plcoding.bluelink.domain.chat.ConnectionResult> connectToDevice(@org.jetbrains.annotations.NotNull
    com.plcoding.bluelink.domain.chat.BluetoothDevice device) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object trySendMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.plcoding.bluelink.domain.chat.BluetoothMessage> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void closeConnection() {
    }
    
    @java.lang.Override
    public void release() {
    }
    
    private final void updatePairedDevices() {
    }
    
    private final boolean hasPermission(java.lang.String permission) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/plcoding/bluelink/data/chat/AndroidBluetoothController$Companion;", "", "()V", "SERVICE_UUID", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}