package com.github.alex31n.andutils.android.utils;


import android.app.ProgressDialog;
import android.content.Context;

public class LoadingDialog {


	private static ProgressDialog dialog;

	public static ProgressDialog show(Context context) {
		dialog = show(context, "Loading...");
		return dialog;
	}

	public static ProgressDialog show(Context context, String msg) {
		dialog = ProgressDialog.show(context, "", msg, false, false);
		return dialog;
	}

	public static void dismiss() {
		if (dialog != null) {
			dialog.dismiss();
		}
	}
}
