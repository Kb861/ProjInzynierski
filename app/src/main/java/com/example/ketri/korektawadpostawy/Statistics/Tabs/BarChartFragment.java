package com.example.ketri.korektawadpostawy.Statistics.Tabs;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarChartFragment extends Fragment {

    public BarChartFragment() {
    }

    @BindView(R.id.line_graph)
    GraphView graph;

    BarGraphSeries<DataPoint> series ;
    DataBaseHelper myDb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        ButterKnife.bind(this, view);

        myDb=new DataBaseHelper(getContext());
        try {
            series=new BarGraphSeries<DataPoint>(myDb.getPointsDateTab());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        graph.addSeries(series);
        graphStyles();
        return view;
    }

    private void graphStyles() {
        series.setDrawValuesOnTop(true);
        series.setColor(Color.GRAY);
        series.setTitle("punkty");
        series.getDataWidth();
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
        graph.getGridLabelRenderer().setNumHorizontalLabels(4);
        graph.getGridLabelRenderer().setNumVerticalLabels(4);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);
        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
    }
}
