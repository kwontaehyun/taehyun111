package co.shop.service;

import java.util.List;

import co.shop.dao.payDAO;
import co.shop.vo.payVO;

public class payService {
	payDAO dao = new payDAO();
	public void kakaoPay(payVO vo) {
		dao.insertPay(vo);
	}
	
	public List<payVO> userPayment(String email){
		return dao.userPaySelect(email);
	}
	public List<payVO> sumPaySelect(){
		return dao.adminPaySelect();
	}
	
	public List<payVO> userPayment(String email, int firstPage, int lastPage){
		return dao.userPay(email, firstPage, lastPage);
	}
	
	public int userCount(String email) {
		return dao.userCount(email);
	}
	
	public List<payVO> sumPaySelect(int firstPage, int lastPage){
		return dao.adminPay(firstPage, lastPage);
	}
	
	public int adminCount() {
		return dao.adminCount();
	}
	
	
	public int sumPayMoney() {
		return dao.sumPay();
	}
	public int monthSum(String month) {
		return dao.MonthsumPay(month);
	}
	
	
}
