package net.sweeping.app.ui;

import net.sweeping.app.R;
import net.sweeping.app.base.BaseActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 点菜
 * @author Bert Guo
 * 2013-5-11
 */
public class DishActivity extends BaseActivity {

	private LinearLayout ll_frame_dish;
	private LinearLayout ll_frame_call;
	private LinearLayout ll_frame_pay;
	
	private Button dish_btn_dish;
	private Button dish_btn_call;
	private Button dish_btn_pay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dish);
		initView();
		initClick();
	}
	
	/**
	 * 初始化控件
	 */
	private void initView() {
		
		ll_frame_dish = (LinearLayout) findViewById(R.id.ll_frame_dish);
		ll_frame_call = (LinearLayout) findViewById(R.id.ll_frame_call);
		ll_frame_pay = (LinearLayout) findViewById(R.id.ll_frame_pay);
		
		dish_btn_dish = (Button) findViewById(R.id.dish_btn_dish);
		dish_btn_call = (Button) findViewById(R.id.dish_btn_call);
		dish_btn_pay = (Button) findViewById(R.id.dish_btn_pay);
	}
	
	/**
	 * 点击事件
	 */
	private void initClick() {
		
		// 点菜
		dish_btn_dish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ll_frame_dish.setVisibility(View.VISIBLE);
				ll_frame_call.setVisibility(View.GONE);
				ll_frame_pay.setVisibility(View.GONE);
			}
		});
		
		// 呼叫
		dish_btn_call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ll_frame_dish.setVisibility(View.GONE);
				ll_frame_call.setVisibility(View.VISIBLE);
				ll_frame_pay.setVisibility(View.GONE);
			}
		});
		
		// 买单
		dish_btn_pay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				ll_frame_dish.setVisibility(View.GONE);
				ll_frame_call.setVisibility(View.GONE);
				ll_frame_pay.setVisibility(View.VISIBLE);
			}
		});
	}
}
