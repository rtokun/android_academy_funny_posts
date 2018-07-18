package com.example.artyom.advancednetworkinglectureexample.network;

import com.example.artyom.advancednetworkinglectureexample.models.LoginRequest;
import com.example.artyom.advancednetworkinglectureexample.models.LoginResponse;
import com.example.artyom.advancednetworkinglectureexample.models.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Streaming;

public interface FunnyPostsService {

  @GET("/posts")
  Call<List<Post>> getPosts();

  @POST("/posts")
  Call<Void> submitNewPost(@Body Post newPost);

  @POST("/users/login")
  @Headers("AppInternal-NoAuth:true")
  Call<LoginResponse> login(@Body LoginRequest credentials);

  @GET("/videos/daily")
  @Streaming
  Call<ResponseBody> downloadVideoOfTheDay();
}
