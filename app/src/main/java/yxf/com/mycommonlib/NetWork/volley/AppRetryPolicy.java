package yxf.com.mycommonlib.NetWork.volley;

import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

/**
 * @author yxf
 * @date 15-9-6
 * @time 下午7:43
 * updater xxx
 * update  yy-MM-dd
 * @comment balabalabala
 */
public class AppRetryPolicy implements RetryPolicy {
	/**
	 * The current timeout in milliseconds.
	 */
	private int mCurrentTimeoutMs;

	/**
	 * The current retry count.
	 */
	private int mCurrentRetryCount;

	/**
	 * The maximum number of attempts.
	 */
	private final int mMaxNumRetries;

	/**
	 * The backoff multiplier for the policy.
	 */
	private final float mBackoffMultiplier;
	/**
	 * The default socket timeout in milliseconds
	 */
	public static final int DEFAULT_TIMEOUT_MS = 2500;

	/**
	 * The default number of retries
	 */
	public static final int DEFAULT_MAX_RETRIES = 1;

	/**
	 * The default backoff multiplier
	 * 这里是backoff因子，每次请求超时间隔不会线性增长而是乘以线性因子增长
	 */
	public static final float DEFAULT_BACKOFF_MULT = 1.5f;

	public AppRetryPolicy(int initialTimeoutMs, int maxNumRetries, float backoffMultiplier) {
		mCurrentTimeoutMs = initialTimeoutMs;
		mMaxNumRetries = maxNumRetries;
		mBackoffMultiplier = backoffMultiplier;
	}

	public AppRetryPolicy() {
		this(DEFAULT_TIMEOUT_MS, DEFAULT_MAX_RETRIES, DEFAULT_BACKOFF_MULT);
	}

	@Override
	public int getCurrentTimeout() {
		return DEFAULT_TIMEOUT_MS;
	}

	@Override
	public int getCurrentRetryCount() {
		return mCurrentRetryCount;
	}

	@Override
	public void retry(VolleyError error) throws VolleyError {
		mCurrentRetryCount++;
		mCurrentTimeoutMs += (mCurrentTimeoutMs * mBackoffMultiplier);
		if (!hasAttemptRemaining()) {
			throw error;
		}
	}

	/**
	 * Returns true if this policy has attempts remaining, false otherwise.
	 */
	protected boolean hasAttemptRemaining() {
		return mCurrentRetryCount <= mMaxNumRetries;
	}
}
