package yxf.com.mycommonlib.NetWork.volley;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.toolbox.HttpHeaderParser;

/**
 * @author yxf
 * @date 15-9-8
 * @time 下午4:35
 * updater xxx
 * update  yy-MM-dd
 * @comment 控制缓存本地控制缓存时间的类，基类是通过服务器断控制缓存的时间类
 */
public class AppCacheControl extends HttpHeaderParser {

	public static Cache.Entry getCacheControl(NetworkResponse response) {
		Cache.Entry entry = parseCacheHeaders(response);
		final long now = System.currentTimeMillis();
		return entry;
	}
}
