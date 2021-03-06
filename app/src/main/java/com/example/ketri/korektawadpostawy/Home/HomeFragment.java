package com.example.ketri.korektawadpostawy.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ketri.korektawadpostawy.AboutApp.AboutAppActivity;
import com.example.ketri.korektawadpostawy.Exam.ExamFragment;
import com.example.ketri.korektawadpostawy.Exercises.ExerciseFragment;
import com.example.ketri.korektawadpostawy.Home.activity.InfoActivity;
import com.example.ketri.korektawadpostawy.Notifications.NotificationActivity;
import com.example.ketri.korektawadpostawy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @BindView(R.id.start)
    Button start;

    @BindView(R.id.exam)
    Button exam;

    @BindView(R.id.btn_informationApp)
    Button btn_informationApp;

    @BindView(R.id.btn_notif)
    Button btn_notif;

    Animation uptodown, downtoup;

    @OnClick(R.id.btnMain)
    void onClickInfo(View view) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @OnClick(R.id.btn_informationApp)
    void onClickAboutApp(View view) {
        Intent intent = new Intent(getActivity(), AboutAppActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @OnClick(R.id.btn_notif)
    void onClickNotification(View view) {
        Intent intent = new Intent(getActivity(), NotificationActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }
    @OnClick(R.id.start)
    void onClickStart(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.flMain, new ExerciseFragment());
        ft.commit();
    }
    @OnClick(R.id.exam)
    void onClickExam(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.flMain, new ExamFragment());
        ft.commit();
    }

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        uptodown = AnimationUtils.loadAnimation(this.getActivity(), R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this.getActivity(), R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
        return view;
    }
}
