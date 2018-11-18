package com.example.ketri.korektawadpostawy.Notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.ketri.korektawadpostawy.BackArrowToHome;
import com.example.ketri.korektawadpostawy.NotificationReceiver;
import com.example.ketri.korektawadpostawy.R;
import java.util.Calendar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends AppCompatActivity implements BackArrowToHome {

    @BindView(R.id.et_time)
    EditText et_time;
    int currentHour;
    int currentMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        SupportActionBarBack();
        Calendar calendar = Calendar.getInstance();
        et_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentHour=calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute=calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(NotificationActivity.this, new TimePickerDialog.OnTimeSetListener() {
              @Override
             public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                et_time.setText(String.format("%02d:%02d", hourOfDay, minutes));
                 AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                 Intent notificationIntent = new Intent(NotificationActivity.this, NotificationReceiver.class);
                 PendingIntent broadcast = PendingIntent.getBroadcast(NotificationActivity.this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                 calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                 calendar.set(Calendar.MINUTE,minutes);
                 alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), broadcast);
            }
        }, currentHour, currentMinute, false);
        timePickerDialog.show();
    }
});
    }
    @Override
    public void SupportActionBarBack() {
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
