package kr.ac.mjc.ict2018261031.a1006_timeline;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
    ArrayList<Photo> mPhotoList;

    public TimelineAdapter(ArrayList<Photo> photoList) {
        this.mPhotoList = photoList;
    }

    @NonNull
    @Override
    public TimelineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineAdapter.ViewHolder holder, int position) {
        Photo photo = mPhotoList.get(position);
        holder.bind(photo);
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView photoIv;
        TextView textTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photoIv = itemView.findViewById(R.id.photo_iv);
            textTv = itemView.findViewById(R.id.text_tv);
        }

        public void bind(Photo photo) {
            Glide.with(photoIv).load(photo.getUrl()).into(photoIv);
            String text = String.format("Cat photo Width: %d, Height %d", photo.getWidth(), photo.getHeight());
            textTv.setText(text);
        }
    }
}
