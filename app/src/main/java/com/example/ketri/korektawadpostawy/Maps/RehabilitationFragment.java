package com.example.ketri.korektawadpostawy.Maps;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.Home.activity.InfoActivity;
import com.example.ketri.korektawadpostawy.R;
import com.transitionseverywhere.TransitionManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RehabilitationFragment extends Fragment {
    @BindView(R.id.l2)
    LinearLayout l2;
    @BindView(R.id.transitions_container)
    LinearLayout transitions_container;
    @BindView(R.id.btnInf)
    Button btnInf;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.txt_rehabilitation)
    TextView txt_rehabilitation;
    boolean visible;
    Animation downtoup;

    @OnClick(R.id.btnInf)
    void onClick(View view) {
        TransitionManager.beginDelayedTransition(transitions_container);
        visible = !visible;
        txt_rehabilitation.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public RehabilitationFragment() {
    }

    @OnClick(R.id.btnSearch)
    void onClick1(View view) {
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rehabilitation, container, false);
        ButterKnife.bind(this, view);
        downtoup = AnimationUtils.loadAnimation(this.getActivity(), R.anim.downtoup);
        l2.setAnimation(downtoup);
        return view;
    }

}
