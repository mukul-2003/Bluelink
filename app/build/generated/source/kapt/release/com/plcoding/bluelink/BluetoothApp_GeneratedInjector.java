package com.plcoding.bluelink;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = BluetoothApp.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface BluetoothApp_GeneratedInjector {
  void injectBluetoothApp(BluetoothApp bluetoothApp);
}
