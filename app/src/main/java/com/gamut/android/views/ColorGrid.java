package com.gamut.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/26/13.
 */
public class ColorGrid extends View {

    public static int NUM_COLUMNS = 32;
    public static int NUM_ROWS = 32;
    private static float PADDING = 0.1F;
    private Paint _paint;

    private float mScale = 8f / 32f;

    private List<ColorCell> mCells;
    private ColorCell mCurrent;

    private int mColor = Color.BLACK;
    public int getColor() {
        return mColor;
    }
    public void setColor(int color) {
        mColor = color;
    }

    public interface IOnColorGridChangedListener {
        void OnColorCellChanged (int positionX, int positionY, int color);
    }

    private IOnColorGridChangedListener mListener;
    public void setListener(IOnColorGridChangedListener listener) {
        mListener = listener;
    }

    public ColorGrid(Context context) {
        super(context);
        initialize();
    }

    public ColorGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ColorGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    public void clear() {
        for (ColorCell cell : mCells) {
            cell.setColor(Color.BLACK);
        }
        invalidate();
    }

    void initialize () {
        _paint = new Paint ();
        _paint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int width, int height) {
        setMinimumHeight(width);
        super.onMeasure(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int sizeX = getWidth() / NUM_COLUMNS;
        int sizeY = getWidth() / NUM_ROWS;

        int xOffSet = 0;
        int yOffSet = 0;

        int paddingX = (int)(sizeX * PADDING) / 2;
        int paddingY = (int)(sizeY * PADDING) / 2;

        if (mCells == null || mCells.size() == 0) {

            mCells = new ArrayList<ColorCell>();

            for (int x = 0; x < NUM_ROWS; x++) {
                for (int y = 0; y < NUM_COLUMNS; y++) {

                    mCells.add(new ColorCell(new RectF(xOffSet + paddingX, yOffSet + ((x == 0) ? paddingY * 2 : paddingY),
                            (xOffSet + sizeX) - paddingX, (yOffSet + sizeY) - paddingY), Color.BLACK));

                    xOffSet += sizeX;
                }

                xOffSet = 0;
                yOffSet += sizeY;
            }
        }

        for (ColorCell cell : mCells) {
            if (cell.getColor() != Color.BLACK) {
                _paint.setColor(cell.getColor());
                _paint.setStyle(Paint.Style.FILL);
                canvas.drawRoundRect (cell.getRect(), 20 * mScale, 20 * mScale, _paint);
            } else {
                _paint.setStyle(Paint.Style.STROKE);
                _paint.setColor(Color.GRAY);
                canvas.drawRoundRect(cell.getRect(), 20 * mScale, 20 * mScale, _paint);
            }
        }
    }

    public void setColorOnPixel(int column, int row) {
        setColorOnPixel(column, row, mColor);
    }

    public void setColorOnPixel(int column, int row, int color) {
        int temp = ((row + 1) * NUM_COLUMNS) - (NUM_COLUMNS - (column + 1));
        ColorCell cell = mCells.get(temp - 1);
        cell.setColor(color);
        if (mListener != null) {
            mListener.OnColorCellChanged (column, row, color);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("Gamut test", String.valueOf(event.getX()) + ", " + String.valueOf(event.getY()));

        for (ColorCell cell : mCells) {

            int x = (int)event.getX();
            int y = (int)event.getY();

            if (x >= cell.getRect().left && x <= cell.getRect().left + (cell.getRect().right - cell.getRect().left) &&
                    y >= cell.getRect().top && y <= cell.getRect().top + (cell.getRect().bottom - cell.getRect().top)) {

                if ((mCurrent == cell && mCurrent.getColor() != mColor) || mCurrent != cell) {

                    mCurrent = cell;
                    cell.setColor(mColor);

                    if (mListener != null) {

                        int position = mCells.indexOf (cell);
                        int column = (position < NUM_COLUMNS) ? position : (position % NUM_COLUMNS);
                        int row = (position < NUM_COLUMNS) ? 0 : ((int)Math.floor ((double)position / NUM_ROWS));

                        mListener.OnColorCellChanged (column, row, mColor);
                    }

                    break;
                }
            }
        }

        final Rect rect = new Rect();
        final RectF rectF = mCurrent.getRect();
        rect.set((int)rectF.left - 1, (int)rectF.top - 1, (int)rectF.right + 1, (int)rectF.bottom + 1);
        invalidate(rect);

        return true;
    }
}
