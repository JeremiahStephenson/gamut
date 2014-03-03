package com.gamut.android.fragments;

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
}
