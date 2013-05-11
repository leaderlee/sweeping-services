package net.sweeping.app.ui;

import net.sweeping.app.R;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TabHost;

/**
 * 主界面
 * @author Bert Guo
 * 2013-5-11
 */
public class MainTab extends TabActivity implements OnCheckedChangeListener {

	private TabHost mTabHost;  
    private Intent mAIntent;  // 主页
    private Intent mBIntent;  // 点菜
    private Intent mCIntent;  // 历史
    private Intent mDIntent;  // 更多
	
    private RadioButton button0;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.maintabs);
		
		this.mAIntent = new Intent(this, Main.class);
		this.mBIntent = new Intent(this, DishActivity.class);
		this.mCIntent = new Intent(this, HistoryActivity.class);
		this.mDIntent = new Intent(this, MoreActivity.class);

		button0 = ((RadioButton) findViewById(R.id.radio_button0));
		button1 = ((RadioButton) findViewById(R.id.radio_button1));
		button2 = ((RadioButton) findViewById(R.id.radio_button2));
		button3 = ((RadioButton) findViewById(R.id.radio_button3));
		button0.setOnCheckedChangeListener(this);
		button1.setOnCheckedChangeListener(this);
		button2.setOnCheckedChangeListener(this);
		button3.setOnCheckedChangeListener(this);
		
		setupIntent();

		String tag = getIntent().getStringExtra("tag");
		if (tag != null) {
			this.mTabHost.setCurrentTabByTag(tag);
			int i = getIntent().getIntExtra("i", 0);
			if (i == 0) {
				button0.setChecked(true);
			} else if (i == 1) {
				button1.setChecked(true);
			} else if (i == 2) {
				button2.setChecked(true);
			} else {
				button3.setChecked(true);
			}
		}
	}



	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			switch (buttonView.getId()) {
			case R.id.radio_button0:
				this.mTabHost.setCurrentTabByTag("app_main");
				break;
			case R.id.radio_button1:
				this.mTabHost.setCurrentTabByTag("app_dish");
				break;
			case R.id.radio_button2:
				this.mTabHost.setCurrentTabByTag("app_history");
				break;
			case R.id.radio_button3:
				this.mTabHost.setCurrentTabByTag("app_more");
				break;
			}
		}
	}  
	
	private void setupIntent() {
		this.mTabHost = getTabHost();
		TabHost localTabHost = this.mTabHost;

		localTabHost.addTab(buildTabSpec("app_main", R.string.app_main,
				R.drawable.widget_bar_find, this.mAIntent));

		localTabHost.addTab(buildTabSpec("app_dish", R.string.app_dish,
				R.drawable.widget_bar_fee, this.mBIntent));

		localTabHost.addTab(buildTabSpec("app_history",
				R.string.app_history, R.drawable.widget_bar_recharge,
				this.mCIntent));

		localTabHost.addTab(buildTabSpec("app_more", R.string.app_more,
				R.drawable.widget_bar_more, this.mDIntent));
	}  
      
	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.mTabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),
						getResources().getDrawable(resIcon))
				.setContent(content);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}    
}
