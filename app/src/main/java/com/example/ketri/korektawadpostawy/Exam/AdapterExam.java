package com.example.ketri.korektawadpostawy.Exam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Exam.Examination.ExaminationActivity;
import com.example.ketri.korektawadpostawy.Exam.Instruction.RulesActivity;
import com.example.ketri.korektawadpostawy.Exam.Results.ResultActivity;
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

        @BindView(R.id.img_exam)
        ImageView background;
        Button btn_go;

        public ViewHolder(final View itemView) {

            super(itemView);
            btn_go=(Button)itemView.findViewById(R.id.btn_go);
            btn_go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(cardName.getText().toString().equals("Badanie")){
                        goToExaminationActivity();
                    }
                    if(cardName.getText().toString().equals("Zasady")){
                        goToRulesActivity();
                    }
                    if(cardName.getText().toString().equals("Wyniki")){
                        goToResultActivity();
                    }
                }

                private void goToResultActivity() {
                    Intent intent = new Intent(itemView.getContext(), ResultActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtras(bundle);
                    Context context = itemView.getContext();
                    context.startActivity(intent);
                }

                private void goToRulesActivity() {
                    Intent intent = new Intent(itemView.getContext(), RulesActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtras(bundle);
                    Context context = itemView.getContext();
                    context.startActivity(intent);
                }

                private void goToExaminationActivity() {
                    Intent intent = new Intent(itemView.getContext(), ExaminationActivity.class);
                    Bundle bundle = new Bundle();
                    intent.putExtras(bundle);
                    Context context = itemView.getContext();
                    context.startActivity(intent);
                }
            });
            ButterKnife.bind(this, itemView);
        }
    }
}
