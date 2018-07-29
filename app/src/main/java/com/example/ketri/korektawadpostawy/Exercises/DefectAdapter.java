package com.example.ketri.korektawadpostawy.Exercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by ketri on 29.07.2018.
 */

public class DefectAdapter extends RecyclerView.Adapter<DefectAdapter.ViewHolder>{

    private Context mContext ;
    private List<Defect> mData ;

    @BindView(R.id.txt_defect)
    TextView txt_defect;

    @BindView(R.id.img)
    ImageView img;



    public DefectAdapter(Context mContext, List<Defect> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
