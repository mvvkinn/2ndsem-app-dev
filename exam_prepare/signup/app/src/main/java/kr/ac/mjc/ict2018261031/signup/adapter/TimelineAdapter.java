package kr.ac.mjc.ict2018261031.signup.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.ac.mjc.ict2018261031.signup.R;
import kr.ac.mjc.ict2018261031.signup.VO.Photo;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    ArrayList<Photo> mPhotoList;

    public TimelineAdapter(ArrayList<Photo> photoList) {
        this.mPhotoList = photoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext()))
                .inflate(R.layout.item_photo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo photo = mPhotoList.get(position);
        holder.bind(photo);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_photo;
        TextView tv_info;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_photo = itemView.findViewById(R.id.iv_photo);
            tv_info = itemView.findViewById(R.id.tv_info);
        }

        public void bind(Photo photo) {
            Glide.with(iv_photo).load(photo.getUrl()).into(iv_photo);
            String text = String.format("Cat photo width = %d height = %d", photo.getWidth(), photo.getHeight());

            tv_info.setText(text);
        }
    }
}
