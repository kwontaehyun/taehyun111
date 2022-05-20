package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.shop.service.reviewService;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class modiReviewControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("수정 처리  ");

		request.setCharacterEncoding("utf-8");
		
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		String saveDir = "reviewUpload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
				new DefaultFileRenamePolicy());

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email+"1");
		int prodNum = Integer.parseInt(multi.getParameter("proNum"));
		System.out.println(prodNum+"2");
		int reNum = Integer.parseInt(multi.getParameter("reNum"));
		System.out.println(reNum+"8");
		if (email == null) {
			request.setAttribute("error", "로그인후 이용");
			request.getRequestDispatcher("showView/login.jsp").forward(request, response);
			return;
		}

		
		if(isMulti) {
			
			String pf = multi.getFilesystemName("profile");
			System.out.println(pf+"3");
			String content =multi.getParameter("content");
			System.out.println(content+"4");
			int grade = Integer.parseInt(multi.getParameter("grade"));
			System.out.println(grade+"5");
			
			reviewVO vo = new reviewVO();
			vo.setRImg(pf);
			vo.setContent(content);
			vo.setGrade(grade);
			vo.setReviewNum(reNum);
			vo.setEmail(email);
			
			reviewService service = new reviewService();
			service.reviewUpdate(vo);
			request.getRequestDispatcher("/detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
		}else {
			String content = request.getParameter("content");
			System.out.println(content+"6");
			int grade = Integer.parseInt(request.getParameter("grade"));
			System.out.println(grade+"7");

			reviewVO vo = new reviewVO();
			vo.setContent(content);
			vo.setGrade(grade);
			vo.setReviewNum(reNum);
			vo.setEmail(email);
			
			reviewService service= new reviewService();
			service.reviewUpdate(vo);
			
			request.getRequestDispatcher("detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
			
			
		}
		
		
		
		
		
		

		
	}

}
