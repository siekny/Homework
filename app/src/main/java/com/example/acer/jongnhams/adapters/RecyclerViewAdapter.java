package com.example.acer.jongnhams.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.acer.jongnhams.model.Anime;

import com.example.acer.jongnhams.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Anime> data;
    RequestOptions option;


    public RecyclerViewAdapter(Context context, List<Anime> data) {
        this.context = context;
        this.data = data;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.anime_row_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvName.setText(data.get(position).getName());
        holder.tvDiscount.setText(data.get(position).getDiscount());

        // Load image and set it into imageView
        Glide.with(context).load(data.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvDiscount;
        ImageView img_thumbnail;
        public MyViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.anime_name);
            tvDiscount = itemView.findViewById(R.id.dicount);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }
}
