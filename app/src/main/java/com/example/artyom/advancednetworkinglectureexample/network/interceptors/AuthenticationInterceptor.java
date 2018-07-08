package com.example.artyom.advancednetworkinglectureexample.network.interceptors;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {
    Request original = chain.request();

    // Request customization: add request headers
    Request.Builder requestBuilder =
        original
            .newBuilder()
            .header(
                "Authorization",
                "token=eyJ0aWQiOiI1YjNjYzkzY2M2OGUwYjFmZjU0NWZhMTAiLCJleHAiOjE1Mzg0ODYzMzI0NDh9"); // <-- this is the important line

    Request request = requestBuilder.build();
    return chain.proceed(request);
  }
}
