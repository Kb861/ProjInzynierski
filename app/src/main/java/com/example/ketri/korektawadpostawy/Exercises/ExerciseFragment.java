package com.example.ketri.korektawadpostawy.Exercises;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExerciseFragment extends Fragment {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    public ExerciseFragment() {
        // Required empty public constructor
    }
    List<Defect> lstDefect;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        ButterKnife.bind(this, view);
        lstDefect = new ArrayList<>();
        lstDefect.add(new Defect("Skolioza", R.drawable.skolioza));
        lstDefect.add( new Defect("Kifoza", R.drawable.kif));
        lstDefect.add( new Defect("Lordoza", R.drawable.lo));
        lstDefect.add( new Defect("Plecy płaskie", R.drawable.plaskie));
        lstDefect.add( new Defect("Plecy okrągło-wklęsłe", R.drawable.okw));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        DefectAdapter defectAdaper = new DefectAdapter(getContext(),lstDefect);
        recycler.setAdapter(defectAdaper);

        return view;

    }
}
