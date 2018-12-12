package com.example.ketri.korektawadpostawy.Notifications;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.ketri.korektawadpostawy.R;


import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationsFragment extends Fragment {
    public NotificationsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        ButterKnife.bind(this, view);
        goToNotificationActivity();
        return view;

    }

    private void goToNotificationActivity() {
        Thread myThread = new Thread(){

            @Override
            public void run() {
                try{
                    sleep(1000);
                    Intent intent = new Intent(getActivity(), NotificationActivity.class);
                    startActivity(intent);
                    getActivity().finish();}
                catch (InterruptedException e)
                {e.printStackTrace();}
            }
        };
        myThread.start();
    }

}
