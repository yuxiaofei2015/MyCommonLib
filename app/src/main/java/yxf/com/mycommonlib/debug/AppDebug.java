package yxf.com.mycommonlib.debug;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yxf
 * @date 15-9-8
 * @time 下午3:47
 * updater xxx
 * update  yy-MM-dd
 * @comment 测试用类
 */
public class AppDebug {
	final static boolean DEBUG = true;

	public static void LOG_D(Object obj, Object... args) {
		if (DEBUG) {
			String TAG = genTagString(obj);
			final String msg = genMessageString(args);
			LOG(Log.DEBUG, TAG, msg);
		}
	}

	public static void LOG_I(Object obj, Object... args) {
		if (DEBUG) {
			String TAG = genTagString(obj);
			final String msg = genMessageString(args);
			LOG(Log.INFO, TAG, msg);
		}
	}

	public static void LOG_E(Object obj, Object... args) {
		if (DEBUG) {
			String TAG = genTagString(obj);
			final String msg = genMessageString(args);
			LOG(Log.ERROR, TAG, msg);
		}
	}

	private static void LOG(int priority, String tag, String content) {
		try {
			String methodName = null;
			switch (priority) {
				case Log.VERBOSE: {
					methodName = "v";
					break;
				}
				case Log.DEBUG: {
					methodName = "d";
					break;
				}
				case Log.INFO: {
					methodName = "i";
					break;
				}
				case Log.WARN: {
					methodName = "w";
					break;
				}
				case Log.ERROR: {
					methodName = "e";
					break;
				}
				default: {
					methodName = "d";
				}
			}
			Method method = Log.class.getMethod(methodName, String.class, String.class);
			int currentPosition = 0;
			int lengthPerLine = 120;
			while (currentPosition < content.length()) {
				if (currentPosition + lengthPerLine < content.length()) {
					method.invoke(null, tag, content.substring(currentPosition, currentPosition + lengthPerLine)
							+ " <");
				} else {
					method.invoke(null, tag, content.substring(currentPosition) + " <");
				}
				currentPosition += lengthPerLine;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	private static String genTagString(Object obj) {
		String TAG;
		if (obj == null) {
			TAG = "NULL";
		} else if (obj instanceof String) {
			TAG = (String) obj;
		} else {
			TAG = obj.getClass().getSimpleName();
		}
		return TAG;
	}

	private static String genMessageString(Object... args) {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (int i = 0; i < args.length; i++) {
			if (i != 0) {
				sb.append(",");
			}
			if (args[i] != null) {
				sb.append(args[i].toString());
			} else {
				sb.append("NULL");
			}
		}
		sb.append(" ]");
		return sb.toString();
	}
}
