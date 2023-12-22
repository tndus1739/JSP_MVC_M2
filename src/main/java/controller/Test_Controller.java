package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8181/JSP_MVC_M2/abc.my (M2/ 이후부터 요청)
@WebServlet ("*.my")   // 이 서블릿이 작동됨
public class Test_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    // Test_Controller 기본 생성자
    public Test_Controller() {
        super();
        
    }

							// 클라이언드가 보내는 모든요청을  request 객체가 다 받는다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// client 가 보내는 get 요청도 처리
		// client 가 보내는 post 요청도 처리
	
		// 한글이 깨어지지 않도록 처리
		request.setCharacterEncoding("UTF-8");
		System.out.println("Test Controller 잘 호출됨");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
