package com.example.artyom.advancednetworkinglectureexample;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Storage {

  private static final Storage ourInstance = new Storage();
  private static final String TOKEN_KEY = "token_key";
  private SharedPreferences mSharedPreferences;

  private Storage() {
    mSharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getAppContext());
  }

  public static Storage getInstance() {
    return ourInstance;
  }

  public void saveToken(String token) {
    mSharedPreferences.edit().putString(TOKEN_KEY, token).apply();
  }

  public String getToken() {
    return mSharedPreferences.getString(TOKEN_KEY, "");
  }

  public String getApiKey() {
    return MyApplication.getAppContext().getString(R.string.api_key);
  }
}
