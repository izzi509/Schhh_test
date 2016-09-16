package com.example.marcgregor.schhh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;
import com.example.marcgregor.schhh.fragments.InfoFragment;
import com.example.marcgregor.schhh.fragments.LocalFragment;
import com.example.marcgregor.schhh.fragments.ReservFragment;

public class HotelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);

        vpPager.setAdapter(new HotelsPagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        tabStrip.setViewPager(vpPager);




        Intent i = this.getIntent();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


    @Override
    public void onBackPressed() {


        super.onBackPressed();
    }

    public class HotelsPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[]{"Information", "Localisation", "Reservation"};

        public HotelsPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new InfoFragment();
            } else if (position == 1) {

                return new LocalFragment();
            } else if (position == 2) {

                return new ReservFragment();
            }

            else {
                return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }
    }


    }


