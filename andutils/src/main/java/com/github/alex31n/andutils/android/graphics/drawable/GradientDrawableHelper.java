package com.github.alex31n.andutils.android.graphics.drawable;


import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

public class GradientDrawableHelper {

	/*private Drawable nullDrawable() {
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.no);
		BitmapDrawable bd = new BitmapDrawable(getResources(), bitmap);
		return bd;
	}*/

	public static Drawable generateDrawable(int color) {
		//create a new gradient color
		GradientDrawable gd = new GradientDrawable();
		gd.setShape(GradientDrawable.RECTANGLE);
		gd.setColor(color);
		return gd;
	}

	public static Drawable generateDrawable(GradientDrawable.Orientation orientation, int... colors) {
		//create a new gradient color
		GradientDrawable gd = new GradientDrawable(orientation, colors);
		/*gd.setOrientation(orientation);
		gd.setShape(GradientDrawable.RECTANGLE);
		gd.setColors(colors);*/
		return gd;
	}

	public static Drawable generateDrawable(int type, float radius, float centerX, float centerY, int... colors) {
		//create a new gradient color
		GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
		//gd.setOrientation(orientation);
		gd.setShape(GradientDrawable.RECTANGLE);
		//gd.setColors(colors);
		gd.setGradientType(type);
		gd.setGradientRadius(radius);
		gd.setGradientCenter(centerX, centerY);
		return gd;
	}
}
