package com.example.ketri.korektawadpostawy.Statistics.Tabs;


import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ketri.korektawadpostawy.Exercises.DataBaseHelper;
import com.example.ketri.korektawadpostawy.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineChartFragment extends Fragment {

    public LineChartFragment() {
    }

    @BindView(R.id.line_graph)
    GraphView graph;
    LineGraphSeries<DataPoint> series;
    DataBaseHelper myDb;
    int [] tab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        ButterKnife.bind(this, view);
        myDb=new DataBaseHelper(getContext());
  //series=new LineGraphSeries<DataPoint>(getData());
        series=new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        graph.addSeries(series);
        return view;
    }
// private DataPoint[]getData(){
//
//   Cursor res = myDb.getAllData();
//
//      DataPoint[] dp =new DataPoint[res.getCount()];
//    int[] tab=new int[2];
//    if(res.getString(4)== "R.string.bad")
//    {
//    tab[0]=1;
//    }
//     if(res.getString(4)== "R.string.good")
//     {
//         tab[1]=3;
//     }
//     if(res.getString(4)== "R.string.great")
//     {
//         tab[2]=5;
//     }
//
//        for(int i=0;i<res.getCount();i++)
//        {
//            res.moveToNext();
//            dp[i]=new DataPoint(Double.parseDouble(formatDate(res.getColumnName(1))), Double.parseDouble(res.getColumnName(3)));
//
//        }
//
//
//
// return dp;
//        // styling
//
// }
    private String formatDate(String dateStr) {


        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM");
        String date =sdf.format(new Date());
        return date;




    }

}
