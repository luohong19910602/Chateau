package net.itaem.chateau.entity;

/**
 * 商品实体
 * */
public class Product {
	/**
	 * 商品id
	 * */
	private String id;
	/**商品名字*/
	private String name;
	/**
	 * 商品图片
	 * */
	private String picture;
	/**
	 * 商品价格
	 * */
	private float money;
	/**
	 * 商品介绍
	 * */
	private String remark;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", picture=" + picture + ", money="
				+ money + ", remark=" + remark + "]";
	}
	
}
