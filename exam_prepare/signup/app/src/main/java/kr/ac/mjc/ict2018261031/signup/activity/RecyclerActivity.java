package kr.ac.mjc.ict2018261031.signup.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.mjc.ict2018261031.signup.R;
import kr.ac.mjc.ict2018261031.signup.VO.Student;
import kr.ac.mjc.ict2018261031.signup.adapter.StudentAdapter;

public class RecyclerActivity extends AppCompatActivity {

    ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv_student = findViewById(R.id.rv_student);

        for (int i = 0; i <= 1000; i++) {
            Student student = new Student();
            student.setName("김민우" + i);
            student.setNumber("201826"+i);
            studentList.add(student);
        }

        StudentAdapter adapter = new StudentAdapter(studentList);
        rv_student.setAdapter(adapter);

        /**
         * this sets RecyclerView to LinearLayout
         */
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        /**
         * this sets RecyclerView to GridLayout, (this == RecyclerActivity, 2 == grid number(width))
         */
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rv_student.setLayoutManager(layoutManager);
    }
}
