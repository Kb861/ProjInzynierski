package com.example.ketri.korektawadpostawy.Exam;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ketri.korektawadpostawy.Exercises.ExerciseFragment;
import com.example.ketri.korektawadpostawy.Exercises.adapters.DefectAdapter;
import com.example.ketri.korektawadpostawy.Exercises.model.Defect;
import com.example.ketri.korektawadpostawy.Home.activity.InfoActivity;
import com.example.ketri.korektawadpostawy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


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
        lstExam.add(new Item(R.drawable.pool,"Badanie"));
        lstExam.add( new Item(R.drawable.b,"Zasady"));
        lstExam.add( new Item(R.drawable.spine,"Wyniki"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler.setLayoutManager(layoutManager);

       AdapterExam adapterExam = new AdapterExam(getContext(),lstExam);
       recycler.setAdapter(adapterExam);

        return view;
    }


}
