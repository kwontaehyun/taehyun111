package project;

public class Login extends SignUp{
	
	private int LoginCount;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String userName, String userBirth, String userID, String userPwd, String userEmail, int LoginCount) {
		super(userName, userBirth, userID, userPwd, userEmail);
		this.LoginCount = LoginCount;
	}

	public int getLoginCount() {
		return LoginCount;
	}

	public void setLoginCount(int loginCount) {
		LoginCount = loginCount;
	}

	@Override
	public String toString() {
		return "Login [LoginCount=" + LoginCount + ", toString()=" + super.toString2() + "]";
	}
	
	
	
}
