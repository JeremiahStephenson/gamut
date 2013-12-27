package com.gamut.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 12/26/13.
 */
public class ColorPickerGrid extends View {

    private static int NUM_COLUMNS = 8;
    private static float PADDING = 0.1F;
    private int[] mColors = {Color.BLACK, Color.WHITE, Color.BLUE, Color.RED, Color.rgb(0,128,0),
            Color.YELLOW, Color.rgb(255, 0, 255), Color.rgb(255, 204, 229), Color.rgb(102, 51, 0), Color.GRAY, Color.rgb(255,215,0), Color.rgb(255,165,0),
            Color.rgb(192,192,192), Color.rgb(0,255,0), Color.rgb(245,245,220), Color.rgb(0,255,255)};

    private Paint mPaint;
    private List<ColorCell> mCells;
    private IOnColorSelectedListener mListener;
    private int mSelected = Color.TRANSPARENT;

    public void setListener(IOnColorSelectedListener listener) {
       mListener = listener;
    }

    public interface IOnColorSelectedListener {
        void OnColorSelected (int color);
    }

    public ColorPickerGrid(Context context) {
        super(context);
        initialize();
    }

    public ColorPickerGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public ColorPickerGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    void initialize () {
        mPaint = new Paint ();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mCells == null || mCells.size() == 0) {

            int sizeX = getWidth() / NUM_COLUMNS;
            int sizeY = sizeX;

            int xOffSet = 0;
            int yOffSet = 0;

            int paddingX = (int)(sizeX * PADDING) / 2;
            int paddingY = (int)(sizeY * PADDING) / 2;

            mCells = new ArrayList<ColorCell>();

            int column = 0;
            for (int x = 0; x < mColors.length; x++) {

                mCells.add (new ColorCell(new RectF(xOffSet + paddingX, yOffSet + paddingY,
                        (xOffSet + sizeX) - paddingX, (yOffSet + sizeY) - paddingY), mColors[x]));

                xOffSet += sizeX;

                column++;

                if (column >= NUM_COLUMNS) {
                    column = 0;
                    xOffSet = 0;
                    yOffSet += sizeY;
                }
            }
        }

        for (ColorCell cell : mCells) {
            mPaint.setColor(cell.getColor());

            canvas.drawRect(cell.getRect(), mPaint);

            if (mSelected != Color.TRANSPARENT && cell.getColor() == mSelected) {
                mPaint.setStyle(Paint.Style.STROKE);
                mPaint.setStrokeWidth(5);
                mPaint.setColor(Color.RED);
                Path path = new Path ();
                path.moveTo(cell.getRect().left, cell.getRect().top);
                path.lineTo(cell.getRect().right, cell.getRect().top);
                path.lineTo(cell.getRect().right, cell.getRect().bottom);
                path.lineTo(cell.getRect().left, cell.getRect().bottom);
                path.close();
                canvas.drawPath(path, mPaint);
                mPaint.setStyle(Paint.Style.FILL);
            }
        }

    }

    public void clearSelected() {
        mSelected = Color.TRANSPARENT;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        for (ColorCell cell : mCells) {

            int x = (int)event.getX();
            int y = (int)event.getY();

            if (x >= cell.getRect().left && x <= cell.getRect().left + (cell.getRect().right - cell.getRect().left) &&
                    y >= cell.getRect().top && y <= cell.getRect().top + (cell.getRect().bottom - cell.getRect().top)) {

                if (mListener != null) {
                    mListener.OnColorSelected (cell.getColor());
                }

                mSelected = cell.getColor();
                invalidate();

                break;
            }
        }

        return true;
    }
}
