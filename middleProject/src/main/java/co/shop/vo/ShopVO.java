package co.shop.vo;

public class ShopVO {

	private String email;
	private String pw;
	private String gender;
	private String jumin;
	private String phone;
	private String address;
	private String acces;
	
	public ShopVO() {
		
	}
	
	public ShopVO(String email, String pw, String gender, String jumin, String phone, String address, String acces) {
		super();
		this.email = email;
		this.pw = pw;
		this.gender = gender;
		this.jumin = jumin;
		this.phone = phone;
		this.address = address;
		this.acces = acces;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAcces() {
		return acces;
	}

	public void setAcces(String acces) {
		this.acces = acces;
	}

	@Override
	public String toString() {
		return "ShopVO [email=" + email + ", pw=" + pw + ", gender=" + gender + ", jumin=" + jumin + ", phone=" + phone
				+ ", address=" + address + ", acces=" + acces + "]";
	}
	

	
	
	
	
}
