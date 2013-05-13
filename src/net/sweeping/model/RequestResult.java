package net.sweeping.model;

import java.io.Serializable;

public class RequestResult<T extends Serializable> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4198395033285472215L;

	public static int SUCCESS = 0; // 成功
	public static int UNKNOW = 1; // 未知
	public static int FAILED = 2; // 失败

	/**
	 * 返回值
	 */
	private int recode;

	/**
	 * 就餐号
	 */
	private int dinnerId;

	/**
	 * 返回信息
	 */
	private String msg;
	/**
	 * 返回数据
	 */
	private T data;

	/**
	 * 时间
	 */
	private long date;

	public boolean OK() {
		return recode == SUCCESS;
	}

	public int getRecode() {
		return recode;
	}

	public void setRecode(int recode) {
		this.recode = recode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getDinnerId() {
		return dinnerId;
	}

	public void setDinnerId(int dinnerId) {
		this.dinnerId = dinnerId;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

}
