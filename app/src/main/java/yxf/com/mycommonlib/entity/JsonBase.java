package yxf.com.mycommonlib.entity;

/**
 * @author yxf
 * @date 15-9-9
 * @time 下午3:02
 * updater xxx
 * update  yy-MM-dd
 * @comment json数据基类
 */
public abstract class JsonBase<T> {
	private int c;
	private T data;
	private String msg;

	public int getCode() {
		return c;
	}

	public void setCode(int c) {
		this.c = c;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "JsonBase{" +
				"c=" + c +
				", data=" + data +
				", msg='" + msg + '\'' +
				'}';
	}
}
