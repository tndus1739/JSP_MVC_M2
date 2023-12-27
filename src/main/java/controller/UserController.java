package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8181/JSP_MVC_M2/*.us (M2/ 이후부터 요청)
@WebServlet ("*.us")   // 이 서블릿이 작동됨

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UserController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 한글이 깨지지 않도록 처리 ( client -> server )
		request.setCharacterEncoding("UTF-8");
		
		// 1. 
		String uri = request.getRequestURI();
		//System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		//System.out.println(path);
		
		if ( path.equals("/login.us")) {
			
			System.out.println("login.us 요청 처리");
		
		} else if ( path.equals("/insertUser.us")) {
			
			System.out.println("insertUser.us 요청 처리 ");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
