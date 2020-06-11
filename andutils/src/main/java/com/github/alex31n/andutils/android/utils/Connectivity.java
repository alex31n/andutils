package com.github.alex31n.andutils.android.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/**
 * device's network connectivity manager
 */
public class Connectivity {

	/**
	 * Get instance of the network info
	 *
	 * @param context
	 * @return
	 */
	public static NetworkInfo getNetworkInfo(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		return cm.getActiveNetworkInfo();
	}

	/**
	 * return boolean value of connection
	 *
	 * @param context
	 * @return
	 */
	public static boolean isConnected(Context context) {
		NetworkInfo info = Connectivity.getNetworkInfo(context);
		return (info != null && info.isConnected());
	}

	/**
	 * return boolean value of connection
	 *
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
		NetworkInfo info = Connectivity.getNetworkInfo(context);
		return (info != null && info.isConnected());
	}

	/**
	 * return true if device connected with Wifi network
	 *
	 * @param context
	 * @return
	 */
	public static boolean isConnectedWifi(Context context) {
		NetworkInfo info = Connectivity.getNetworkInfo(context);
		return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_WIFI);
	}

	/**
	 * return true if device connected with a mobile network
	 *
	 * @param context
	 * @return
	 */
	public static boolean isConnectedMobile(Context context) {
		NetworkInfo info = Connectivity.getNetworkInfo(context);
		return (info != null && info.isConnected() && info.getType() == ConnectivityManager.TYPE_MOBILE);
	}


	public static String getNetworkClass(Context context) {
		/*ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();*/
		NetworkInfo info = getNetworkInfo(context);

		if (info == null || !info.isConnected())
			return "-"; //not connected
		if (info.getType() == ConnectivityManager.TYPE_WIFI)
			return "WIFI";
		if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
			int networkType = info.getSubtype();
			switch (networkType) {
				case TelephonyManager.NETWORK_TYPE_GPRS:
				case TelephonyManager.NETWORK_TYPE_EDGE:
				case TelephonyManager.NETWORK_TYPE_CDMA:
				case TelephonyManager.NETWORK_TYPE_1xRTT:
				case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
					return "2G";
				case TelephonyManager.NETWORK_TYPE_UMTS:
				case TelephonyManager.NETWORK_TYPE_EVDO_0:
				case TelephonyManager.NETWORK_TYPE_EVDO_A:
				case TelephonyManager.NETWORK_TYPE_HSDPA:
				case TelephonyManager.NETWORK_TYPE_HSUPA:
				case TelephonyManager.NETWORK_TYPE_HSPA:
				case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
				case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
				case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
					return "3G";
				case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
					return "4G";
				default:
					return "Unknown";
			}
		}
		return "Unknown";
	}


	/**
	 * You need to add:
	 * <p/>
	 * <pre>
	 *     <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	 * </pre>
	 * <p/>
	 * in your AndroidManifest.xml.
	 */
	public static String getNetworkType(Context context) {

		NetworkInfo info = getNetworkInfo(context);
		if (info == null || !info.isConnected())
			return "-"; //not connected
		if (info.getType() == ConnectivityManager.TYPE_WIFI)
			return "WIFI";
		if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
			int networkType = info.getSubtype();
			switch (networkType) {
				case TelephonyManager.NETWORK_TYPE_1xRTT:
					return "1xRTT";
				case TelephonyManager.NETWORK_TYPE_CDMA:
					return "CDMA";
				case TelephonyManager.NETWORK_TYPE_EDGE:
					return "EDGE";
				case TelephonyManager.NETWORK_TYPE_EHRPD:
					return "eHRPD";
				case TelephonyManager.NETWORK_TYPE_EVDO_0:
					return "EVDO rev. 0";
				case TelephonyManager.NETWORK_TYPE_EVDO_A:
					return "EVDO rev. A";
				case TelephonyManager.NETWORK_TYPE_EVDO_B:
					return "EVDO rev. B";
				case TelephonyManager.NETWORK_TYPE_GPRS:
					return "GPRS";
				case TelephonyManager.NETWORK_TYPE_HSDPA:
					return "HSDPA";
				case TelephonyManager.NETWORK_TYPE_HSPA:
					return "HSPA";
				case TelephonyManager.NETWORK_TYPE_HSPAP:
					return "HSPA+";
				case TelephonyManager.NETWORK_TYPE_HSUPA:
					return "HSUPA";
				case TelephonyManager.NETWORK_TYPE_IDEN:
					return "iDen";
				case TelephonyManager.NETWORK_TYPE_LTE:
					return "LTE";
				case TelephonyManager.NETWORK_TYPE_UMTS:
					return "UMTS";
				case TelephonyManager.NETWORK_TYPE_UNKNOWN:
					return "Unknown";
			}
			throw new RuntimeException("New type of network");
		}

		return "Unknown";
	}

}
