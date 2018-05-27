package com.ornach.andutils.android.utils;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Alex on 4/2/2017.
 */
public class KeyboardUtils {


	/**
	 * Hides the soft keyboard
	 */
	public static void hideSoftKeyboard(Activity activity) {
		if (activity.getCurrentFocus() != null) {
			InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
			inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
		}
	}

	/**
	 * Shows the soft keyboard
	 */
	public static void showSoftKeyboard(Activity activity, View view) {
		InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
		view.requestFocus();
		inputMethodManager.showSoftInput(view, 0);
	}


	/**
	 * Hides the soft keyboard
	 */
	public static void hideSoftKeyboard(View view) {
		if (view != null) {
			InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
			inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}
}
