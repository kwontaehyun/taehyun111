package co.shop.service;

import co.shop.dao.ShopDAO;
import co.shop.dao.loginDAO;
import co.shop.vo.ShopVO;
import co.shop.vo.loginVO;

public class ShopService {

	ShopDAO dao;
	loginDAO dao1;

	public ShopService() {
		dao = new ShopDAO();
	}

	// 회원가입
	public void insertMember(ShopVO members) {
		dao.insertMember(members);
	}

	// 로그인
	public loginVO login(String email, String pw) {
		return dao1.login(email, pw);

	}

}
