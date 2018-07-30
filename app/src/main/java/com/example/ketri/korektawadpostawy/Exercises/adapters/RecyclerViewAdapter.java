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

    public RecyclerViewAdapter(Context mContext, List lst) {

        this.mContext = mContext;
        this.mData = mData;
        options = new RequestOptions()

                .centerCrop()

                .placeholder(R.drawable.spine)

                .error(R.drawable.spine);
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


                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());


                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());


                i.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());





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


        holder.tvcat.setText(mData.get(position).getCategorie());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tv_rate,tvcat;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.rowname);



            tv_rate = itemView.findViewById(R.id.rating);

            tvcat = itemView.findViewById(R.id.categorie);
            view_container=itemView.findViewById(R.id.container);
        }
    }
}
