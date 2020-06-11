package com.github.alex31n.andutils.android.utils;

import android.util.Log;

/**
 * Help printing logs splitting text on new line and creating multiple logs for too long texts
 */

public class LogHelper {

	private static final int MAX_LOG_LENGTH = 4000;


	public static void v(String tag, String msg){
		log("V",tag, msg);
	}

	public static void d(String tag, String msg){
		log("D",tag, msg);
	}

	public static void i(String tag, String msg){
		log("I",tag, msg);
	}

	public static void w(String tag, String msg){
		log("W",tag, msg);
	}

	public static void e(String tag, String msg){
		log("E",tag, msg);
	}

	private static void log(String a, String TAG, String msg ){
		for(int i = 0; i <= msg.length() / MAX_LOG_LENGTH; i++) {
			int start = i * MAX_LOG_LENGTH;
			int end = (i+1) * MAX_LOG_LENGTH;
			end = end > msg.length() ? msg.length() : end;

			String splitMessage = msg.substring(start, end);
			printLog(a, TAG, splitMessage);
		}

	}

	private static void printLog(String a, String tag, String msg){

		if (a.equalsIgnoreCase("D")){
			Log.d(tag, msg);
		}else if (a.equalsIgnoreCase("I")){
			Log.i(tag, msg);
		}else if (a.equalsIgnoreCase("W")){
			Log.w(tag, msg);
		}else if (a.equalsIgnoreCase("E")){
			Log.e(tag, msg);
		}else {
			Log.v(tag,msg);
		}
	}
}