package com.example.artyom.advancednetworkinglectureexample.network;

import com.example.artyom.advancednetworkinglectureexample.MyApplication;
import com.example.artyom.advancednetworkinglectureexample.network.interceptors.ApiKeyInterceptor;
import com.example.artyom.advancednetworkinglectureexample.network.interceptors.AuthenticationInterceptor;
import com.example.artyom.advancednetworkinglectureexample.utils.StorageUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceProvider {

  // Base URL for all requests
  private static final String BASE_URL = "http://pyoqg.mocklab.io/";

  private static int cacheSize = 10 * 1024 * 1024; // 10 MB
  private static Cache cache = new Cache(StorageUtils.getCacheFolder(MyApplication.getAppContext()),
          cacheSize);

  private static Retrofit.Builder builder =
      new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create());

  private static OkHttpClient.Builder httpClient =
      new OkHttpClient.Builder()
          .cache(cache)
          .connectTimeout(30, TimeUnit.SECONDS)
          .readTimeout(30, TimeUnit.SECONDS)
          .writeTimeout(30, TimeUnit.SECONDS)
          .addInterceptor(new AuthenticationInterceptor())
          .addInterceptor(new ApiKeyInterceptor())
          .addInterceptor(new HttpLoggingInterceptor()
                              .setLevel(HttpLoggingInterceptor.Level.BODY));

  public static Retrofit retrofit = builder
                            .client(httpClient.build())
                            .build();

  public static <S> S createService(Class<S> serviceClass) {
    return retrofit.create(serviceClass);
  }

}
