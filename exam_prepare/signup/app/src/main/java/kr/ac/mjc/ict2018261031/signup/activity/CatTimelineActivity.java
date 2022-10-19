package kr.ac.mjc.ict2018261031.signup.activity;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import kr.ac.mjc.ict2018261031.signup.R;
import kr.ac.mjc.ict2018261031.signup.VO.Photo;
import kr.ac.mjc.ict2018261031.signup.adapter.TimelineAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CatTimelineActivity extends AppCompatActivity {

    ArrayList<Photo> mPhotoList = new ArrayList<>();
    TimelineAdapter timelineAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        ViewPager2 viewPager = findViewById(R.id.viewpager);

        Handler handler = new Handler();

        timelineAdapter = new TimelineAdapter(mPhotoList);
        viewPager.setAdapter(timelineAdapter);

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url("https://api.thecatapi.com/v1/images/search?limit=10")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                throw new Error("Error GET: " + e.getMessage(), e.getCause());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String body = response.body().string();

                Gson gson = new Gson();
                ArrayList<Photo> photoList;

                Type listType = new TypeToken<ArrayList<Photo>>() {
                }.getType();
                photoList = gson.fromJson(body, listType);

                mPhotoList.addAll(photoList);

                handler.post(() -> timelineAdapter.notifyDataSetChanged());
            }
        });
    }
}
