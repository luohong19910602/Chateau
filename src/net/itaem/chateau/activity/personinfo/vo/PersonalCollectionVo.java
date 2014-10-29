package net.itaem.chateau.activity.personinfo.vo;

public class PersonalCollectionVo {

	private String imageUrl;	//图片url
	private String productDescription;	//产品描述
	private String productName;	//产品名称
	private String cost;		//价格
	
	
	public PersonalCollectionVo() {
	}
	
	public PersonalCollectionVo(String imageUrl, String productDescription,
			String productName, String cost) {
		this.imageUrl = imageUrl;
		this.productDescription = productDescription;
		this.productName = productName;
		this.cost = cost;
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
	@Override
	public String toString() {
		return "PersonalCollectionVo [imageUrl=" + imageUrl
				+ ", productDescription=" + productDescription
				+ ", productName=" + productName + ", cost=" + cost + "]";
	}
	
	
	
}
