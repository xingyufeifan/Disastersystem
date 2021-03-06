package com.nandity.disastersystem.activity;

import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nandity.disastersystem.R;
import com.nandity.disastersystem.adapter.MyFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //初始化视图
        initViews();
        setListeners();

    }

    private void setListeners() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position=tab.getPosition();
                //Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
                one.setIcon(R.mipmap.workbench);
                two.setIcon(R.mipmap.directory);
                three.setIcon(R.mipmap.setup);
                switch (position){
                    case 0: tab.setIcon(R.mipmap.workbench1);
                            break;
                    case 1: tab.setIcon(R.mipmap.directory1);
                            break;
                    case 2: tab.setIcon(R.mipmap.setup1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void initViews() {

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager= (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);

        //设置Tab的图标，假如不需要则把下面的代码删去
        one.setIcon(R.mipmap.workbench1);
        two.setIcon(R.mipmap.directory);
        three.setIcon(R.mipmap.setup);


    }
}
