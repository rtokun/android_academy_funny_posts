package com.example.artyom.advancednetworkinglectureexample.ui.main;

import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.artyom.advancednetworkinglectureexample.R;
import com.example.artyom.advancednetworkinglectureexample.models.Post;
import com.example.artyom.advancednetworkinglectureexample.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

public class PostsRecyclerViewAdapter extends RecyclerView.Adapter<PostViewHolder> {

  private List<Post> mData = new ArrayList<>();

  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
    return new PostViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    Post postAtPosition = mData.get(position);

    // Load image/GIF to imageView
    CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(holder.itemView.getContext());
    circularProgressDrawable.setStrokeWidth(5f);
    circularProgressDrawable.setCenterRadius(30f);
    circularProgressDrawable.start();

    GlideApp.with(holder.itemView)
            .load(postAtPosition.getPictureUrl())
            .placeholder(circularProgressDrawable)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.imageView);

    holder.commentText.setText(postAtPosition.getBestComment());
  }

  @Override
  public int getItemCount() {
    return mData.size();
  }

  public void setData(@NonNull List<Post> newPosts) {
    mData.clear();
    mData.addAll(newPosts);
    notifyDataSetChanged();
  }
}
