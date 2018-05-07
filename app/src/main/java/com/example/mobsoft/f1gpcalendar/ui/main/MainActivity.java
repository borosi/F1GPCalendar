package com.example.mobsoft.f1gpcalendar.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.example.mobsoft.f1gpcalendar.AnalyticsApplication;
import com.example.mobsoft.f1gpcalendar.F1GPCalendarApplication;
import com.example.mobsoft.f1gpcalendar.R;
import com.example.mobsoft.f1gpcalendar.ui.guesses.GuessesFragment;
import com.example.mobsoft.f1gpcalendar.ui.newguess.NewGuessFragment;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fabric.with(this, new Crashlytics());

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("F1 GP Calendar");
        setSupportActionBar(toolbar);

        sectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new MainFragment(), "Races");
        sectionsPageAdapter.addFragment(new GuessesFragment(), "Guesses");

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(sectionsPageAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


    protected class SectionsPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList;
        private final List<String> fragmentTitleList;

        public SectionsPageAdapter(FragmentManager fm) {
            super(fm);
            fragmentList = new ArrayList<Fragment>();
            fragmentTitleList = new ArrayList<String>();
        }

        public void addFragment(Fragment fragment, String fragmentTitle) {
            this.fragmentList.add(fragment);
            this.fragmentTitleList.add(fragmentTitle);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
