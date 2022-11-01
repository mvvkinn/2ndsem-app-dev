package kr.ac.mjc.itc_2018261031;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class UserinfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinfo);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        TextView tv_userinfo = findViewById(R.id.tv_userinfo);
        Button btn_signout = findViewById(R.id.btn_signout);


        tv_userinfo.setText(auth.getCurrentUser().getEmail());

        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Toast.makeText(UserinfoActivity.this, "로그아웃 되었습니다", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(UserinfoActivity.this, MainActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }



}
