package com.gamut.android.util;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by user on 3/4/14.
 */
public class DialogUtil {

    public static void showDialog(Fragment context, DialogFragment dialog) {

        FragmentTransaction ft = context.getChildFragmentManager().beginTransaction();
        Fragment prev = context.getChildFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        dialog.show(ft, "dialog");

    }

}
