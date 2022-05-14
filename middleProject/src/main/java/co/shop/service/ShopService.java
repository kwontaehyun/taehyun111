package co.shop.service;

import co.shop.dao.ShopDAO;
import co.shop.dao.loginDAO;
import co.shop.vo.ShopVO;
import co.shop.vo.loginVO;

public class ShopService {

	ShopDAO dao;

	public ShopService() {
		dao = new ShopDAO();
	}

	// 회원가입
	public void insertMember(ShopVO members) {
		dao.insertMember(members);
	}

	

}
