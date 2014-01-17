package com.gamut.android.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremiahs on 12/26/13.
 */
public class ColorGrid extends View {

    private static final String TAG = ColorGrid.class.toString();

    // zooming
    float zoom = 1.0f;
    float maxZoom = 10.0f;
    float smoothZoom = 1.0f;
    float zoomX, zoomY;
    float smoothZoomX, smoothZoomY;

    // touching variables
    private Rect rect;
    private float startd;
    private boolean pinching;
    private float lastd;
    private float lastdx1, lastdy1;
    private float lastdx2, lastdy2;

    // drawing
    private final Matrix m = new Matrix();
    private final Paint p = new Paint();

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
        initialize(context);
    }

    public ColorGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public ColorGrid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public void clear() {
        for (ColorCell cell : mCells) {
            cell.setColor(Color.BLACK);
        }
        invalidate();
    }

    void initialize(Context context) {
        _paint = new Paint ();
        _paint.setColor(mColor);
    }

    @Override
    protected void onMeasure(int w, int h) {
        setMinimumHeight(w);
        super.onMeasure(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // do zoom
        zoom = lerp(bias(zoom, smoothZoom, 0.05f), smoothZoom, 0.2f);
        smoothZoomX = clamp(0.5f * getWidth() / smoothZoom, smoothZoomX, getWidth() - 0.5f * getWidth() / smoothZoom);
        smoothZoomY = clamp(0.5f * getHeight() / smoothZoom, smoothZoomY, getHeight() - 0.5f * getHeight() / smoothZoom);

        zoomX = lerp(bias(zoomX, smoothZoomX, 0.1f), smoothZoomX, 0.35f);
        zoomY = lerp(bias(zoomY, smoothZoomY, 0.1f), smoothZoomY, 0.35f);

        final boolean animating = Math.abs(zoom - smoothZoom) > 0.0000001f
                || Math.abs(zoomX - smoothZoomX) > 0.0000001f || Math.abs(zoomY - smoothZoomY) > 0.0000001f;

        // prepare matrix
        m.setTranslate(0.5f * getWidth(), 0.5f * getHeight());
        m.preScale(zoom, zoom);
        m.preTranslate(-clamp(0.5f * getWidth() / zoom, zoomX, getWidth() - 0.5f * getWidth() / zoom),
                -clamp(0.5f * getHeight() / zoom, zoomY, getHeight() - 0.5f * getHeight() / zoom));

        canvas.save();
        canvas.concat(m);

        ///////////////////////////////////////////////////////////////////
        int sizeX = getWidth() / NUM_COLUMNS;
        int sizeY = getWidth() / NUM_ROWS;

        int xOffSet = 0;
        int yOffSet = 0;

        int paddingX = (int)(sizeX * PADDING) / 2;
        int paddingY = (int)(sizeY * PADDING) / 2;

        if (mCells == null || mCells.size() == 0) {

            mCells = new ArrayList<>();

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
        ////////////////////////////////////////////////////////////////////

        canvas.restore();

        rect = canvas.getClipBounds();

        // redraw
        // if (animating) {
        //getRootView().invalidate();
        //invalidate();
        // }
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

        //mScaleDetector.onTouchEvent(event);

        // // double touch
        if (event.getPointerCount() == 2) {
            processDoubleTouchEvent(event);
        }

        RectF test = new RectF();

        if (event.getPointerCount() == 1) {

            for (ColorCell cell : mCells) {

                int x = (int)event.getX();
                int y = (int)event.getY();

                test = new RectF();
                m.mapRect(test, cell.getRect());

                if (x >= test.left && x <= test.left + (test.right - test.left) &&
                        y >= test.top && y <= test.top + (test.bottom - test.top)) {

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
            m.mapRect(test, rectF);
            rect.set((int) test.left - 1, (int) test.top - 1, (int) test.right + 1, (int) test.bottom + 1);
            invalidate(rect);
            //invalidate();
        }

        return true;
    }

    public void smoothZoomTo(final float zoom, final float x, final float y) {
        smoothZoom = clamp(1.0f, zoom, maxZoom);
        smoothZoomX = x;
        smoothZoomY = y;
    }

    private float clamp(final float min, final float value, final float max) {
        return Math.max(min, Math.min(value, max));
    }

    private float lerp(final float a, final float b, final float k) {
        return a + (b - a) * k;
    }

    private float bias(final float a, final float b, final float k) {
        return Math.abs(b - a) >= k ? a + k * Math.signum(b - a) : b;
    }

    private void processDoubleTouchEvent(final MotionEvent ev) {

        final float x1 = ev.getX(0);
        final float dx1 = x1 - lastdx1;
        lastdx1 = x1;
        final float y1 = ev.getY(0);
        final float dy1 = y1 - lastdy1;
        lastdy1 = y1;
        final float x2 = ev.getX(1);
        final float dx2 = x2 - lastdx2;
        lastdx2 = x2;
        final float y2 = ev.getY(1);
        final float dy2 = y2 - lastdy2;
        lastdy2 = y2;

        // pointers distance
        final float d = (float) Math.hypot(x2 - x1, y2 - y1);
        final float dd = d - lastd;
        lastd = d;
        final float ld = Math.abs(d - startd);

        Math.atan2(y2 - y1, x2 - x1);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startd = d;
                pinching = false;
                break;

            case MotionEvent.ACTION_MOVE:
                if (pinching || ld > 30.0f) {
                    pinching = true;
                    final float dxk = 0.5f * (dx1 + dx2);
                    final float dyk = 0.5f * (dy1 + dy2);
                    smoothZoomTo(Math.max(1.0f, zoom * d / (d - dd)), zoomX - dxk / zoom, zoomY - dyk / zoom);
                }

                break;

            case MotionEvent.ACTION_UP:
            default:
                pinching = false;
                break;
        }

        invalidate();
    }
}
