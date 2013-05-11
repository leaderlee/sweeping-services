package net.sweeping.app.base;

import net.sweeping.app.AppContext;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * 基类Activity
 * @author Bert Guo
 * 2013-2-28
 */
public class BaseActivity extends Activity {

	public AppContext appContext; // 应用程序
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 无标题
		appContext = AppContext.getInstance();
	}
}
