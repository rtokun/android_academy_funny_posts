package com.example.artyom.advancednetworkinglectureexample.models;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {

  @SerializedName("message")
  private String message;

  @SerializedName("statusCode")
  private int statusCode;

  public ErrorResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public String toString() {
    return "ErrorResponse{"
        + "message = '"
        + message
        + '\''
        + ",statusCode = '"
        + statusCode
        + '\''
        + "}";
  }
}
