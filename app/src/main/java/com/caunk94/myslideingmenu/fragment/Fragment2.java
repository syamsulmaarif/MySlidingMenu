package com.caunk94.myslideingmenu.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caunk94.myslideingmenu.R;

/**
 * Created by caunk94 on 5/9/2016.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Fragment2 extends Fragment {

    public Fragment2(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment2, container, false);
        return rootView;
    }
}
