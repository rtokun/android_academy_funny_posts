package com.example.artyom.advancednetworkinglectureexample.models;

import com.google.gson.annotations.SerializedName;

public class Post {

  @SerializedName("link")
  private String pictureUrl;

  @SerializedName("comment")
  private String bestComment;

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String url) {
    this.pictureUrl = url;
  }

  public String getBestComment() {
    return bestComment;
  }

  public void setBestComment(String bestComment) {
    this.bestComment = bestComment;
  }
}
