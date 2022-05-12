package co.shop.vo;

public class productVO {
	private int proDuctNum;
	private String proDuctName;
	private int proDuctPrice;
	private String cateGory;
	private String comment;
	private int sale;
	private String pImg;
	private String gender;
	private String email;
	
	public productVO() {
		
	}
	
	
	public productVO(int proDuctNum, String proDuctName, int proDuctPrice, String cateGory, String comment, int sale,
			String pImg, String gender, String email) {
		super();
		this.proDuctNum = proDuctNum;
		this.proDuctName = proDuctName;
		this.proDuctPrice = proDuctPrice;
		this.cateGory = cateGory;
		this.comment = comment;
		this.sale = sale;
		this.pImg = pImg;
		this.gender = gender;
		this.email = email;
	}
	public int getProDuctNum() {
		return proDuctNum;
	}
	public void setProDuctNum(int proDuctNum) {
		this.proDuctNum = proDuctNum;
	}
	public String getProDuctName() {
		return proDuctName;
	}
	public void setProDuctName(String proDuctName) {
		this.proDuctName = proDuctName;
	}
	public int getProDuctPrice() {
		return proDuctPrice;
	}
	public void setProDuctPrice(int proDuctPrice) {
		this.proDuctPrice = proDuctPrice;
	}
	public String getCateGory() {
		return cateGory;
	}
	public void setCateGory(String cateGory) {
		this.cateGory = cateGory;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "productVO [proDuctNum=" + proDuctNum + ", proDuctName=" + proDuctName + ", proDuctPrice=" + proDuctPrice
				+ ", cateGory=" + cateGory + ", comment=" + comment + ", sale=" + sale + ", pImg=" + pImg + ", gender="
				+ gender + ", email=" + email + "]";
	}
	
	
	
	
}

