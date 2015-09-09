package yxf.com.mycommonlib.NetWork.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author yxf
 * @date 15-9-8
 * @time 下午6:12
 * updater xxx
 * update  yy-MM-dd
 * @comment 请求队列
 */
public class AppRequestQueue {

	private static RequestQueue mRequestQueue;

	public static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mRequestQueue.start();
	}

	public static void add(Request request) {
		mRequestQueue.add(request);
	}
}
