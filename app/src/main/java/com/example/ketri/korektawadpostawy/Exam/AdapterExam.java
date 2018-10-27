package com.example.ketri.korektawadpostawy.Exam;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Exercises.adapters.DefectAdapter;
import com.example.ketri.korektawadpostawy.Exercises.adapters.RecyclerViewAdapter;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ketri on 27.10.2018.
 */

public class AdapterExam extends RecyclerView.Adapter<AdapterExam.ViewHolder>{

    Context Context ;
    List<Item> Data ;

    public AdapterExam(Context context, List<Item> data) {
        this.Context = context;
        this.Data = data;
    }

    @Override
    public AdapterExam.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(Context);
        view = mInflater.inflate(R.layout.card_exam_item,parent,false);
        ButterKnife.bind(this,view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterExam.ViewHolder holder, int position) {
        holder.background.setImageResource(Data.get(position).getBackground());
        holder.cardName.setText(Data.get(position).getCardName());
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_nameCardView)
        TextView cardName;

        @BindView(R.id.imgBtn_exam)
        ImageButton background;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
