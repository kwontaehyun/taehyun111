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
	//리뷰 입력
	public void reviewInsert(reviewVO review) {
		dao.reviewInsert(review);
	}
	//리뷰삭제
	public void reviewDelete(int reviewNum,String email) {
		dao.reviewDelete(reviewNum,email);
	}
	//리뷰수정
	public void reviewUpdate(reviewVO vo) {
		dao.reviewUpdate(vo);
	}
}
