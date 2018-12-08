package com.example.ketri.korektawadpostawy.Exercises;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ketri.korektawadpostawy.Exercises.adapters.DefectAdapter;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
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
    }
    List<Defect> lstDefect;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        ButterKnife.bind(this, view);
        lstDefect = new ArrayList<>();
        lstDefect.add(new Defect("Skolioza", R.drawable.scoliosis));
        lstDefect.add( new Defect("Kifoza", R.drawable.kyphosis));
        lstDefect.add( new Defect("Lordoza", R.drawable.lordosis));
        lstDefect.add( new Defect("Plecy płaskie", R.drawable.flat));
        lstDefect.add( new Defect("Plecy okrągło-wklęsłe", R.drawable.round));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler.setLayoutManager(layoutManager);

        DefectAdapter defectAdaper = new DefectAdapter(getContext(),lstDefect);
        recycler.setAdapter(defectAdaper);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
