package com.example.artyom.advancednetworkinglectureexample.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.artyom.advancednetworkinglectureexample.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

  ImageView imageView;
  TextView commentText;

  public PostViewHolder(View itemView) {
    super(itemView);
    imageView = itemView.findViewById(R.id.imageView);
    commentText = itemView.findViewById(R.id.comment);
  }
}
