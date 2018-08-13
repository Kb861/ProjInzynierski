package com.example.ketri.korektawadpostawy.Exercises.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.ketri.korektawadpostawy.Exercises.Defect;
import com.example.ketri.korektawadpostawy.Exercises.DefectActivity;
import com.example.ketri.korektawadpostawy.Exercises.activities.ExerciseActivity;
import com.example.ketri.korektawadpostawy.Exercises.model.ExerciseModel;
import com.example.ketri.korektawadpostawy.R;

import java.util.List;

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
//        options = new RequestOptions()
//
//                .centerCrop()
//
//                .placeholder(R.drawable.spine)
//
//                .error(R.drawable.spine);
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

                // sending data process


                i.putExtra("exercise_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("ex_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("ex_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());

                i.putExtra("ex_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());

                i.putExtra("ex_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());

                i.putExtra("ex_rating",mData.get(viewHolder.getAdapterPosition()).getRating());

                i.putExtra("ex_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());



                mContext.startActivity(i);
            }
        });
        // click listener here

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvname.setText(mData.get(position).getName());

        holder.tv_rate.setText(mData.get(position).getRating());

        holder.tv_studio.setText(mData.get(position).getStudio());

        holder.tvcat.setText(mData.get(position).getCategorie());



        // load image from the internet using Glide

        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(options).into(holder.img_thumb);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tv_rate,tvcat,tv_studio;
        ImageView img_thumb;
       LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.exercise_name);



            tv_rate = itemView.findViewById(R.id.rating);

            tvcat = itemView.findViewById(R.id.categorie);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumb = itemView.findViewById(R.id.thumbnail);

            view_container=itemView.findViewById(R.id.container);
        }
    }
}
