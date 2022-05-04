package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		
		if(id.isEmpty() || name.isBlank() || passwd.isBlank() || email.isBlank()) {
			request.setAttribute("error", "모든항목을 입력해주세요.");
			request.getRequestDispatcher("memberView/memberUpdate.jsp").forward(request, response);
			return;
		}
		
		MemberService service = new MemberService();
		MemberVO member = new MemberVO(id,name,passwd,email);
		service.memberUpdate(member);
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("passwd", passwd);
		request.setAttribute("email", email);
		
		request.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(request, response);
		
	}

}
