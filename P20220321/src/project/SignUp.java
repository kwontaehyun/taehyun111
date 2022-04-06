package project;

public class SignUp {
	private int userNum;
	private String userName;
	private String userBirth;
	private String userID;
	private String userPwd;
	private String UserEmail;
	
	public SignUp() {
		
	}
	
	
	
	public SignUp(String userName, String userBirth, String userID, String userPwd, String userEmail) {
		this.userName = userName;
		this.userBirth = userBirth;
		this.userID = userID;
		this.userPwd = userPwd;
		UserEmail = userEmail;
	}



	public SignUp(int userNum, String userName, String userBirth, String userID, String userPwd, String userEmail) {
		this.userNum = userNum;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userID = userID;
		this.userPwd = userPwd;
		this.UserEmail = userEmail;
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
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		this.UserEmail = userEmail;
	}

	@Override
	public String toString() {
		return "SignUp [userNum=" + userNum + ", userName=" + userName + ", userBirth=" + userBirth + ", userID="
				+ userID + ", userPwd=" + userPwd + ", UserEmail=" + UserEmail + "]";
	}
	public String toString2() {
		return "userName=" + userName + ", userBirth=" + userBirth + ", userID=" + userID + ", userPwd=" + userPwd + ", UserEmail=" + UserEmail + "]";
	}
	









}
