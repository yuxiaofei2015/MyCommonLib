package yxf.com.mycommonlib.NetWork.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

/**
 * @author yxf
 * @date 15-9-8
 * @time 下午3:04
 * updater xxx
 * update  yy-MM-dd
 * @comment 公共GSON解析类
 */
public class GsonGlobal {
	public static Gson GSON = new GsonBuilder()
//			.excludeFieldsWithoutExposeAnnotation() 只导出@Expose注释过的属性
			.enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
			.serializeNulls()
			.setDateFormat(DateFormat.LONG)  //时间转化为特定格式
			.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) //会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
			.setPrettyPrinting() //对json结果格式化.
			.setVersion(1.0)//有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
			.create();
}
