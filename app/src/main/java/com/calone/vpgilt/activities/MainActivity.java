package com.calone.vpgilt.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.calone.vpgilt.R;
import com.calone.vpgilt.views.SalesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.container, new SalesFragment())
                .commit();
    }
}
