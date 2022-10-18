package kr.ac.mjc.ict2018261031.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText et_name = findViewById(R.id.et_name);
        EditText et_email = findViewById(R.id.et_email);
        EditText et_pw = findViewById(R.id.et_pw);
        EditText et_repeat_pw = findViewById(R.id.et_repeat_pw);
        Button btn_signup = findViewById(R.id.btn_signup);
        Button btn_cancel = findViewById(R.id.btn_cancel);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");

        et_email.setText(email);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);

                intent.putExtra("email", et_email.getText().toString());
                intent.putExtra("pw", et_pw.getText().toString());

                finish();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
