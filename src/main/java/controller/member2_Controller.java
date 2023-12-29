package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("*.mem") 
//http://localhost:8181/JSP_MVC_M2/*.mem (M2/ 이후부터 요청)

public class member2_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public member2_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// get , post 요청 모두 처리됨
		// 한글이 깨어지지 않도록 처리
	  
		request.setCharacterEncoding("UTF-8");
		System.out.println("mem 요청을 처리하는 controller 입니다.");
	    
		// URL : http://localhost:8181/JSP_MVC_M2/my.mem	 (주소 전체)
		// URI : /JSP_MVC_M2/my.mem   (서버 주소 뒤에 나오는 부분)
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		// 
		String path = uri.substring(uri.lastIndexOf("/"));   // uri 의 마지막 "/" 뒤에 있는 것을 path 변수값으로 처리
		System.out.println(path);
		System.out.println("===============================");
	
		if ( path.equals("/member2Insert.mem")) {
			
		System.out.println("/member2Insert.mem 요청--");	
			
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass1 = request.getParameter("pass1");
		String sex = request.getParameter("sex");
		String hobby = request.getParameter("hobby");
		String nation = request.getParameter("nation");
		int zone = Integer.parseInt(request.getParameter("zone"));
		int phone1 = Integer.parseInt(request.getParameter("phone1"));
		int phone2 = Integer.parseInt(request.getParameter("phone2"));
		String profile = request.getParameter("profile");
		
		System.out.println(id);
		System.out.println(name);
		System.out.println(pass1);
		System.out.println(sex);
		System.out.println(hobby);
		System.out.println(nation);
		System.out.println(zone);
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(profile);
		
		
		
		
		
		
		
		
		
		}
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
