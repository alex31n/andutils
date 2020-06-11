package com.github.alex31n.andutils.java;


import android.util.Log;

import org.json.JSONObject;

import java.math.BigDecimal;

public class JsonUtils {

	public static String getString(JSONObject object, String key) {
		/*try {
			return object.getString(key);
		} catch (Exception e) {
			//e.printStackTrace();
			return "";
		}*/

		if (object.isNull(key)){
			return "";
		}

		try {
			//Log.e("TAG", "json "+object.optString(key));
			return object.optString(key);
		} catch (Exception e) {
			//e.printStackTrace();
			return "";
		}

	}

	public static int getInt(JSONObject object, String key) {
		try {
			return object.getInt(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return 0;
		}
	}

	public static Long getLong(JSONObject object, String key) {
		try {
			return object.getLong(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return 0L;
		}
	}


	public static boolean getBoolean(JSONObject object, String key) {

		try {
			return object.getBoolean(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return false;

		}
	}

	public static double getDouble(JSONObject object, String key) {
		try {
			return object.getDouble(key);
		} catch (Exception e) {
			//e.printStackTrace();
			return 0.0;
		}
	}

	public static float getFloat(JSONObject object, String key) {
		try {
			return (float) object.getDouble(key);
		} catch (Exception e) {
			//e.printStackTrace();
			return 0;
		}
	}

	public static BigDecimal getBigDecimal(JSONObject object, String key) {

		try {
			if (object.isNull(key))
				return new BigDecimal(0);
			else
				return new BigDecimal(object.optString(key));

		} catch (Exception e) {

			return new BigDecimal(0);
		}
	}

	public static JSONObject getJSONObject(JSONObject object, String key) {

		try {
			if (object.isNull(key) || !object.has(key))
				return new JSONObject();
			else
				return object.getJSONObject(key);

		} catch (Exception e) {

			return new JSONObject();
		}
	}
}
