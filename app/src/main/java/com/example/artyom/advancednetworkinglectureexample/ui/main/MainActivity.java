package com.example.artyom.advancednetworkinglectureexample.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.artyom.advancednetworkinglectureexample.R;
import com.example.artyom.advancednetworkinglectureexample.models.ErrorResponse;
import com.example.artyom.advancednetworkinglectureexample.models.Post;
import com.example.artyom.advancednetworkinglectureexample.network.FunnyPostsService;
import com.example.artyom.advancednetworkinglectureexample.network.ServiceProvider;
import com.example.artyom.advancednetworkinglectureexample.utils.ErrorUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private FunnyPostsService mPostsService;
  private PostsRecyclerViewAdapter mAdapter;
  private RecyclerView mPostsRecyclerView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    mAdapter = new PostsRecyclerViewAdapter();

    mPostsRecyclerView = findViewById(R.id.postsRecyclerView);
    mPostsRecyclerView.setAdapter(mAdapter);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(
        view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Bla", v -> {})
                .show());

    initRESTService();
    getFunnyPosts();
  }

  private void initRESTService() {
    mPostsService = ServiceProvider.createService(FunnyPostsService.class);
  }

  private void getFunnyPosts() {
    mPostsService
        .getPosts()
        .enqueue(
            new Callback<List<Post>>() {

              @Override
              public void onResponse(
                  @NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                  mAdapter.setData(response.body());
                } else {
                  ErrorResponse errorResponse = ErrorUtils.parseError(response);
                  Toast.makeText(
                          MainActivity.this,
                          errorResponse != null
                              ? errorResponse.getMessage()
                              : "Unknown error occurred",
                          Toast.LENGTH_LONG)
                      .show();
                }
              }

              @Override
              public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
              }
            });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.download_video_of_the_day) {
      return true;
    }

    //noinspection SimplifiableIfStatement
    if (id == R.id.menu_refresh) {
      getFunnyPosts();
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
