package com.caunk94.myslideingmenu;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.caunk94.myslideingmenu.adapter.SlidingMenuAdapter;
import com.caunk94.myslideingmenu.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<ItemSlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private RelativeLayout mainContent;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init component

        listViewSliding = (ListView)findViewById(R.id.lv_sliding_menu);
        drawerLayout  = (DrawerLayout)findViewById(R.id.drawer_layout);
        mainContent = (RelativeLayout)findViewById(R.id.main_content);
        listSliding = new ArrayList<>();

        //add item for sliding list
        listSliding.add(new ItemSlideMenu(R.drawable.ic_info, "Info"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_settings, "Settings"));
        listSliding.add(new ItemSlideMenu(R.drawable.android1, "Android"));


    }
}
