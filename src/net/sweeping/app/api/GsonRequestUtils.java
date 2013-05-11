package net.sweeping.app.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Gson请求帮助类
 * @author Bert guo
 * date 2013-3-28
 */
public class GsonRequestUtils {

	public static Gson gson = null; // 声明gson对象

	static {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create(); // 创建gson对象，并设置日期格式
	}
}
