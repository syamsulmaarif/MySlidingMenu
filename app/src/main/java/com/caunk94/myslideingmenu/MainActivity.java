package com.caunk94.myslideingmenu;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.caunk94.myslideingmenu.adapter.SlidingMenuAdapter;
import com.caunk94.myslideingmenu.fragment.Fragment1;
import com.caunk94.myslideingmenu.fragment.Fragment2;
import com.caunk94.myslideingmenu.fragment.Fragment3;
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


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init component

        listViewSliding = (ListView)findViewById(R.id.lv_sliding_menu);
        drawerLayout  = (DrawerLayout)findViewById  (R.id.drawer_layout);
        //mainContent = (RelativeLayout)findViewById(R.id.main_content);
        listSliding = new ArrayList<>();

        //add item for sliding list
        listSliding.add(new ItemSlideMenu(R.drawable.ic_info, "Info"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_settings, "Settings"));
        listSliding.add(new ItemSlideMenu(R.mipmap.ic_android, "Android"));
        adapter = new SlidingMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);

        //Display icon to open/close sliding list

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set Title
        setTitle(listSliding.get(0).getTitle());

        //display fragment 1 when start
        replaceFragment(0);

        //item Slected
        listViewSliding.setItemChecked(0, true);

        //close menu
        drawerLayout.closeDrawer(listViewSliding);

        //Handle on item click
        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //setTitle
                setTitle(listSliding.get(position).getTitle());

                //item selected
                listViewSliding.setItemChecked(position, true);

                //close menu
                drawerLayout.closeDrawer(listViewSliding);

                //replace fragment
                replaceFragment(position);
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

            drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    //create methode replace fragment

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void replaceFragment(int pos){
        Fragment fragment = null;

        switch (pos){
            case 0 :
                fragment = new Fragment1();
                break;
            case 1 :
                fragment = new Fragment2();
                break;
            case 2 :
                fragment = new Fragment3();
                break;
            default:
                fragment = new Fragment1();
                break;
        }

        if (null != fragment){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_content, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}
