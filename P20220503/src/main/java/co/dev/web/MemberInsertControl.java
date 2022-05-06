package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;
public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveDir = "upload";
		saveDir = request.getServletContext().getRealPath(saveDir);
		
		int maxSize = 1024 * 1024 * 5;
		String encoding = "UTF-8";
		//multpart 요청을 받으면. 알아서 파일업로드해줌.
		//multpartRequest(요청정보, 저장경로, 파일최대크기지정, 인코딩방식, 리네임정책)
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		System.out.println("입력처리 컨트롤러");
		String id = multi.getParameter("id");
		String ps = multi.getParameter("pwd");
		String nm = multi.getParameter("name");
		String em = multi.getParameter("email");
		String pf = multi.getFilesystemName("profile");
		
		MemberVO vo = new MemberVO(id,nm,ps,em,pf);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		request.setAttribute("id", id);
		request.setAttribute("name", nm);
		// Dispatcher 객체 forword.
		request.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(request, response);
		
		
	}

}
