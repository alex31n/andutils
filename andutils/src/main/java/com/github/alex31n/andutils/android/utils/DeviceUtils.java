package com.github.alex31n.andutils.android.utils;

import android.content.Context;
import android.provider.Settings;

/**
 * Created by user on 11/9/2017.
 */

public class DeviceUtils {

	public static String getDeviceId(Context context){
		String deviceId = Settings.Secure.getString(context.getApplicationContext().getContentResolver(),
			  Settings.Secure.ANDROID_ID);

		//Log.e("ALEX", "deviceId: " + deviceId);
		return deviceId;
	}
}
