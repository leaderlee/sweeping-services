package net.sweeping.app;

import java.util.Hashtable;

import net.sweeping.app.common.UIHelper;
import android.app.Application;
import android.os.Handler;
import android.os.Message;

/**
 * 全局应用程序类：用于保存和调用全局应用配置及访问网络数据
 * @author Bert Guo
 * @version 1.0
 * @created 2013-5-11
 */
public class AppContext extends Application {
	
	public static final int NETTYPE_WIFI = 0x01;
	public static final int NETTYPE_CMWAP = 0x02;
	public static final int NETTYPE_CMNET = 0x03;
	
	public static final int PAGE_SIZE = 20;//默认分页大小
	private static final int CACHE_TIME = 60*60000;//缓存失效时间
	
	private static AppContext mInstance = null;
	
	private boolean login = false;	//登录状态
	private int loginUid = 0;	//登录用户的id
	private Hashtable<String, Object> memCacheRegion = new Hashtable<String, Object>();
	
	private Handler unLoginHandler = new Handler(){
		public void handleMessage(Message msg) {
			if(msg.what == 1){
				UIHelper.ToastMessage(AppContext.this, getString(R.string.msg_login_error));
			}
		}		
	};
	
	/**
	 * 获取应用程序实例 单例模式中获取唯一的Application 实例
	 * 
	 * @return 当前应用程序
	 */
	public static AppContext getInstance() {

		if (null == mInstance) {
			mInstance = new AppContext();
		}
		return mInstance;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
        //注册App异常崩溃处理器
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
	}
}
