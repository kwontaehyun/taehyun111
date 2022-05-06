package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertJson implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		
		boolean isMulti = ServletFileUpload.isMultipartContent(request);
		MemberVO vo = null;
		
		if(isMulti) {
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
			
			vo = new MemberVO(id,nm,ps,em,pf);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
			
		}else {
			String id = request.getParameter("id");
			String ps = request.getParameter("pwd");
			String nm = request.getParameter("name");
			String em = request.getParameter("email");
			
			vo = new MemberVO(id,nm,ps,em);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
			response.getWriter().print("{\"msg\": \"처리완료\"}");
			
		}
		// json 형태의 결과 리턴.
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(vo));
	}

}
