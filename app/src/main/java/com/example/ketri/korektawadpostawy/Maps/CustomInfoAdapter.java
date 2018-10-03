package com.example.ketri.korektawadpostawy.Maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by ketri on 02.10.2018.
 */

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter {

    private final View Window;
    private Context context;

    public CustomInfoAdapter(Context context) {
        context = context;
        Window = LayoutInflater.from(context).inflate(R.layout.custom_info, null);
    }
    private void rendowWindowText(Marker marker, View view){

        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);

        if(!title.equals("")){
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView tvSnippet = (TextView) view.findViewById(R.id.snippet);

        if(!snippet.equals("")){
            tvSnippet.setText(snippet);
        }
    }
    @Override
    public View getInfoWindow(Marker marker) {
        rendowWindowText(marker, Window);
        return Window;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendowWindowText(marker, Window);
        return Window;
    }
}
