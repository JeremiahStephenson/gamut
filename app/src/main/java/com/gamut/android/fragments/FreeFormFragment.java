package com.gamut.android.fragments;

import android.app.DialogFragment;
import android.app.Fragment;
import android.bluetooth.BluetoothGattCharacteristic;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.gamut.android.R;
import com.gamut.android.services.BluetoothLeService;
import com.gamut.android.util.ByteUtil;
import com.gamut.android.util.DialogUtil;
import com.gamut.android.views.ColorGrid;
import com.gamut.android.views.ColorPickerGrid;

/**
 * Created by user on 12/26/13.
 */
public class FreeFormFragment extends Fragment implements ColorPickerGrid.IOnColorSelectedListener,
        ColorGrid.IOnColorGridChangedListener {

    private ColorGrid mColorGrid;
    private ColorPickerGrid mColorPickerGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_free_form, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setHasOptionsMenu(true);

        if (getView() != null) {

            mColorGrid = (ColorGrid)getView().findViewById(R.id.color_grid);
            mColorGrid.setListener(this);

            mColorPickerGrid = (ColorPickerGrid)getView().findViewById(R.id.color_picker_grid);
            mColorPickerGrid.setListener(this);
        }

        if (getActivity() != null && getActivity().getActionBar() != null) {
            getActivity().getActionBar().setTitle(R.string.free_form);
        }

        setColor(Color.BLUE);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.free_form_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_clear:
                sendCommand(ByteUtil.GetClearCommand());
                mColorGrid.clear();
                break;
            case R.id.menu_lock:
                item.setTitle(getString(mColorGrid.getIsLocked() ? R.string.lock : R.string.locked));
                mColorGrid.setIsLocked(!mColorGrid.getIsLocked());
                break;
            case R.id.menu_mario:
                runMario();
                break;
            case R.id.menu_color:
                final ColorWheelFragment colorWheel = new ColorWheelFragment();
                colorWheel.setDefaultColor(mColorPickerGrid.getSelectedColor());
                colorWheel.setOnColorChangedListener(new ColorWheelFragment.OnColorChangedListener() {
                    @Override
                    public void onColorChanged(int color) {
                        mColorPickerGrid.setCustomColor(color);
                    }
                });
                colorWheel.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
                DialogUtil.showDialog(this, colorWheel);
                break;
            case R.id.menu_disconnect:
                BluetoothLeService.getInstance().disconnect();

                if (getActivity() != null) {
                    getActivity().finish();
                }

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setColor(int color) {
        mColorGrid.setColor(color);
    }

    private void sendCommand(byte[] command) {
        final BluetoothGattCharacteristic write = BluetoothLeService.getInstance().getWriteCharacteristic();
        if (write != null) {
            write.setValue(command);
            BluetoothLeService.getInstance().writeCharacteristic(write);
        }
    }

    @Override
    public void OnColorCellChanged(int positionX, int positionY, int color) {
        sendCommand(ByteUtil.GetPixelCommand(positionX, positionY,
                (byte)((color >> 16) & 0xFF),
                (byte)((color >> 8) & 0xFF),
                (byte)(color & 0xFF)));
    }

    @Override
    public void OnColorSelected(int color) {
        setColor(color);
    }



    private void runMario() {

        int xoffset = 8;
        int yoffset = 6;
        
        // Row 1
        int row = 0;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 2
        row = 1;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 3
        row = 2;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 4
        row = 3;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 5
        row = 4;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 6
        row = 5;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 7
        row = 6;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 8
        row = 7;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 9
        row = 8;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 10
        row = 9;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 11
        row = 10;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 12
        row = 11;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 13
        row = 12;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 14
        row = 13;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 15
        row = 14;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 16
        row = 15;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLUE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 17
        row = 16;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 18
        row = 17;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.DKGRAY);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 19
        row = 18;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 20
        row = 19;
        mColorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        mColorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

    }
}
