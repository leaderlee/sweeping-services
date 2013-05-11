package net.sweeping.app.common;

import java.util.regex.Pattern;

import net.sweeping.app.AppManager;
import net.sweeping.app.R;
import net.sweeping.app.ui.Main;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Toast;

/**
 * 应用程序UI工具包：封装UI相关的一些操作
 * @author Bert Guo
 * @version 1.0
 * @created 2013-5-11
 */
public class UIHelper {

	public final static int LISTVIEW_ACTION_INIT = 0x01;
	public final static int LISTVIEW_ACTION_REFRESH = 0x02;
	public final static int LISTVIEW_ACTION_SCROLL = 0x03;
	public final static int LISTVIEW_ACTION_CHANGE_CATALOG = 0x04;
	
	public final static int LISTVIEW_DATA_MORE = 0x01;
	public final static int LISTVIEW_DATA_LOADING = 0x02;
	public final static int LISTVIEW_DATA_FULL = 0x03;
	public final static int LISTVIEW_DATA_EMPTY = 0x04;
	
	public final static int LISTVIEW_DATATYPE_NEWS = 0x01;
	public final static int LISTVIEW_DATATYPE_BLOG = 0x02;
	public final static int LISTVIEW_DATATYPE_POST = 0x03;
	public final static int LISTVIEW_DATATYPE_TWEET = 0x04;
	public final static int LISTVIEW_DATATYPE_ACTIVE = 0x05;
	public final static int LISTVIEW_DATATYPE_MESSAGE = 0x06;
	public final static int LISTVIEW_DATATYPE_COMMENT = 0x07;
	
	public final static int REQUEST_CODE_FOR_RESULT = 0x01;
	public final static int REQUEST_CODE_FOR_REPLY = 0x02;
	
	/** 表情图片匹配 */
	private static Pattern facePattern = Pattern.compile("\\[{1}([0-9]\\d*)\\]{1}");
	
	/** 全局web样式 */
	public final static String WEB_STYLE = "<style>* {font-size:16px;line-height:20px;} p {color:#333;} a {color:#3E62A6;} img {max-width:310px;} " +
			"img.alignleft {float:left;max-width:120px;margin:0 10px 5px 0;border:1px solid #ccc;background:#fff;padding:2px;} " +
			"pre {font-size:9pt;line-height:12pt;font-family:Courier New,Arial;border:1px solid #ddd;border-left:5px solid #6CE26C;background:#f6f6f6;padding:5px;} " +
			"a.tag {font-size:15px;text-decoration:none;background-color:#bbd6f3;border-bottom:2px solid #3E6D8E;border-right:2px solid #7F9FB6;color:#284a7b;margin:2px 2px 2px 0;padding:2px 4px;white-space:nowrap;}</style>";
	/**
	 * 显示首页
	 * @param activity
	 */
	public static void showHome(Activity activity)
	{
		Intent intent = new Intent(activity,Main.class);
		activity.startActivity(intent);
		activity.finish();
	}
	
	/**
	 * 组合动态的回复文本
	 * @param name
	 * @param body
	 * @return
	 */
	public static SpannableString parseActiveReply(String name,String body){
		SpannableString sp = new SpannableString(name+"："+body);
		//设置用户名字体加粗、高亮 
		sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.parseColor("#0e5986")), 0, name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
	}
	
	/**
	 * 组合消息文本
	 * @param name
	 * @param body
	 * @return
	 */
	public static SpannableString parseMessageSpan(String name,String body,String action){
		SpannableString sp = null;
		int start = 0;
		int end = 0;
		if(StringUtils.isEmpty(action)){
			sp = new SpannableString(name + "：" + body);
			end = name.length();
		}else{
			sp = new SpannableString(action + name + "：" + body);
			start = action.length();
			end = start + name.length();
		}
		//设置用户名字体加粗、高亮 
		sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		sp.setSpan(new ForegroundColorSpan(Color.parseColor("#0e5986")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
	}
	
	/**
	 * 组合回复引用文本
	 * @param name
	 * @param body
	 * @return
	 */
	public static SpannableString parseQuoteSpan(String name,String body){
		SpannableString sp = new SpannableString("回复："+name+"\n"+body);
		//设置用户名字体加粗、高亮 
		sp.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 3, 3+name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ForegroundColorSpan(Color.parseColor("#0e5986")), 3, 3+name.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
	}
	
	/**
	 * 弹出Toast消息
	 * @param msg
	 */
	public static void ToastMessage(Context cont,String msg)
	{
		Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
	}
	public static void ToastMessage(Context cont,int msg)
	{
		Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
	}
	public static void ToastMessage(Context cont,String msg,int time)
	{
		Toast.makeText(cont, msg, time).show();
	}
	
	/**
	 * 点击返回监听事件
	 * @param activity
	 * @return
	 */
	public static View.OnClickListener finish(final Activity activity)
	{
		return new View.OnClickListener() {
			public void onClick(View v) {
				activity.finish();
			}
		};
	}	
	
	/**
	 * 发送App异常崩溃报告
	 * @param cont
	 * @param crashReport
	 */
	public static void sendAppCrashReport(final Context cont, final String crashReport)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(cont);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setTitle(R.string.app_error);
		builder.setMessage(R.string.app_error_message);
		builder.setPositiveButton(R.string.submit_report, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				//发送异常报告
				Intent i = new Intent(Intent.ACTION_SEND);
				//i.setType("text/plain"); //模拟器
				i.setType("message/rfc822") ; //真机
				i.putExtra(Intent.EXTRA_EMAIL, new String[]{"jxsmallmouse@163.com"});
				i.putExtra(Intent.EXTRA_SUBJECT,"开源中国Android客户端 - 错误报告");
				i.putExtra(Intent.EXTRA_TEXT,crashReport);
				cont.startActivity(Intent.createChooser(i, "发送错误报告"));
				//退出
				AppManager.getAppManager().AppExit(cont);
			}
		});
		builder.setNegativeButton(R.string.sure, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				//退出
				AppManager.getAppManager().AppExit(cont);
			}
		});
		builder.show();
	}
	
	/**
	 * 退出程序
	 * @param cont
	 */
	public static void Exit(final Context cont)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(cont);
		builder.setIcon(android.R.drawable.ic_dialog_info);
		builder.setTitle(R.string.app_menu_surelogout);
		builder.setPositiveButton(R.string.sure, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				//退出
				AppManager.getAppManager().AppExit(cont);
			}
		});
		builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}
}
