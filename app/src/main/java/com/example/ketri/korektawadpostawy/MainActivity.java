package com.example.ketri.korektawadpostawy;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.ketri.korektawadpostawy.AboutApp.AboutFragment;
import com.example.ketri.korektawadpostawy.Exam.ExamFragment;
import com.example.ketri.korektawadpostawy.Exercises.ExerciseFragment;
import com.example.ketri.korektawadpostawy.Home.HomeFragment;
import com.example.ketri.korektawadpostawy.Maps.RehabilitationFragment;
import com.example.ketri.korektawadpostawy.Notifications.NotificationsFragment;
import com.example.ketri.korektawadpostawy.Statistics.StatisticFragment;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Stetho.initializeWithDefaults(this);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        openFragmentHome();
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
          this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            openFragmentHome();
        } else if (id == R.id.nav_exam) {
            openFragmentExam();

        } else if (id == R.id.nav_exercise) {
            openFragmentExercise();

        } else if (id == R.id.nav_sport) {
            openFragmentRehabilitation();

        } else if (id == R.id.nav_statistics) {
            openFragmentStatistics();

        } else if (id == R.id.nav_about) {
            openFragmentAbout();
        } else if (id == R.id.nav_notification) {
           openFragmentNoti();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFragmentStatistics() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new StatisticFragment());
        ft.commit();
    }
    private void openFragmentRehabilitation() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new RehabilitationFragment());
        ft.commit();
    }
    private void openFragmentExam() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new ExamFragment());
        ft.commit();
    }
    private void openFragmentExercise() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new ExerciseFragment());
        ft.commit();
    }
    private void openFragmentHome() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new HomeFragment());
        ft.commit();
    }
    private void openFragmentAbout() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new AboutFragment());
        ft.commit();
    }
    private void openFragmentNoti() {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMain,new NotificationsFragment());
        ft.commit();
    }
}
