package com.example.artyom.advancednetworkinglectureexample.network;

import com.example.artyom.advancednetworkinglectureexample.network.interceptors.AuthenticationInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {

  // Base URL for all requests
  private static final String BASE_URL = "http://pyoqg.mocklab.io/";

  private static Retrofit.Builder builder =
      new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

  private static OkHttpClient.Builder httpClient =
      new OkHttpClient.Builder()
          .addInterceptor(new AuthenticationInterceptor())
          .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));

  public static Retrofit retrofit = builder.client(httpClient.build()).build();

  public static <S> S createService(Class<S> serviceClass) {
    return retrofit.create(serviceClass);
  }
}
