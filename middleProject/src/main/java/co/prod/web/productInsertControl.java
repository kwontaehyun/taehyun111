package co.prod.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.shop.service.productService;
import co.shop.vo.productVO;
import co.shop.web.Controller;

public class productInsertControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDir = "upload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		// multipart 요청.
		// request, 저장위치, 최대사이즈, 인코딩, 리네임정책. file.jpg, file1.jpg
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding,
				new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String category = multi.getParameter("category");
		String comment = multi.getParameter("comment");
		String saleCheck = multi.getParameter("sale");
		int sale = 0;
		if(saleCheck == null) {
			sale = 0;
		}else {
			sale = Integer.parseInt(multi.getParameter("sale"));
		}
		
		String pimg = multi.getFilesystemName("pimg");
		String gender = multi.getParameter("gender");
		String email = multi.getParameter("email");
		
		productVO vo = new productVO();
		vo.setProDuctName(name);
		vo.setProDuctPrice(price);
		vo.setCateGory(category);
		vo.setComment(comment);
		
		vo.setSale(sale);
		vo.setpImg(pimg);
		vo.setGender(gender);
		vo.setEmail(email);
		System.out.println(pimg);
		productService service = new productService();
		service.insertProduct(vo);
		
		response.sendRedirect("/middleProject/index.jsp");
	}
}
