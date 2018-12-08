package com.example.ketri.korektawadpostawy.AboutApp;


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
public class AboutFragment extends Fragment {

    public AboutFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        threadforIntent();
        return view;
    }

    private void threadforIntent() {
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                    Intent intent = new Intent(getActivity(), AboutAppActivity.class);
                    startActivity(intent);
                    getActivity().finish();}
                catch (InterruptedException e)
                {e.printStackTrace();}
            }
        };
        myThread.start();
    }
}
