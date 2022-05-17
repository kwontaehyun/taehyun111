package co.shop.service;

import java.util.List;
import java.util.Map;

import co.shop.dao.productDAO;
import co.shop.vo.productVO;

public class productService {
	productDAO dao = new productDAO();
	public List<productVO> homeList(){
		return dao.proDuctList();
	}
	public productVO detailSearch(String proDuctNum) {
		return dao.searchProd(proDuctNum);
	}
	public List<String> cateGory(){
		return dao.menuList();
	}
	
	public List<productVO> cateGoryList(String category){
		return dao.menuClickEvent(category);
	}
	
	public void insertProduct(productVO vo) {
		dao.adminInsertProduct(vo);
	}
	public Map<String, Integer> prodGenderChart(){
		return dao.genderChart();
	}
}
