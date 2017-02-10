package com.example.vinayg.widgetloader;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getName();
    private Button mLeft,mRight, mBottomLeft,mBottomRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate()");
        mLeft = (Button) findViewById(R.id.left_button);
        mRight = (Button) findViewById(R.id.right_button);
        mBottomLeft = (Button) findViewById(R.id.bottom_left_button);
        mBottomRight = (Button) findViewById(R.id.bottom_right_button);
        mLeft.setOnClickListener(this);
        mRight.setOnClickListener(this);
        mBottomLeft.setOnClickListener(this);
        mBottomRight.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }

    public void onClick(View view) {
        Log.d(TAG,"onClick()");
        int id = view.getId();
        switch (id) {
            case R.id.left_button:
                ShowFragment(R.layout.textview);
                break;
            case R.id.right_button:
                ShowFragment(R.layout.radiobutton);
                break;
            case R.id.bottom_left_button:
                ShowFragment(R.layout.spinner);
                break;
            case R.id.bottom_right_button:
                ShowFragment(R.layout.progressbar);
                break;
            default:break;

        }
    }
    private void ShowFragment(int Id) {
        Bundle bundle = new Bundle();
        bundle.putInt("widgetid",Id);
        Fragment frag_obj = new WidgetFragment();
        frag_obj.setArguments(bundle);
        Placefragment(frag_obj);
    }

    private void Placefragment(Fragment frag_obj) {
        FragmentManager fm= getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, frag_obj);
        fragmentTransaction.commit();
    }
}

