package kr.ac.mjc.ict2018261031.activity_example;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        EditText et_email = findViewById(R.id.et_email);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        et_email.setText(email);
    }


}
