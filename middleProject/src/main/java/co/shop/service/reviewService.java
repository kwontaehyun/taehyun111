package co.shop.service;

import java.util.List;

import co.shop.dao.reviewDAO;
import co.shop.vo.reviewVO;

public class reviewService {
	reviewDAO dao = new reviewDAO();
	
	public List<reviewVO> detailPagelist(String productNum){
		return dao.reviewList(productNum);
	}
	
	public int AvgGrade(String productNum) {
		return dao.avgGrade(productNum);
	}
	
	public void reviewInsert(reviewVO review) {
		dao.reviewInsert(review);
	}
	
	public void reviewDelete(String email) {
		dao.reviewDelete(email);
	}
}
