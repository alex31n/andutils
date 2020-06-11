package com.github.alex31n.andutils.android;


import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

import androidx.annotation.NonNull;

public class ViewHelper {

	public static void showView(View view) {

		if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
			view.setVisibility(View.VISIBLE);
		}
	}


	public static void hideView(View view) {
		if (view.getVisibility() == View.VISIBLE) {
			view.setVisibility(View.GONE);
		}
	}


	public static void showView(View view, int animation) {

		showView(view, AnimationUtils.loadAnimation(view.getContext(), animation));
	}


	public static void hideView(View view, int animation) {

		hideView(view, AnimationUtils.loadAnimation(view.getContext(), animation));
	}

	public static void showView(View view, Animation animation) {

		if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
			view.startAnimation(animation);
			view.setVisibility(View.VISIBLE);
		}
	}


	public static void hideView(View view, Animation animation) {

		if (view.getVisibility() == View.VISIBLE) {
			view.startAnimation(animation);
			view.setVisibility(View.GONE);
		}
	}

	public static void smoothToShow(Activity activity, View view) {

		if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
			if (activity != null) {
				Animation animFadeIn = AnimationUtils.loadAnimation(activity, android.R.anim.fade_in);
				view.startAnimation(animFadeIn);
			}
			view.setVisibility(View.VISIBLE);
		}
	}


	public static void smoothToHide(Activity activity, View view) {

		if (view.getVisibility() == View.VISIBLE) {
			if (activity != null) {
				Animation animFadeOut = AnimationUtils.loadAnimation(activity, android.R.anim.fade_out);
				view.startAnimation(animFadeOut);
			}
			view.setVisibility(View.GONE);
		}
	}

	public static void smoothToShow(View view) {
		if (view.getVisibility() == View.GONE || view.getVisibility() == View.INVISIBLE) {
			Animation animFadeIn = AnimationUtils.loadAnimation(view.getContext(), android.R.anim.fade_in);
			view.startAnimation(animFadeIn);

			view.setVisibility(View.VISIBLE);
		}
	}


	public static void smoothToHide(View view) {
		if (view.getVisibility() == View.VISIBLE) {
			Animation animFadeOut = AnimationUtils.loadAnimation(view.getContext(), android.R.anim.fade_out);
			view.startAnimation(animFadeOut);

			view.setVisibility(View.GONE);
		}
	}

	public static boolean isVisible(@NonNull View view) {
		return view.getVisibility() == View.VISIBLE;
	}


	public static void expand(final View v, final int targetHeight) {
		// Older versions of android (pre API 21) cancel animations for views with a height of 0.
		v.getLayoutParams().height = 1;
		v.setVisibility(View.VISIBLE);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				v.getLayoutParams().height = interpolatedTime == 1
					  ? targetHeight
					  : (int) (targetHeight * interpolatedTime);
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
		v.startAnimation(a);

	}

	public static void collapse(final View v, final int initialHeight) {
		//final int initialHeight = v.getMeasuredHeight();

		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime, Transformation t) {
				if (interpolatedTime == 1) {
					v.setVisibility(View.GONE);
				} else {
					v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
					v.requestLayout();
				}
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
		v.startAnimation(a);
	}


	public static void setVisibility(View view,boolean visible){
		if (visible){
			showView(view);
		}else{
			hideView(view);
		}
	}
}
