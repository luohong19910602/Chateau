package net.itaem.chateau.activity.order;

/**
 * 用来封装数据
 * */
public class OrderVo {
	
	
    
	
	@Override
	public String toString() {
		return "OrderVo [inflaterFlag=" + inflaterFlag + ", orderId=" + orderId
				+ ", number=" + number + ", money=" + money + ", flag=" + flag
				+ ", freight=" + freight + ", time=" + time + ", storeName="
				+ storeName + ", productId=" + productId + ", productName="
				+ productName + ", productPicture=" + productPicture
				+ ", productMoney=" + productMoney + ", productRemark="
				+ productRemark + "]";
	}
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
	
	/**
	 * 用来判断加载什么xml文件，这里一共有3个xml，一个是订单基本信息，一个是产品，一个是购买那些按钮
	 * */
	private int inflaterFlag = 0;
	
	/**
	 * 订单基本信息xml
	 * */
	public static final int ORDER_INFO = 1;
	
	/**
	 * 产品xml
	 * */
	public static final int PRODUCT_INFO = 2;
	
	
	/**
	 * 订单的按钮xml
	 * */
	public static final int ORDER_MONEY_AND_BUTTON_INFO = 3;
	
	//订单id
	private String orderId; 
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
	/**
	 * 商品id
	 * */
	private String productId;
	/**商品名字*/
	private String productName;
	/**
	 * 商品图片
	 * */
	private String productPicture;
	/**
	 * 商品价格
	 * */
	private float productMoney;
	/**
	 * 商品介绍
	 * */
	private String productRemark;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}
	public float getProductMoney() {
		return productMoney;
	}
	public void setProductMoney(float productMoney) {
		this.productMoney = productMoney;
	}
	public String getProductRemark() {
		return productRemark;
	}
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
	public int getInflaterFlag() {
		return inflaterFlag;
	}
	public void setInflaterFlag(int inflaterFlag) {
		this.inflaterFlag = inflaterFlag;
	}
	
}
