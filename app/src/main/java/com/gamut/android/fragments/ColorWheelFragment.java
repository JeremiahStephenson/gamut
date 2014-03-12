package com.gamut.android.fragments;

import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamut.android.R;
import com.larswerkman.holocolorpicker.ColorPicker;

/**
 * Created by user on 3/4/14.
 */
public class ColorWheelFragment extends DialogFragment {

    private OnColorChangedListener mColorChangedListener;
    private int mDefaultColor = Color.GREEN;

    public interface OnColorChangedListener {
        public void onColorChanged(int color);
    }

    public void setOnColorChangedListener(OnColorChangedListener colorChangedListener) {
        mColorChangedListener = colorChangedListener;
    }

    public void setDefaultColor(int color) {
        mDefaultColor = color;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_color_wheel, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getView() == null) {
            return;
        }

        final ColorPicker picker = (ColorPicker) getView().findViewById(R.id.picker);
        //SVBar svBar = (SVBar) getView().findViewById(R.id.svbar);

        //picker.addSVBar(svBar);
        picker.setColor(mDefaultColor);

        picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int i) {
                if (mColorChangedListener != null) {
                    mColorChangedListener.onColorChanged(i);
                }
            }
        });

    }
}
