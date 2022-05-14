package co.shop.service;

import java.util.List;

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
}
