package co.shop.service;

import java.util.List;
import java.util.Map;

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
	
	public void kakaoInsertMember(ShopVO members) {
		dao.kakoInsertMember(members);
	}
	

	//아이디중복
	public boolean idcheck(String email) {
		return dao.idcheck(email);
		
	}
	
	public Map<String, Integer> userGenderChart(){
		return dao.genderChart();
	}
	
	//회원정보 수정
	public void update (ShopVO vo){
		dao.update(vo);
	}
	
	//탈퇴
	public boolean delete(String email) {
		return dao.delete(email);
	}
	
	//회원리스트
	public List<ShopVO> listShop() {
		return dao.listShop();
		
	}

	//회원정보조회
	public ShopVO search(String email) {
		return dao.search(email);
	}
	
	public String findId(String tel) {
		return dao.findId(tel);
	}
}
