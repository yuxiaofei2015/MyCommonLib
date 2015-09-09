package yxf.com.mycommonlib;

import android.app.Application;

import com.orm.SugarApp;

import yxf.com.mycommonlib.NetWork.volley.AppRequestQueue;

/**
 * @author yxf
 * @date 15-9-2
 * @time 下午5:54
 * updater xxx
 * update  yy-MM-dd
 * @comment appContext
 */
public class AppInstance extends SugarApp {
	private static Application mInstance;

	public static Application getInstance() {
		return mInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		AppRequestQueue.init(this);
	}

}
