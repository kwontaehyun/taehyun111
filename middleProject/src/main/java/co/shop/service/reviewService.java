package co.shop.service;

import java.util.List;

import co.shop.dao.reviewDAO;
import co.shop.vo.reviewVO;

public class reviewService {
	reviewDAO dao = new reviewDAO();
	
	public List<reviewVO> detailPagelist(String productNum, int firstPage, int lastPage){
		return dao.reviewPage(productNum, firstPage, lastPage);
	}
	
	public int count(String proDuctNum) {
		return dao.count(proDuctNum);
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
	//수정을 위한 단건 조회 
	public  reviewVO selReview(int reviewNum) {
		return dao.selReview(reviewNum);
	}
	public void adminReviewDelete(int reviewNum) {
		dao.adminReviewDelete(reviewNum);
	}
}
