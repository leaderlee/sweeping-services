package net.sweeping.model;

import java.io.Serializable;

/**
 * 用户表
 * @author hk
 *
 */
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8826682085925165559L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 用户心别 1为男 0为女
	 */
	private int userSex;
	
	/**
	 * 用户头像地址
	 */
	private String userPic;
	
	/**
	 * 联系方式
	 */
	private String userTel;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	
	

}
