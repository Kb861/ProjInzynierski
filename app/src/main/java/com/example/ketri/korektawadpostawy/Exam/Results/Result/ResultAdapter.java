package com.example.ketri.korektawadpostawy.Exam.Results.Result;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Exam.Results.ResultActivity;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.ExerciseFragment;

import com.example.ketri.korektawadpostawy.Exercises.activities.DefectActivity;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ketri on 09.11.2018.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>{
    ArrayList<Result> results =new ArrayList<>();
    public ResultAdapter(ArrayList<Result> results) {
        this.results = results;
    }

    @Override
    public ResultAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_examination, null);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ResultAdapter.ViewHolder holder, int position) {
        holder.setName(results.get(position).getDefectName());
        holder.setDesc(results.get(position).getDefectDescrip());
        holder.btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DefectActivity.class);
                intent.putExtra("KEY", results.get(position).getDefectName());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {return results.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_def)
        TextView txt_def;

        @BindView(R.id.txt_advice)
        TextView txt_advice;

        @BindView(R.id.btn_go)
        Button btn_go;

        @BindView(R.id.check)
        ImageView check;

        @BindView(R.id.namedef)
        TextView namedef;

        DataBaseHelper myDb;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            myDb=new DataBaseHelper(itemView.getContext());
            check.setVisibility(View.INVISIBLE);
       if(check.getVisibility()==View.INVISIBLE) {
                namedef.setText(String.valueOf(myDb.getDefect()));
                if (txt_def.getText().toString().contains("Skolioza")) {
                    //check.setVisibility(View.VISIBLE);
                    txt_advice.setText("hello");
                }
                txt_def.setText(String.valueOf(myDb.getDefectKif()));
                if(txt_def.getText().toString().contains("Kifoza")){
                    check.setVisibility(View.VISIBLE);
                }

            }else{

                check.setVisibility(View.INVISIBLE);

            }

        }

        public void setName(String name) {
            txt_def.setText(name);
        }
        public void setDesc(String desc) {
            txt_advice.setText(desc);
        }
    }
}
