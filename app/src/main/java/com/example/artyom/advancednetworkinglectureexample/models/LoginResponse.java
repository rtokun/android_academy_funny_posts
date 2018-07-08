package com.example.artyom.advancednetworkinglectureexample.models;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

  @SerializedName("token")
  private String accessToken;

  public String getAccessToken() {
    return accessToken;
  }

  @Override
  public String toString() {
    return "LoginResponse{" + "accessToken = '" + accessToken + '\'' + "}";
  }
}
