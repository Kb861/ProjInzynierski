package com.example.ketri.korektawadpostawy.Statistics.Tabs;


import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PointsFragment extends Fragment {

    @BindView(R.id.point)
    TextView point;

    @BindView(R.id.txv_consolation)
    TextView consolation;

    public PointsFragment() {
    }
    DataBaseHelper myDb;
    Dialog epicDialog;
    ImageView close;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_points, container, false);
        ButterKnife.bind(this, view);

        epicDialog=new Dialog(getContext());
        myDb=new DataBaseHelper(getContext());
        point.setText(String.valueOf(myDb.getSUM()));

         if(point.getText().toString().contains("50") || point.getText().toString().contains("100")) {
             ShowBox();}

         if(point.getText().toString().contains("150")) {
             consolation.setText("Jesteś mistrzem!");}
        return view;
    }
    public void ShowBox(){
        epicDialog.setContentView(R.layout.dialog_box);
        close=(ImageView) epicDialog.findViewById(R.id.close_box) ;
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                epicDialog.dismiss();
            }
        });
        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.show();
    }
}
