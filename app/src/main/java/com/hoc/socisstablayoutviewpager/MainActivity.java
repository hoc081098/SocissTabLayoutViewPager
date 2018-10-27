package com.hoc.socisstablayoutviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;
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

    setSupportActionBar(this.<Toolbar>findViewById(R.id.toolbar));

    setupTabLayoutAndViewPager();
  }

  private void setupTabLayoutAndViewPager() {
    ViewPager viewPager = findViewById(R.id.view_pager);
    this.<TabLayout>findViewById(R.id.tab_layout).setupWithViewPager(viewPager);
    List<Pair<? extends Fragment, String>> pairs = Arrays.asList(
        Pair.create(new FirstFragment(), "First"),
        Pair.create(new SecondFragment(), "Second"),
        Pair.create(new ThirdFragment(), "Third")
    );
    viewPager.setAdapter(new SectionFragmentPagerAdapter(getSupportFragmentManager(), pairs));
  }

  private static final class SectionFragmentPagerAdapter extends FragmentPagerAdapter {
    private final List<Pair<? extends Fragment, String>> pairs;

    SectionFragmentPagerAdapter(FragmentManager supportFragmentManager, List<Pair<? extends Fragment, String>> pairs) {
      super(supportFragmentManager);
      this.pairs = pairs;
    }

    @Override
    public Fragment getItem(int position) {
      return pairs.get(position).first;
    }

    @Override
    public int getCount() {
      return pairs.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
      return pairs.get(position).second;
    }
  }
}
