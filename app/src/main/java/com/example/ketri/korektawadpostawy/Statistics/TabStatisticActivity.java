package com.example.ketri.korektawadpostawy.Statistics;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ketri.korektawadpostawy.R;
import com.example.ketri.korektawadpostawy.Statistics.Tabs.CircleChartFragment;
import com.example.ketri.korektawadpostawy.Statistics.Tabs.LineChartFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabStatisticActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_action_chart,
            R.drawable.ic_action_points,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_statistic);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        SupportActionBarBack();
    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new LineChartFragment(), "ONE");
        adapter.addFrag(new CircleChartFragment(), "TWO");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> FragmentList = new ArrayList<>();
        private final List<String> FragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentList.get(position);
        }

        @Override
        public int getCount() {
            return FragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            FragmentList.add(fragment);
            FragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
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
