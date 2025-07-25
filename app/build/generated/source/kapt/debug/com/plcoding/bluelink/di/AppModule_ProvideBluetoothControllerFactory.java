package com.plcoding.bluelink.di;

import android.content.Context;
import com.plcoding.bluelink.domain.chat.BluetoothController;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideBluetoothControllerFactory implements Factory<BluetoothController> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideBluetoothControllerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public BluetoothController get() {
    return provideBluetoothController(contextProvider.get());
  }

  public static AppModule_ProvideBluetoothControllerFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideBluetoothControllerFactory(contextProvider);
  }

  public static BluetoothController provideBluetoothController(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBluetoothController(context));
  }
}
