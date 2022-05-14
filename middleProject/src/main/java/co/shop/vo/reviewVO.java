package co.shop.vo;

public class reviewVO {
	private int reviewNum;
	private String RImg;
	private String content;
	private int proDuctNum;
	private String email;
	private int grade;
	
	public reviewVO() {
		
	}
	
	public reviewVO(int reviewNum, String rImg, String content, int proDuctNum, String email, int grade) {
		super();
		this.reviewNum = reviewNum;
		RImg = rImg;
		this.content = content;
		this.proDuctNum = proDuctNum;
		this.email = email;
		this.grade = grade;
	}
	public int getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getRImg() {
		return RImg;
	}
	public void setRImg(String rImg) {
		RImg = rImg;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProDuctNum() {
		return proDuctNum;
	}
	public void setProDuctNum(int proDuctNum) {
		this.proDuctNum = proDuctNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
