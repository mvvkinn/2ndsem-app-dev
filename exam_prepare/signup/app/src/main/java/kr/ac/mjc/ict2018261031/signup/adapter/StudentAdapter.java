package kr.ac.mjc.ict2018261031.signup.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kr.ac.mjc.ict2018261031.signup.R;
import kr.ac.mjc.ict2018261031.signup.VO.Student;
import kr.ac.mjc.ict2018261031.signup.activity.CatTimelineActivity;


/**
 * 1. implement class StudentAdapter.ViewHolder
 * 2. implement methods
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    ArrayList<Student> mList;

    public StudentAdapter(ArrayList<Student> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // convert xml to view and load to memory
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = mList.get(position);
        holder.bind(student);
    }

    /**
     * @return size of items to set length of items shown in view
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * Set text to TextView using class Student
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);


        }

        public void bind(Student student) {
            tv_name.setText(student.getName());
            tv_number.setText(student.getNumber());
        }
    }
}
