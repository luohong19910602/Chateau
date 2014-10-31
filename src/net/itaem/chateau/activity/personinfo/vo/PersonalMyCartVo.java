package net.itaem.chateau.activity.personinfo.vo;

public class PersonalMyCartVo {
	
	private String imageUrl;	//图片url
	private String productDescription;	//产品描述
	private String productName;	//产品名称
	private String cost;		//价格
	
	private int num;	//产品数量
	
	private boolean isSelected; //是否选中

	
	public PersonalMyCartVo() {
		 
	}
	
	
	public PersonalMyCartVo(String imageUrl, String productDescription,
			String productName, String cost, int num, boolean isSelected) {
		this.imageUrl = imageUrl;
		this.productDescription = productDescription;
		this.productName = productName;
		this.cost = cost;
		this.num = num;
		this.isSelected = isSelected;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}


	@Override
	public String toString() {
		return "PersonalMyCartVo [imageUrl=" + imageUrl
				+ ", productDescription=" + productDescription
				+ ", productName=" + productName + ", cost=" + cost + ", num="
				+ num + ", isSelected=" + isSelected + "]";
	}
	
	
	
}
