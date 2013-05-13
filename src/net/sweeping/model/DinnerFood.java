package net.sweeping.model;

import java.util.List;

/**
 * 套菜
 * @author hk
 *
 */
public class DinnerFood extends Food {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187524946040043943L;

	/**
	 * 主菜名
	 */
	private String mainCourseName;

	/**
	 * 附菜信息
	 */
	private List<SideDish> sideDishs;

	public String getMainCourseName() {
		return mainCourseName;
	}

	public void setMainCourseName(String mainCourseName) {
		this.mainCourseName = mainCourseName;
	}

	public List<SideDish> getSideDishs() {
		return sideDishs;
	}

	public void setSideDishs(List<SideDish> sideDishs) {
		this.sideDishs = sideDishs;
	}

	
}
