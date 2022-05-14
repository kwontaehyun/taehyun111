package co.shop.service;

import co.shop.dao.loginDAO;

public class loginService {
	// 로그인

	loginDAO dao = new loginDAO();
	
	public boolean login(String email, String pw) {
		return dao.login(email, pw);
	}
	
	public boolean loginIderror(String email) {
		return dao.idCheck(email);
	}
	public boolean loginPwerror(String pw) {
		return dao.idCheck(pw);
	}
	
}
