package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class fileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public fileUploadServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title: " + title + ", content : " + content);
		
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir);
		
		int maxSize = 1024 * 1024 * 5;
		String encoding = "UTF-8";
		//multpart 요청을 받으면. 알아서 파일업로드해줌.
		//multpartRequest(요청정보, 저장경로, 파일최대크기지정, 인코딩방식, 리네임정책)
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		title = multi.getParameter("title");
		content = multi.getParameter("content");
		System.out.println("title: " + title + ", content : " + content);
		
		String profile = multi.getOriginalFileName("profile");
		String fileName = multi.getFilesystemName("profile");
		System.out.println("profile: " + profile + ", fileName : " + fileName);
	}

}
