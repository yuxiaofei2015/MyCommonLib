package yxf.com.mycommonlib.entity.data;

import com.google.gson.annotations.SerializedName;

/**
 * @author yxf
 * @date 15-9-9
 * @time 下午3:04
 * updater xxx
 * update  yy-MM-dd
 * @comment balabalabala
 */
public class TestData {
	@SerializedName("id")
	private int mId;
	@SerializedName("title")
	private String mTitle;
	@SerializedName("content")
	private String mContent;

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public String getContent() {
		return mContent;
	}

	public void setContent(String content) {
		mContent = content;
	}

	@Override
	public String toString() {
		return "TestData{" +
				"mId=" + mId +
				", mTitle='" + mTitle + '\'' +
				", mContent='" + mContent + '\'' +
				'}';
	}
}
