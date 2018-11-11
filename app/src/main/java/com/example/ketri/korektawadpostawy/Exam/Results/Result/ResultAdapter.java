package com.example.ketri.korektawadpostawy.Exam.Results.Result;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.Exercises.activities.DefectActivity;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.example.ketri.korektawadpostawy.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;


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
        holder.setAtt(results.get(position).getAttention());
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

        @BindView(R.id.namedefs)
        TextView namedefs;
        private ArrayList<Defect> defectsList;

        DataBaseHelper myDb;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            myDb=new DataBaseHelper(itemView.getContext());
            defectsList =new ArrayList<>();

            defectsList.addAll(myDb.getDefect());
            check.setVisibility(View.INVISIBLE);


        }

        public void setName(String name) {
            txt_def.setText(name);
        }
        public void setDesc(String desc) {
            txt_advice.setText(desc);
        }

        public void setAtt(String att) {
     namedefs.setText(att);
        }
    }
}
