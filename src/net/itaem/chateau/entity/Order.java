package net.itaem.chateau.entity;

import java.util.List;

/**
 * 订单实体类
 * 一个订单里面有多个物品内容
 * */
public class Order {

	/**
	 * 订单没有付款
	 * */
	public static final int OERDER_NOT_PAY = 0;
    
	/**
	 * 订单已付款，没有发货
	 * */
	public static final int OERDER_PAY_NOT_SEND = 1;
    
	
	/**
	 * 订单已付款，已经发货
	 * */
	public static final int OERDER_PAY_SEND = 2;
    
	/**
	 * 订单没有付款
	 * */
	public static final int OERDER_RECIEVE = 3;
    
	/**
	 * 订单没有付款
	 * */
	public static final int OERDER_CANCEL = -1;
	
	//订单id
	private String id; 
	//订单编号
	private String number;
    //订单金额
	private float money;
    //订单状态
	private int flag;
	//快递费
	private float freight;
	//订单时间
	private String time;
	//店铺名字
	private String storeName;
	//订单物品
	private List<Product> productList;
	
	
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", money=" + money
				+ ", flag=" + flag + ", freight=" + freight + ", time=" + time
				+ ", storeName=" + storeName + ", productList=" + productList
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public float getFreight() {
		return freight;
	}

	public void setFreight(float freight) {
		this.freight = freight;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
    
	
}
