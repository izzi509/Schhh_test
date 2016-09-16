package com.example.marcgregor.schhh.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcgregor.schhh.R;

/**
 * Created by Delva on 9/11/2016.
 */
public class LocalFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_local, container, false);


    }
    public static LocalFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        LocalFragment fragment = new LocalFragment();
        return fragment;
    }
}

