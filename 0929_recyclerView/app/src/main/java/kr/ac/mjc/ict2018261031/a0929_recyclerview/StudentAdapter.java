package kr.ac.mjc.ict2018261031.a0929_recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    ArrayList<Student> mList;

    public StudentAdapter(ArrayList<Student> list) {
        this.mList = list;
    }

    //여분 viewholder 생성(상,하단 여분 몇개)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("StudentAdapter", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("StudentAdapter", String.format("onBindViewHolder[%d]", position));
        Student student = mList.get(position);
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        Log.d("StudentAdapter", String.format("getItemCount[%d]", mList.size()));
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_name = itemView.findViewById(R.id.tv_name);
            this.tv_number = itemView.findViewById(R.id.tv_number);
        }

        public void bind(Student student) {
            this.tv_name.setText(student.getName());
            this.tv_number.setText(student.getNumber());
        }
    }
}
