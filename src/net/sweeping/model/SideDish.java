package net.sweeping.model;

import java.io.Serializable;

/**
 * 附菜
 * @author hk
 *
 */
public class SideDish implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6557024235245721924L;
	
	/**
	 * 附菜名
	 */
	private String sideDishName;

	public String getSideDishName() {
		return sideDishName;
	}

	public void setSideDishName(String sideDishName) {
		this.sideDishName = sideDishName;
	}
	
	

}
