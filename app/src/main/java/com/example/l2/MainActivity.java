package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    ListView imageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        while (fetchData.done != true) {}

        imageList = (ListView) findViewById(R.id.elemList);
        imageList.setAdapter(new CustomListAdapter(this, fetchData.arrPic, fetchData.arrText, fetchData.arrName));

        pager = (ViewPager) findViewById(R.id.pagerList);
        pager.setAdapter(new CustomPagerAdapter(this, fetchData.arrPic, fetchData.arrText, fetchData.arrName));

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                pager.setVisibility(View.VISIBLE);
                pager.setCurrentItem(position);
            }
        };
        imageList.setOnItemClickListener(itemListener);
    }
}
