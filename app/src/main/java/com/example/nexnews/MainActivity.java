package com.example.nexnews;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tablayout;
    TabItem tabhome,tabtech,tabentertainment,tabhealth,tabbusiness,tabscience,tabsports;
    PagerAdapter pagerAdapter;
    Toolbar newstoolbar;

    String apikey = "112467e9d55741bab456a359cbd467d0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        newstoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(newstoolbar);

        tabhome = findViewById(R.id.home);
        tabentertainment = findViewById(R.id.entertainment);
        tabtech = findViewById(R.id.technology);
        tabhealth = findViewById(R.id.health);
        tabbusiness = findViewById(R.id.business);
        tabscience = findViewById(R.id.science);
        tabsports = findViewById(R.id.sports);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tablayout = findViewById(R.id.include);



        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5 ||tab.getPosition() == 6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

    }
}