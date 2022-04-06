package project;

public class SignUp {
	private int userNum;
	private String userName;
	private String userBirth;
	private String userID;
	private String userPwd;
	private String userEmail;
	private String userPhoneNumber;
	
	public SignUp() {
		
	}
	
	
	
	public SignUp(int userNum, String userPwd) {
		super();
		this.userNum = userNum;
		this.userPwd = userPwd;
	}



	public SignUp(int userNum, String userName, String userBirth, String userID, String userPwd, String userEmail, String userPhoneNumber) {
		this.userNum = userNum;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userID = userID;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
	}
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}



	@Override
	public String toString() {
		return "	회원정보\n\n"
				+ "회원번호 : " + userNum 
				+ "\n이름 : " + userName 
				+ "\n생일 : " + userBirth 
				+ "\n아이디 : "+ userID
				+ "\n이메일 주소 : " + userEmail
				+ "\n핸드폰 번호 : " + userPhoneNumber;
	}
	









}
