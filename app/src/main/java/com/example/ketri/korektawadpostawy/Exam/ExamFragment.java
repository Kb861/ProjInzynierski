package com.example.ketri.korektawadpostawy.Exam;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ketri.korektawadpostawy.Exercises.ExerciseFragment;
import com.example.ketri.korektawadpostawy.Home.activity.InfoActivity;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExamFragment extends Fragment {

    @BindView(R.id.testBtn)
    Button testBtn;

    public ExamFragment() {
    }
    @OnClick(R.id.testBtn)
    void onClick(View view) {
        Intent intent = new Intent(getActivity(), TestActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_exam, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


}
