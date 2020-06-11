package com.github.alex31n.andutils.android.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;

import androidx.appcompat.app.AlertDialog;

import com.github.alex31n.andutils.java.StringUtils;


public class AlertDialogUtils {


	public static AlertDialog show(Context context, String title, String msg) {
		AlertDialog.Builder d = new AlertDialog.Builder(context);

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
		AlertDialog dialog = d.create();
		dialog.show();

		return dialog;
	}


	public static AlertDialog show(Context context, String title, String msg, DialogInterface.OnClickListener listener) {
		AlertDialog.Builder d = new AlertDialog.Builder(context);

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
		AlertDialog dialog = d.create();
		dialog.show();

		return dialog;
	}

	public static AlertDialog show(Context context, String title, String msg,
										boolean isCancelable, DialogInterface.OnClickListener listener) {

		AlertDialog.Builder d = new AlertDialog.Builder(context);

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
		AlertDialog dialog = d.create();
		dialog.show();

		return dialog;
	}

	public static void showServerErrorMessage(Context context){
		show(context,"Failed!", "Network connection error.");
	}
}
