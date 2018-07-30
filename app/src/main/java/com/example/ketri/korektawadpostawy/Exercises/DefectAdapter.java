package com.example.ketri.korektawadpostawy.Exercises;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view ;

        LayoutInflater mInflater = LayoutInflater.from(mContext);

        view = mInflater.inflate(R.layout.item,parent,false);
        ButterKnife.bind(this,view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txt_defect.setText(mData.get(position).getName());

        holder.img.setImageResource(mData.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Intent intent = new Intent(mContext, DefectActivity.class);
                  intent.putExtra("Name", mData.get(position).getName());
                  mContext.startActivity(intent);

//
//                if(position==0) {
//                    Intent intent = new Intent(mContext, DefectActivity.class);
//                    intent.putExtra("Name", mData.get(position).getName());
//                    mContext.startActivity(intent);
//                }
//
//                if(position==1) {
//                    Intent intent = new Intent(mContext, DefectActivity.class);
//                    intent.putExtra("Name", mData.get(position).getName());
//                    mContext.startActivity(intent);
//                }
//
//                if(position==2) {
//                    Intent intent = new Intent(mContext, DefectActivity.class);
//                    intent.putExtra("Name", mData.get(position).getName());
//                    mContext.startActivity(intent);
//                }
//
//                if(position==3) {
//                    Intent intent = new Intent(mContext, DefectActivity.class);
//                    intent.putExtra("Name", mData.get(position).getName());
//                    mContext.startActivity(intent);
//                }
//                if(position==4) {
//                    Intent intent = new Intent(mContext, DefectActivity.class);
//                    intent.putExtra("Name", mData.get(position).getName());
//                    mContext.startActivity(intent);
//                }

            }

        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_defect;
        ImageView img;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            txt_defect = (TextView) itemView.findViewById(R.id.txt_defect) ;
            img = (ImageView) itemView.findViewById(R.id.img);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
