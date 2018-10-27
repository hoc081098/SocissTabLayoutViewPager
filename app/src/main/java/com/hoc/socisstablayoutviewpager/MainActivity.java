package com.hoc.socisstablayoutviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    TabLayout tabLayout = findViewById(R.id.tab_layout);
    ViewPager viewPager = findViewById(R.id.view_pager);

    tabLayout.setupWithViewPager(viewPager);

    List<Fragment> fragments = Arrays.asList(new FirstFragment(), new SecondFragment(), new ThirdFragment());
    List<CharSequence> titles = Arrays.<CharSequence>asList("One", "Two", "Three");
    viewPager.setAdapter(new SectionFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles));
  }


  private static final class SectionFragmentPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments;
    private final List<CharSequence> titles;

    SectionFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<CharSequence> titles) {
      super(fm);
      this.fragments = fragments;
      this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
      return fragments.get(position);
    }

    @Override
    public int getCount() {
      return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
      return titles.get(position);
    }
  }
}
