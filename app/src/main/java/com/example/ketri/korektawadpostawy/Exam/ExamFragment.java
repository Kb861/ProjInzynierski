package com.example.ketri.korektawadpostawy.Exam;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExamFragment extends Fragment {


    @BindView(R.id.recyclerExam)
    RecyclerView recycler;
    List<Item> lstExam;

    public ExamFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_exam, container, false);
        ButterKnife.bind(this, view);

        Window w = getActivity().getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        lstExam = new ArrayList<>();
        lstExam.add(new Item(R.drawable.examination,"Badanie"));
        lstExam.add( new Item(R.drawable.rules,"Zasady"));
        lstExam.add( new Item(R.drawable.doctor,"Wyniki"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        AdapterExam adapterExam = new AdapterExam(getContext(),lstExam);
        recycler.setAdapter(adapterExam);

        return view;
    }


}
