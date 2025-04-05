package com.plcoding.bluelink.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u001a\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/plcoding/bluelink/presentation/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothAdapter$delegate", "Lkotlin/Lazy;", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "kotlin.jvm.PlatformType", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "bluetoothManager$delegate", "filePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "isBluetoothEnabled", "", "()Z", "viewModel", "Lcom/plcoding/bluelink/presentation/BluetoothViewModel;", "getFileNameFromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openBluetoothSettings", "pickFile", "uriToFile", "Ljava/io/File;", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    private final kotlin.Lazy bluetoothManager$delegate = null;
    private final kotlin.Lazy bluetoothAdapter$delegate = null;
    private com.plcoding.bluelink.presentation.BluetoothViewModel viewModel;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> filePickerLauncher = null;
    
    public MainActivity() {
        super();
    }
    
    private final android.bluetooth.BluetoothManager getBluetoothManager() {
        return null;
    }
    
    private final android.bluetooth.BluetoothAdapter getBluetoothAdapter() {
        return null;
    }
    
    private final boolean isBluetoothEnabled() {
        return false;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void pickFile() {
    }
    
    private final void openBluetoothSettings() {
    }
    
    private final java.io.File uriToFile(android.content.Context context, android.net.Uri uri) {
        return null;
    }
    
    private final java.lang.String getFileNameFromUri(android.content.Context context, android.net.Uri uri) {
        return null;
    }
}