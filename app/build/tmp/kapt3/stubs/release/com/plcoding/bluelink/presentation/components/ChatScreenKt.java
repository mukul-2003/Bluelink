package com.plcoding.bluelink.presentation.components;

import java.lang.System;

@kotlin.OptIn(markerClass = {androidx.compose.ui.ExperimentalComposeUiApi.class})
@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aH\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a \u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005\u00a8\u0006\u0016"}, d2 = {"ChatScreen", "", "state", "Lcom/plcoding/bluelink/presentation/BluetoothUiState;", "connectedDeviceName", "", "onDisconnect", "Lkotlin/Function0;", "onSendMessage", "Lkotlin/Function1;", "onSendFile", "FileMessageBubble", "fileName", "filePath", "context", "Landroid/content/Context;", "TextMessageBubble", "message", "isFromLocal", "", "openFile", "path", "app_release"})
public final class ChatScreenKt {
    
    @androidx.compose.runtime.Composable
    public static final void ChatScreen(@org.jetbrains.annotations.NotNull
    com.plcoding.bluelink.presentation.BluetoothUiState state, @org.jetbrains.annotations.NotNull
    java.lang.String connectedDeviceName, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDisconnect, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSendMessage, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSendFile) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TextMessageBubble(@org.jetbrains.annotations.NotNull
    java.lang.String message, boolean isFromLocal) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void FileMessageBubble(@org.jetbrains.annotations.NotNull
    java.lang.String fileName, @org.jetbrains.annotations.NotNull
    java.lang.String filePath, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public static final void openFile(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String path) {
    }
}