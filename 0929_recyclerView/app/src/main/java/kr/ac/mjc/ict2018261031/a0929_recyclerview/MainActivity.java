package kr.ac.mjc.ict2018261031.a0929_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv_student = findViewById(R.id.rv_student);

        for(int i=0; i<1000; i++) {
            Student student = new Student();
            student.setName("wbc"+i);
            student.setNumber("201826103"+i);
            studentList.add(student);
        }
        StudentAdapter adapter = new StudentAdapter(studentList);
        rv_student.setAdapter(adapter);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rv_student.setLayoutManager(layoutManager);
    }
}