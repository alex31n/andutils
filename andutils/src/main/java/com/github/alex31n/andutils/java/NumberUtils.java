package com.github.alex31n.andutils.java;


import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class NumberUtils {


	public static String getCurrency(double amount, boolean withDecimal){
		/*DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance();

		if (withDecimal){
			formatter.setMinimumFractionDigits(2);
			formatter.setMaximumFractionDigits(2);
		}else{
			formatter.setMinimumFractionDigits(0);
			formatter.setMaximumFractionDigits(0);
		}
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setCurrencySymbol("");
		dfs.setGroupingSeparator(',');
		dfs.setMonetaryDecimalSeparator('.');

		formatter.setDecimalFormatSymbols(dfs);
		String moneyString = formatter.format(amount);*/

		return getCurrencyWithSymbol(amount, withDecimal,"");
	}

	public static String getCurrencyWithSymbol(double amount, boolean withDecimal, String symbol){
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance();

		if (withDecimal){
			formatter.setMinimumFractionDigits(2);
			formatter.setMaximumFractionDigits(2);
		}else{
			formatter.setMinimumFractionDigits(0);
			formatter.setMaximumFractionDigits(0);
		}
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();

		if(!TextUtils.isEmpty(symbol)){
			dfs.setCurrencySymbol(symbol+" ");
		}else{
			dfs.setCurrencySymbol("");
		}

		dfs.setGroupingSeparator(',');
		dfs.setMonetaryDecimalSeparator('.');

		formatter.setDecimalFormatSymbols(dfs);
		String moneyString = formatter.format(amount);

		return moneyString;
	}



	/**
	 * Returns a double rounding value by given precision.
	 * @param value a double value.
	 * @param precision a double value.
	 * @return  double of rounding value.
	 */
	public static double round (double value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}
}
