package net.sweeping.model;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单信息
 * 
 * @author hk
 * 
 */
public class MenuData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4643490951318043461L;

	/**
	 * 分类列表
	 */
	private List<Cls> classes;

	/**
	 * 套菜列表
	 */
	private List<DinnerFood> dinners;

	/**
	 * 服务列表
	 */
	private List<Serve> serves;

	public List<Cls> getClasses() {
		return classes;
	}

	public void setClasses(List<Cls> classes) {
		this.classes = classes;
	}

	public List<DinnerFood> getDinners() {
		return dinners;
	}

	public void setDinners(List<DinnerFood> dinners) {
		this.dinners = dinners;
	}

	public List<Serve> getServes() {
		return serves;
	}

	public void setServes(List<Serve> serves) {
		this.serves = serves;
	}

}
