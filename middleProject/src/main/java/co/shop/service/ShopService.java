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

	//아이디중복
	public boolean idcheck(String email) {
		return dao.idcheck(email);
		
	}
	
	//회원정보 수정
	public void update (ShopVO vo){
		dao.update(vo);
	}
	
	//탈퇴
	public void delete(String email) {
		dao.delete(email);
	}
	

}
