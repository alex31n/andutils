package com.ornach.andutils.java;


import android.support.annotation.Nullable;

import java.util.Iterator;

public class StringUtils {

	public static boolean startsWithIgnoreCase(@Nullable String text1, @Nullable String text2){
		return text1.toLowerCase().startsWith(text2.toLowerCase());
	}

	public static boolean endsWithIgnoreCase(@Nullable String text1, @Nullable String text2){
		return text1.toLowerCase().endsWith(text2.toLowerCase());
	}


	public static String replaceWithIgnoreCase(@Nullable String text1, @Nullable String text2,@Nullable String text3){
		return text1.toLowerCase().replace(text2.toLowerCase(), text3);
	}



	/**
	 * Returns true if the string is null or 0-length.
	 */
	public static boolean isEmpty(@Nullable CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}

	public static boolean isEmpty(@Nullable String text1) {
		return text1 == null || text1.length() == 0;
	}
	public static boolean isNull(@Nullable String text1) {
		return (text1 == null);
	}


	/**
	 * Returns a string containing the tokens joined by delimiters.
	 * @param tokens an array objects to be joined. Strings will be formed from
	 *     the objects by calling object.toString().
	 */
	public static String join(CharSequence delimiter, Iterable tokens) {
		StringBuilder sb = new StringBuilder();
		boolean firstTime = true;
		for (Object token: tokens) {
			if (firstTime) {
				firstTime = false;
			} else {
				sb.append(delimiter);
			}
			sb.append(token);
		}
		return sb.toString();
	}

	/**
	 * Returns a string containing the tokens joined by delimiters.
	 * @param tokens an array objects to be joined. Strings will be formed from
	 *     the objects by calling object.toString().
	 *//*
	public static String join(CharSequence delimiter, Iterable tokens) {
		StringBuilder sb = new StringBuilder();
		Iterator<?> it = tokens.iterator();
		if (it.hasNext()) {
			sb.append(it.next());
			while (it.hasNext()) {
				sb.append(delimiter);
				sb.append(it.next());
			}
		}
		return sb.toString();
	}*/



	public static boolean isEquals(@Nullable String text1, @Nullable String text2){
		/*if (isEmpty(text1) || isEmpty(text2)){
			return false;
		}else{

		}*/

		return !isNull(text1) && !isNull(text2) && text1.equals(text2);
	}

	public static boolean isEqualsIgnoreCase(@Nullable String text1, @Nullable String text2){
		return !isNull(text1) && !isNull(text2) && text1.equalsIgnoreCase(text2);
	}

}
