package com.ornach.andutils.helper;

import android.os.Build;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;


public class MemoryHelper {


	public static boolean externalMemoryAvailable() {
		return Environment.getExternalStorageState().equals(
			  Environment.MEDIA_MOUNTED);
	}

	public static long getAvailableInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());

		long blockSize = 0, availableBlocks = 0;

		if (Build.VERSION.SDK_INT < 18) {
			blockSize = stat.getBlockSize();
			availableBlocks = stat.getAvailableBlocks();
		} else {
			blockSize = stat.getBlockSizeLong();
			availableBlocks = stat.getAvailableBlocksLong();
		}

		return availableBlocks * blockSize;
	}

	public static long getTotalInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());

		long blockSize = 0, totalBlocks = 0;

		if (Build.VERSION.SDK_INT < 18) {
			blockSize = stat.getBlockSize();
			totalBlocks = stat.getBlockCount();
		} else {
			blockSize = stat.getBlockSizeLong();
			totalBlocks = stat.getBlockCountLong();
		}

		return totalBlocks * blockSize;
	}

	public static long getAvailableExternalMemorySize() {
		if (externalMemoryAvailable()) {
			File path = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(path.getPath());
			/*long blockSize = stat.getBlockSize();
			long availableBlocks = stat.getAvailableBlocks();*/

			long blockSize = 0, availableBlocks = 0;

			if (Build.VERSION.SDK_INT < 18) {
				blockSize = stat.getBlockSize();
				availableBlocks = stat.getAvailableBlocks();
			} else {
				blockSize = stat.getBlockSizeLong();
				availableBlocks = stat.getAvailableBlocksLong();
			}

			return availableBlocks * blockSize;
		} else {
			return 0;
		}
	}

	public static long getTotalExternalMemorySize() {
		if (externalMemoryAvailable()) {
			File path = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(path.getPath());
			long blockSize = 0, totalBlocks = 0;

			if (Build.VERSION.SDK_INT < 18) {
				blockSize = stat.getBlockSize();
				totalBlocks = stat.getBlockCount();
			} else {
				blockSize = stat.getBlockSizeLong();
				totalBlocks = stat.getBlockCountLong();
			}

			return totalBlocks * blockSize;
		} else {
			return 0;
		}
	}
}
