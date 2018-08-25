package com.example.ketri.korektawadpostawy.Home;


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

import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.btnMain)
    Button btnMain;

    @BindView(R.id.l1)
    LinearLayout l1;

    @BindView(R.id.l2)
    LinearLayout l2;

    Animation uptodown,downtoup;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        uptodown= AnimationUtils.loadAnimation(this.getActivity(), R.anim.uptodown);
        downtoup= AnimationUtils.loadAnimation(this.getActivity(), R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
        return view;

    }

}
