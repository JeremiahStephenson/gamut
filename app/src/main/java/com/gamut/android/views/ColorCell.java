package com.gamut.android.views;

import android.graphics.RectF;

/**
 * Created by user on 12/26/13.
 */
public class ColorCell
{
    private RectF mRect;
    public void setRect(RectF rect) {
        mRect = rect;
    }
    public RectF getRect() {
        return mRect;
    }

    private int mColor;
    public int getColor() {
        return mColor;
    }
    public void setColor(int color) {
        mColor = color;
    }

    public ColorCell (RectF rect, int color)
    {
        mRect = rect;
        mColor = color;
    }
}
