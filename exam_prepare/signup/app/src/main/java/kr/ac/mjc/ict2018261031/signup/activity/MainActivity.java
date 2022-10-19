package kr.ac.mjc.ict2018261031.signup.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kr.ac.mjc.ict2018261031.signup.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_signin = findViewById(R.id.btn_signin);
        Button btn_signup = findViewById(R.id.btn_signup);
        EditText et_email = findViewById(R.id.et_email);
        EditText et_pw = findViewById(R.id.et_pw);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString();
                Toast.makeText(MainActivity.this, "welcome" + email, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DownloadActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);

                String email = et_email.getText().toString();
                intent.putExtra("email", email);

                startActivity(intent);
            }
        });

        /*
        ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                et_email.setText(result.getData().toString());
            }

            if (result.getResultCode() == RESULT_CANCELED) {
                return;
            }
        });*/
    }



}