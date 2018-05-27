package com.ornach.andutils.android.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;

import com.ornach.andutils.java.StringUtils;


public class AlertDialog {


	public static android.support.v7.app.AlertDialog show(Context context, String title, String msg) {
		android.support.v7.app.AlertDialog.Builder d = new android.support.v7.app.AlertDialog.Builder(context);

		if (!StringUtils.isEmpty(title))
			d.setTitle(title);

		if (!StringUtils.isEmpty(msg))
			d.setMessage(Html.fromHtml(msg));

		d.setNegativeButton("Close", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		android.support.v7.app.AlertDialog dialog = d.create();
		dialog.show();

		return dialog;
	}


	public static android.support.v7.app.AlertDialog show(Context context, String title, String msg, DialogInterface.OnClickListener listener) {
		android.support.v7.app.AlertDialog.Builder d = new android.support.v7.app.AlertDialog.Builder(context);

		if (!StringUtils.isEmpty(title))
			d.setTitle(title);

		if (!StringUtils.isEmpty(msg))
			d.setMessage(Html.fromHtml(msg));

		if (listener != null ){
			d.setNegativeButton("Close", listener);
		}else{
			d.setNegativeButton("Close", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
		}
		android.support.v7.app.AlertDialog dialog = d.create();
		dialog.show();

		return dialog;
	}

	public static android.support.v7.app.AlertDialog show(Context context, String title, String msg,
										boolean isCancelable, DialogInterface.OnClickListener listener) {

		android.support.v7.app.AlertDialog.Builder d = new android.support.v7.app.AlertDialog.Builder(context);

		if (!StringUtils.isEmpty(title))
			d.setTitle(title);

		if (!StringUtils.isEmpty(msg))
			d.setMessage(Html.fromHtml(msg));

		if (listener != null ){
			d.setNegativeButton("Close", listener);
		}else{
			d.setNegativeButton("Close", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
				}
			});
		}
		d.setCancelable(isCancelable);
		android.support.v7.app.AlertDialog dialog = d.create();
		dialog.show();

		return dialog;
	}

	public static void showServerErrorMessage(Context context){
		show(context,"Failed!", "Network connection error.");
	}
}
