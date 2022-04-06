package project;

import java.util.List;

public interface SignUpService {
	public List<SignUp> searchNumber();
	public void userSignUp(SignUp signup);
	public String IDSerach(String name, String birth);
	public String pwdSearch(String name, String birth, String ID);
	public SignUp userLogin(String ID, String pwd);
	public String userPhone(String phoneNumber, String name, String id, String birth);
}
