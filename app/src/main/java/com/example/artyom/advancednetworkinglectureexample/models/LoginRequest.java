package com.example.artyom.advancednetworkinglectureexample.models;

import com.google.gson.annotations.SerializedName;

public class LoginRequest {

  @SerializedName("pass")
  private String pass;

  @SerializedName("username")
  private String username;

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "LoginRequest{" + "pass = '" + pass + '\'' + ",username = '" + username + '\'' + "}";
  }
}
