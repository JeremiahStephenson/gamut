package com.gamut.android.activities;

import android.app.Activity;
import android.os.Bundle;

import com.gamut.android.R;

/**
 * Created by user on 12/26/13.
 */
public class FreeFormActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_form);

        if (getActionBar() != null) {
            getActionBar().setTitle(R.string.free_form);
        }
    }
}
