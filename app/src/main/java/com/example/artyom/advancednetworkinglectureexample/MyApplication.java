package com.example.artyom.advancednetworkinglectureexample;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

  private static Context mAppContext;

  public static Context getAppContext() {
    return mAppContext;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    mAppContext = this;
  }
}
