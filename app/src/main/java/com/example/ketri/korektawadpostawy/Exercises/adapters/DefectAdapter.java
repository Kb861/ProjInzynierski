package com.example.ketri.korektawadpostawy.Exercises.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Exercises.activities.DefectActivity;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ketri on 29.07.2018.
 */

public class DefectAdapter extends RecyclerView.Adapter<DefectAdapter.ViewHolder>{

    private Context Context ;
    private List<Defect> Data ;

    public DefectAdapter(Context mContext, List<Defect> mData) {
        this.Context = mContext;
        this.Data = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(Context);
        view = mInflater.inflate(R.layout.item,parent,false);
        ButterKnife.bind(this,view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txt_defect.setText(Data.get(position).getName());

        holder.img.setImageResource(Data.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent(Context, DefectActivity.class);
                intent.putExtra("KEY", Data.get(position).getName());
                Context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_defect)
        TextView txt_defect;

        @BindView(R.id.img)
        ImageView img;

        @BindView(R.id.card_view)
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
