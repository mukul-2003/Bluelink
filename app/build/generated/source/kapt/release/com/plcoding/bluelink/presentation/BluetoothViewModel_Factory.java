package com.plcoding.bluelink.presentation;

import android.app.Application;
import com.plcoding.bluelink.domain.chat.BluetoothController;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BluetoothViewModel_Factory implements Factory<BluetoothViewModel> {
  private final Provider<BluetoothController> bluetoothControllerProvider;

  private final Provider<Application> appProvider;

  public BluetoothViewModel_Factory(Provider<BluetoothController> bluetoothControllerProvider,
      Provider<Application> appProvider) {
    this.bluetoothControllerProvider = bluetoothControllerProvider;
    this.appProvider = appProvider;
  }

  @Override
  public BluetoothViewModel get() {
    return newInstance(bluetoothControllerProvider.get(), appProvider.get());
  }

  public static BluetoothViewModel_Factory create(
      Provider<BluetoothController> bluetoothControllerProvider,
      Provider<Application> appProvider) {
    return new BluetoothViewModel_Factory(bluetoothControllerProvider, appProvider);
  }

  public static BluetoothViewModel newInstance(BluetoothController bluetoothController,
      Application app) {
    return new BluetoothViewModel(bluetoothController, app);
  }
}
