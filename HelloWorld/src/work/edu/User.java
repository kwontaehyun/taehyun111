package work.edu;

public class User {
	
	private String userId;
	private String userGrade;
	private String userPhone;
	private int point;

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public void setpoint(int point) {
		this.point = point;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public String getUserGrade() {
		return this.userGrade;
	}
	public String getUserPhone() {
		return this.userPhone;
	}
	public int getpoint() {
		return this.point;
	}
	
	public String getUserInfo()
	{
		return this.userId + "�� ����� " + this.userGrade +
				"�̰�, ����Ʈ�� " + point +"�� ������������ ����ó�� " +
				this.userPhone +"�Դϴ�.";
	}

}

