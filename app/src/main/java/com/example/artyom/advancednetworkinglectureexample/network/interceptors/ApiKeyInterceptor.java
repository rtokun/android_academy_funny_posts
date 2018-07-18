package com.example.artyom.advancednetworkinglectureexample.network.interceptors;

import android.support.annotation.NonNull;

import com.example.artyom.advancednetworkinglectureexample.Storage;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyInterceptor implements Interceptor {

  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {

    // Original Request
    Request originalRequest = chain.request();

    // Create new URL from old one including API key
    HttpUrl updatedUrl =
            originalRequest.url()
            .newBuilder()
            .addQueryParameter("apikey", Storage.getInstance().getApiKey())
            .build();

    // Modified request
    Request modifiedRequest = originalRequest
            .newBuilder()
            .url(updatedUrl)
            .build();

    // Continue with request
    return chain.proceed(modifiedRequest);
  }
}
