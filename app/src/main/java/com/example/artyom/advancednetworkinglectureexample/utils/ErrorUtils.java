package com.example.artyom.advancednetworkinglectureexample.utils;

import com.example.artyom.advancednetworkinglectureexample.models.ErrorResponse;
import com.example.artyom.advancednetworkinglectureexample.network.ServiceProvider;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

  public static ErrorResponse parseError(Response<?> response) {
    Converter<ResponseBody, ErrorResponse> converter =
        ServiceProvider.retrofit.responseBodyConverter(ErrorResponse.class, new Annotation[0]);

    ErrorResponse error;

    try {
      error = converter.convert(response.errorBody());
    } catch (IOException e) {
      return new ErrorResponse("Opps, something went wrong");
    }

    return error;
  }
}
