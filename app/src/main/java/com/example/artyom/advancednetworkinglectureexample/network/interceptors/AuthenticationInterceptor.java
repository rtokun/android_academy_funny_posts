package com.example.artyom.advancednetworkinglectureexample.network.interceptors;

import android.support.annotation.NonNull;

import com.example.artyom.advancednetworkinglectureexample.Storage;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

  @Override
  public Response intercept(@NonNull Chain chain) throws IOException {

    // Original Request
    Request request = chain.request();

    // if NoAuth-flag header is missing, we can add authentication
    if (request.header("AppInternal-NoAuth") == null) {
      // Get previously saved Authentication token
      String token = Storage.getInstance().getToken();

      // Request customization: add request headers
      request = request
              .newBuilder()
              .header("Authorization", token)
              .build();
    } else {

      // Remove internal header from request
      request = request
              .newBuilder()
              .removeHeader("AppInternal-NoAuth")
              .build();
    }

    // Continue with request
    return chain.proceed(request);
  }
}
