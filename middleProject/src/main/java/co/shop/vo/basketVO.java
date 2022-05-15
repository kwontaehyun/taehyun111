package co.shop.vo;

public class basketVO {
	private String proDuctName;
	private int proDuctPrice;
	private String comment;
	private int sale;
	private String pImg;
	private String gender;
	private String email;
	
	public basketVO() {
		
	}
	
	public basketVO(String proDuctName, int proDuctPrice, String comment, int sale, String pImg, String gender,
			String email) {
		super();
		this.proDuctName = proDuctName;
		this.proDuctPrice = proDuctPrice;
		this.comment = comment;
		this.sale = sale;
		this.pImg = pImg;
		this.gender = gender;
		this.email = email;
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
	
	
	
	
}
