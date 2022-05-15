package co.shop.service;

import java.util.List;

import co.shop.dao.basketDAO;
import co.shop.vo.basketVO;

public class basketService {
	basketDAO dao = new basketDAO();
	public List<basketVO> basketList(String email){
		return dao.shoppingBasketList(email);
	}
	
	public void insertbasket(basketVO vo) {
		dao.shoppingBasketInsert(vo);
	}
	
	public basketVO productList(String proDuctNum) {
		return dao.basketProductList(proDuctNum);
	}
	
	public void deletebasket(String proDuctNum) {
		dao.shoppingBasketDelete(proDuctNum);
	}
}
