package com.example.ketri.korektawadpostawy.Statistics.Tabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleChartFragment extends Fragment {

    @BindView(R.id.point)
    TextView point;

    public CircleChartFragment() {

    }
    DataBaseHelper myDb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_circle_chart, container, false);
        ButterKnife.bind(this, view);
        myDb=new DataBaseHelper(getContext());
        point.setText(String.valueOf(myDb.getSUM()));

        return view;
    }
}
