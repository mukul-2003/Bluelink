package com.plcoding.bluelink.data.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B.\u0012\'\u0010\u0002\u001a#\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R/\u0010\u0002\u001a#\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/plcoding/bluelink/data/chat/BluetoothStateReceiver;", "Landroid/content/BroadcastReceiver;", "onStateChanged", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isConnected", "Landroid/bluetooth/BluetoothDevice;", "", "(Lkotlin/jvm/functions/Function2;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"})
public final class BluetoothStateReceiver extends android.content.BroadcastReceiver {
    private final kotlin.jvm.functions.Function2<java.lang.Boolean, android.bluetooth.BluetoothDevice, kotlin.Unit> onStateChanged = null;
    
    public BluetoothStateReceiver(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super android.bluetooth.BluetoothDevice, kotlin.Unit> onStateChanged) {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
}