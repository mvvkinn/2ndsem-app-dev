package kr.ac.mjc.ict2018261031.signup.activity;

/**
 * This activity shows how background works
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import kr.ac.mjc.ict2018261031.signup.R;
import kr.ac.mjc.ict2018261031.signup.service.BackgroundService;

public class DownloadActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        Button btn_download = findViewById(R.id.btn_download);

        Button btn_cat = findViewById(R.id.btn_cat);

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DownloadActivity.this, BackgroundService.class);
                startService(intent);

                finish();
            }
        });

        btn_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(DownloadActivity.this, CatTimelineActivity.class);
                startActivity(intent);
            }
        });
    }
}
