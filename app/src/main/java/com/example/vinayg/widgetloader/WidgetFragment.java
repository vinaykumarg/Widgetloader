package com.example.vinayg.widgetloader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WidgetFragment extends Fragment {
    private int mWidgetId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mWidgetId = getArguments().getInt("widgetid");
        return inflater.inflate(mWidgetId, container, false);
    }
}
