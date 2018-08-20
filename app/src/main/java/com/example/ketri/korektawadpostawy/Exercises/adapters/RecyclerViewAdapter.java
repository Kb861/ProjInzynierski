package com.example.ketri.korektawadpostawy.Exercises.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ketri.korektawadpostawy.Exercises.activities.ExerciseActivity;
import com.example.ketri.korektawadpostawy.Exercises.model.ExerciseModel;
import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ketri on 30.07.2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
RequestOptions options ;

    private Context mContext ;
    private List<ExerciseModel> mData ;
    public RecyclerViewAdapter(Context mContext, List<ExerciseModel>mData) {

        this.mContext = mContext;
        this.mData = mData;
        options=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.ex_defect_item,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ExerciseActivity.class);
                i.putExtra("exercise_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("ex_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("ex_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("ex_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("ex_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());
                i.putExtra("ex_video",mData.get(viewHolder.getAdapterPosition()).getVideo());
                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tvname.setText(mData.get(position).getName());
        holder.tv_rate.setText(mData.get(position).getRating());
        holder.tvcat.setText(mData.get(position).getCategorie());
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.img_thumb);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.exercise_name)
        TextView tvname;

        @BindView(R.id.categorie)
        TextView tvcat;

        @BindView(R.id.rating)
        TextView tv_rate;

        @BindView(R.id.thumbnail)
        ImageView img_thumb;

        @BindView(R.id.container)
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
