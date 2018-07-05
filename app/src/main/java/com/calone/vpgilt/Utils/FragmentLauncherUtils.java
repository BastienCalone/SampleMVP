package com.calone.vpgilt.Utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.calone.vpgilt.R;
import com.calone.vpgilt.views.DetailSaleFragment;
import com.calone.vpgilt.views.SalesFragment;

/**
 * Created by babas on 03/07/18.
 */

public class FragmentLauncherUtils {

    public static void launchFragment(AppCompatActivity activityCompat, Class classFragment, Bundle data) {

        Fragment fragment = null;
        String tag = "";
        if (classFragment.equals(SalesFragment.class)) {
            fragment = new SalesFragment();
            tag = "sales";
        }
        if (classFragment.equals(DetailSaleFragment.class)) {
            fragment = new DetailSaleFragment();
            tag = "details";
        }
        if (fragment != null) {
            fragment.setArguments(data);
            startFragment(activityCompat, fragment, R.id.container, tag);
        }
    }

    private static void startFragment(AppCompatActivity context, Fragment fragment, int ressource, String tag) {
        FragmentManager manager = context.getSupportFragmentManager();
        manager.beginTransaction()
                .replace(ressource, fragment)
                .addToBackStack(tag)
                .commit();
    }
}
