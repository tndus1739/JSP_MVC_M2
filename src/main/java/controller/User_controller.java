package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet ("*.act")


public class User_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   
    public User_controller() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// http://localhost:8181/JSP_MVC_M2/*.act
		
		// if else if 문으로 각 조건에 맞는 요청을 처리하는 블락 생성		
		//"/insertUsers.act"
		//"/updateUsers.act"
		//"/deleteUsers.act"
		//"/getUsers.act"
		//"/getUsersList.act"
		//"/login.act"
		//
		request.setCharacterEncoding("UTF-8");
		System.out.println("act 요청을 처리하는 controller입니다. ");
		
		// URL : http://localhost:8181/JSP_MVC_M2/my. act	 (주소 전체)
		// URI : /JSP_MVC_M2/my.act   (서버 주소 뒤에 나오는 부분)
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println("path");
		System.out.println("=============================");
		
		
		if (path.equals("/insertUsers.act")) {
			System.out.println("/insertUsers.act 요청");
			
		}else if (path.equals("/updateUsers.act"))  {
			System.out.println("/updateUsers.act 요청");
			
		} else if (path.equals("/updateUsers.act"))  {
			System.out.println("/updateUsers.act 요청");
		
		}else if (path.equals("/deleteUsers.act"))  {
			System.out.println("/deleteUsers.act 요청");
		
		}else if (path.equals("/getUsers.act"))  {
			System.out.println("/getUsers.act 요청");
		
		}else if (path.equals("/login.act"))  {
			System.out.println("/login.act 요청");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
