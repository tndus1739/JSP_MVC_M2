package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//http://localhost:8181/JSP_MVC_M2/*.ac  (마지막에 확장자 ac로 요청하면 WebServlet 컨트롤러가 다 받게됨)
@WebServlet("*.ac")  // import 시킴

public class Test_Controller02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Test_Controller02() {
        super();
       
    }

	// get 방식 메소드  (클라이언트가 보내는 doget 요청은 request 객체가 받게됨)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		System.out.println("*.ac 요청에 대한 컨트롤러입니다.");
	}

	// post 방식 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
