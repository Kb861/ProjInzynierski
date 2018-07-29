package com.example.ketri.korektawadpostawy.Exercises;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ketri.korektawadpostawy.R;

import java.util.List;

import butterknife.BindView;


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
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

}
