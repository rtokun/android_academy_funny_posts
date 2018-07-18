package com.example.artyom.advancednetworkinglectureexample.utils;

import android.content.Context;

import java.io.File;

public class StorageUtils {

  public static File getCacheFolder(Context context) {
    File folder = new File(context.getCacheDir(), "NETWORKING_CACHE");
    if (!folder.exists()) {
      folder.mkdir();
    }
    return folder;
  }
}
