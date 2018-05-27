package com.ornach.andutils.java;


import org.json.JSONObject;

import java.math.BigDecimal;

public class JsonValidator {

	public String getString(JSONObject object, String key) {
		try {
			return object.getString(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return "";
		}
	}

	public int getInt(JSONObject object, String key) {
		try {
			return object.getInt(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return 0;
		}
	}

	public Long getLong(JSONObject object, String key) {
		try {
			return object.getLong(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return 0L;
		}
	}


	public boolean getBoolean(JSONObject object, String key) {

		try {
			return object.getBoolean(key);

		} catch (Exception e) {
			//e.printStackTrace();
			return false;

		}
	}

	public double getDouble(JSONObject object, String key) {
		try {
			return object.getDouble(key);
		} catch (Exception e) {
			//e.printStackTrace();
			return 0.0;
		}
	}

	public float getFloat(JSONObject object, String key) {
		try {
			return (float) object.getDouble(key);
		} catch (Exception e) {
			//e.printStackTrace();
			return 0;
		}
	}


	public BigDecimal getBigDecimal(JSONObject object, String key) {

		try {
			if (object.isNull(key))
				return new BigDecimal(0);
			else
				return new BigDecimal(object.optString(key));

		} catch (Exception e) {

			return new BigDecimal(0);
		}
	}

	public JSONObject getJSONObject(JSONObject object, String key) {

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
