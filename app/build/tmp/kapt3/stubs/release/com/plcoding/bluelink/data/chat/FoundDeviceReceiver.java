package com.plcoding.bluelink.data.chat;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/plcoding/bluelink/data/chat/FoundDeviceReceiver;", "Landroid/content/BroadcastReceiver;", "onDeviceFound", "Lkotlin/Function1;", "Landroid/bluetooth/BluetoothDevice;", "", "(Lkotlin/jvm/functions/Function1;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"})
public final class FoundDeviceReceiver extends android.content.BroadcastReceiver {
    private final kotlin.jvm.functions.Function1<android.bluetooth.BluetoothDevice, kotlin.Unit> onDeviceFound = null;
    
    public FoundDeviceReceiver(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super android.bluetooth.BluetoothDevice, kotlin.Unit> onDeviceFound) {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
    }
}