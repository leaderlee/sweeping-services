package net.sweeping.model;

import java.io.Serializable;
import java.util.List;

/**
 * 菜品分类
 * @author hk
 */
public class Cls implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2733296243008546676L;
	/**
	 * 分类id
	 */
	private int clsId;

	/**
	 * 类名
	 */
	private int clsName;

	/**
	 * 菜
	 */
	private List<Food> foods;

	public int getClsId() {
		return clsId;
	}

	public void setClsId(int clsId) {
		this.clsId = clsId;
	}

	public int getClsName() {
		return clsName;
	}

	public void setClsName(int clsName) {
		this.clsName = clsName;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}


}
