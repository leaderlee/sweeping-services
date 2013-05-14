package net.sweeping.model;

import java.io.Serializable;

/**
 * 菜
 * @author hk
 */
public class Food implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2630138137986686198L;

	/**
	 * 菜类id
	 */
	private int foodId;
	/**
	 * 菜名
	 */
	private String foodName;
	/**
	 * 图片
	 */
	private String foodPic;
	/**
	 * 是否售完
	 */
	private boolean foodOver;
	/**
	 * 单价
	 */
	private int foodPrice;
	/**
	 * 食物折扣
	 */
	private float foodDiscount;
	/**
	 * 是否推荐
	 */
	private boolean foodRecommend;
	/**
	 * 口味选择 使用“|”分隔
	 */
	private String foodOption;

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodPic() {
		return foodPic;
	}

	public void setFoodPic(String foodPic) {
		this.foodPic = foodPic;
	}

	public boolean isFoodOver() {
		return foodOver;
	}

	public void setFoodOver(boolean foodOver) {
		this.foodOver = foodOver;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

	public float getFoodDiscount() {
		return foodDiscount;
	}

	public void setFoodDiscount(float foodDiscount) {
		this.foodDiscount = foodDiscount;
	}

	public boolean isFoodRecommend() {
		return foodRecommend;
	}

	public void setFoodRecommend(boolean foodRecommend) {
		this.foodRecommend = foodRecommend;
	}

	public String getFoodOption() {
		return foodOption;
	}

	public void setFoodOption(String foodOption) {
		this.foodOption = foodOption;
	}

}
