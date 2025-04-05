package com.plcoding.bluelink.presentation;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\u000e\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0012J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\u0012\u0010!\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020#0\"H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/plcoding/bluelink/presentation/BluetoothViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "bluetoothController", "Lcom/plcoding/bluelink/domain/chat/BluetoothController;", "app", "Landroid/app/Application;", "(Lcom/plcoding/bluelink/domain/chat/BluetoothController;Landroid/app/Application;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/plcoding/bluelink/presentation/BluetoothUiState;", "connectionTimeoutJob", "Lkotlinx/coroutines/Job;", "deviceConnectionJob", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "connectToDevice", "", "device", "Lcom/plcoding/bluelink/domain/chat/BluetoothDevice;", "disconnectFromDevice", "getFileSaveDirectory", "Ljava/io/File;", "onCleared", "sendFile", "file", "sendMessage", "message", "", "startScan", "stopScan", "waitForIncomingConnections", "listen", "Lkotlinx/coroutines/flow/Flow;", "Lcom/plcoding/bluelink/domain/chat/ConnectionResult;", "app_release"})
public final class BluetoothViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.plcoding.bluelink.domain.chat.BluetoothController bluetoothController = null;
    private final android.app.Application app = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.plcoding.bluelink.presentation.BluetoothUiState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.plcoding.bluelink.presentation.BluetoothUiState> state = null;
    private kotlinx.coroutines.Job deviceConnectionJob;
    private kotlinx.coroutines.Job connectionTimeoutJob;
    
    @javax.inject.Inject
    public BluetoothViewModel(@org.jetbrains.annotations.NotNull
    com.plcoding.bluelink.domain.chat.BluetoothController bluetoothController, @org.jetbrains.annotations.NotNull
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.plcoding.bluelink.presentation.BluetoothUiState> getState() {
        return null;
    }
    
    public final void connectToDevice(@org.jetbrains.annotations.NotNull
    com.plcoding.bluelink.domain.chat.BluetoothDevice device) {
    }
    
    public final void disconnectFromDevice() {
    }
    
    public final void waitForIncomingConnections() {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull
    java.lang.String message) {
    }
    
    public final void sendFile(@org.jetbrains.annotations.NotNull
    java.io.File file) {
    }
    
    public final void startScan() {
    }
    
    public final void stopScan() {
    }
    
    private final kotlinx.coroutines.Job listen(kotlinx.coroutines.flow.Flow<? extends com.plcoding.bluelink.domain.chat.ConnectionResult> $this$listen) {
        return null;
    }
    
    private final java.io.File getFileSaveDirectory() {
        return null;
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
}