package yxf.com.mycommonlib.NetWork.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import yxf.com.mycommonlib.NetWork.json.GsonGlobal;
import yxf.com.mycommonlib.debug.AppDebug;

/**
 * @author yxf
 * @date 15-9-6
 * @time 下午6:01
 * updater xxx
 * update  yy-MM-dd
 * @comment Json格式请求类
 */
public class RequestJson<T> extends Request<T> {
	private static long DEFAULT_CACHETIME = 2 * 60 * 1000;//默认缓存时间
	Map<String, String> mParams;
	Class<T> mType;
	OnResponseListener<T> mResponseListener;
	private long mCacheTime = DEFAULT_CACHETIME;

	public RequestJson(String url, Class<T> type,
	                   OnResponseListener<T> respListener,
	                   Response.ErrorListener errListener) {
		this(Method.GET, url, type, null, respListener, errListener);

	}

	public RequestJson(String url, Class<T> type, Map<String, String> param,
	                   OnResponseListener<T> respListener,
	                   Response.ErrorListener errListener) {
		this(Method.POST, url, type, param, respListener, errListener);
	}

	public RequestJson(int method, String url, Class<T> type, Map<String, String> param,
	                   OnResponseListener<T> respListener,
	                   Response.ErrorListener errListener) {
		super(method, url, errListener);
		setRetryPolicy(new AppRetryPolicy());
		mParams = param;
		mResponseListener = respListener;
		mType = type;
	}

	public void setCacheTime(long cacheTime) {
		mCacheTime = cacheTime;
	}

	public long getCacheTime() {
		return mCacheTime;
	}

	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return mParams;
	}

	@Override
	protected String getParamsEncoding() {
		//UTF-8
		return super.getParamsEncoding();
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		String jsonStr;
		try {
			jsonStr = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
		} catch (UnsupportedEncodingException e) {
			jsonStr = new String(response.data);
		}
		if (mType == null) {
			throw new NullPointerException("RequestJson NullPointerException Type==null");
		}
		T obj = GsonGlobal.GSON.fromJson(jsonStr, mType);
		try {
			AppDebug.LOG_I("REQUEST: ", getUrl());
			AppDebug.LOG_I("REQUEST_HEADERS: ", getParams());
			AppDebug.LOG_I("RESPONSE: ", jsonStr);
			AppDebug.LOG_I("RESPONSE_HEADERS: ", response.headers);
		} catch (AuthFailureError authFailureError) {
			authFailureError.printStackTrace();
		}
		return Response.success(obj, AppCacheControl.getCacheControl(response, getCacheTime()));
	}

	@Override
	protected void deliverResponse(T response) {
		if (mResponseListener != null) {
			mResponseListener.onResponse(response);
		}
	}

}
