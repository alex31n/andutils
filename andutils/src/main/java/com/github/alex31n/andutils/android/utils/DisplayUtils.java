package com.github.alex31n.andutils.android.utils;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class DisplayUtils {

	public static int getScreenWidthInPixels(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);
		int width = dm.widthPixels;
		return width;
	}

	// Custom method to get screen height in pixels using Context object
	public static int getScreenHeightInPixels(Context context) {
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);
		int height = dm.heightPixels;
		return height;
	}

	public static int pxToSp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int spToPx(final Context context, final float sp) {
		return Math.round(sp * context.getResources().getDisplayMetrics().scaledDensity);
	}

	public static int pxToDp(final Context context, final float px) {
		return Math.round(px / context.getResources().getDisplayMetrics().density);
	}

	public static int dpToPx(final Context context, final float dp) {
		return Math.round(dp * context.getResources().getDisplayMetrics().density);
	}
}
