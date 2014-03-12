package com.gamut.android.util;

import android.graphics.Color;

import com.gamut.android.views.ColorGrid;

/**
 * Created by user on 3/12/14.
 */
public class StaticImageUtil {

    public static void runIris(ColorGrid colorGrid) {

        int xoffset = 5;
        int yoffset = 12;

        final int lightGreen = Color.rgb(211, 224, 71);
        final int mediumGreen = Color.rgb(163, 198, 57);
        final int darkGreen = Color.rgb(43, 182, 115);
        final int offWhite = Color.rgb(231, 231, 232);

        // Row 1
        int row = 0;
        colorGrid.setColorOnPixel (xoffset, row + yoffset, lightGreen);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, mediumGreen);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, darkGreen);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, darkGreen);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (16 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (17 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (18 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (19 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (20 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (21 + xoffset, row + yoffset, Color.BLACK);

        // Row 2
        row = 1;
        colorGrid.setColorOnPixel (xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, lightGreen);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, mediumGreen);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, darkGreen);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (16 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (17 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (18 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (19 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (20 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (21 + xoffset, row + yoffset, Color.BLACK);

        // Row 3
        row = 2;
        colorGrid.setColorOnPixel (xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, lightGreen);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, mediumGreen);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (16 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (17 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (18 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (19 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (20 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (21 + xoffset, row + yoffset, Color.BLACK);

        // Row 4
        row = 3;
        colorGrid.setColorOnPixel (xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (16 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (17 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (18 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (19 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (20 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (21 + xoffset, row + yoffset, Color.BLACK);

        // Row 5
        row = 4;
        colorGrid.setColorOnPixel (xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (16 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (17 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (18 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (19 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (20 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (21 + xoffset, row + yoffset, Color.BLACK);

        // Row 6
        row = 5;
        colorGrid.setColorOnPixel (xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (16 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (17 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (18 + xoffset, row + yoffset, offWhite);
        colorGrid.setColorOnPixel (19 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (20 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (21 + xoffset, row + yoffset, lightGreen);

    }

    public static void runMario(ColorGrid colorGrid) {

        int xoffset = 8;
        int yoffset = 6;

        // Row 1
        int row = 0;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 2
        row = 1;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 3
        row = 2;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 4
        row = 3;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 5
        row = 4;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 6
        row = 5;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 7
        row = 6;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 8
        row = 7;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.BLACK);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 9
        row = 8;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 10
        row = 9;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 11
        row = 10;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 12
        row = 11;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 13
        row = 12;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.RED);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 14
        row = 13;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 15
        row = 14;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.YELLOW);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 16
        row = 15;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.BLUE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 17
        row = 16;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 18
        row = 17;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.DKGRAY);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 19
        row = 18;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

        // Row 20
        row = 19;
        colorGrid.setColorOnPixel (0 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (1 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (2 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (3 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (4 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (5 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (6 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (7 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (8 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (9 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (10 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (11 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (12 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (13 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (14 + xoffset, row + yoffset, Color.WHITE);
        colorGrid.setColorOnPixel (15 + xoffset, row + yoffset, Color.WHITE);

    }
    
}
