package controller;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import board.BoardDAO;
import board.BoardDTO;


// http://localhost:8181/JSP_MVC_M2/*.do (M2/ 이후부터 요청)
@WebServlet ("*.do")
public class Board_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Board_Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
				// get , post 요청 모두 처리됨
				// 한글이 깨어지지 않도록 처리
			  
				request.setCharacterEncoding("UTF-8");
				System.out.println("do 요청을 처리하는 controller 입니다.");
			    
				// URL : http://localhost:8181/JSP_MVC_M2/my.do	 (주소 전체)
				// URI : /JSP_MVC_M2/my.do   (서버 주소 뒤에 나오는 부분)
				
				String uri = request.getRequestURI();
				System.out.println(uri);
				
				// 
				String path = uri.substring(uri.lastIndexOf("/"));   // uri 의 마지막 "/" 뒤에 있는 것을 path 변수값으로 처리
				System.out.println(path);
				System.out.println("===============================");
		
				
				if (path.equals("/insertBoard.do")) {
				
					System.out.println("/insertBoard.do 요청");
					// 로직 처리
					
					// 1. 클라이언틀의 넘어오는 변수가 잘 들어 오는지 확인 ( 클라이언트 요청 : /insertBoard.do 요청)
					
					String title = request.getParameter("tilte");   // 클라이언트에서 넘어오는 변수를 getParameter를 통해 새로운 변수에 담기 
					String write = request.getParameter("write");
					String content = request.getParameter("content");
					
					/* 잘 처리됐으면 주석처리
					System.out.println("title : " + title );  // 잘 넘어오는지 콘솔에 한 번 찍어 보는 것
					System.out.println("write : " + write );
					System.out.println("content : " + content );
					*/
				
					// 2. 클라이언트에서 넘어오는 변수의 값을 DTO에 setter 주입
					
					BoardDTO dto = new BoardDTO () ;
					
					dto.setTitle(title);
					dto.setWrite(write);
					dto.setContent(content);
					
					// 3. DAO에 insertBoard (dto) 
				
					BoardDAO dao = new BoardDAO ();
					dao.insertBoard(dto);
					
					// insert 성공
					
					System.out.println("DB 저장 성공");
				
					// 비즈니스 로직 완료 : DTO , DAO
					
					// 4. 뷰 페이지 전송 : 값을 insertBoard 후 DB의 전체 레코드를 출력 페이지로 이동
						// 클라이언트가 / getBoardList.do 요청을 새롭게 요청함
						// 주의 : http://localhost:8181/getBoardList.do -> 오류 발생
								 http://localhost:8181/JSP_MVC_M2/getBoardList.do  -> 정상
						
					response.sendRedirect("getBoardList.do");    // 여기서는 " / " 쓰지마  ( /가 root로 인식됨)
				
				} else if (path.equals("/getBoardList.do")) {    // DB의 레코드를 출력하는 페이지
					System.out.println("/getBoardList.do 요청");
					// 로직 처리
					
					// 1. BoardDTO 객체 생성
					BoardDTO dto = new BoardDTO () ;
					
					// 2. BoardDAO 객체의 getboardList (dto) 
					BoardDAO dao = new BoardDAO ();
					
					// 리턴 받을 변수 선언
					List<BoardDTO> boardList = new ArrayList <>();
					// boardList : DB의 board 테이블의 레코드를 dto로 저장 후 ArrayList 내의 각 방에 저장된 상태
					boardList = dao.getBoardList(dto);
					
					// boardList 클라이언트 view 페이지로 전송 : session 변수에 담아서 client  뷰페이지로 전송
					//  client의 session 정보를 가져와서 session 변수에 할당
					
					HttpSession session = request.getSession();
					
					// 세션에 boardList 를 추가
					session.setAttribute("boardList",boardList);     // "boardList" : session 변수에  / boardList ( ArrayList)를 담겠다.
					
					// 클라이언트 뷰 페이지
					response.sendRedirect("getBoardList.jsp");
					
					
					
				}else if (path.equals("/getBoard.do")) {
					System.out.println("/getBoard.do 요청");
					// 로직 처리
					
					//  1. client 에서 넘어오는 파라미터 seq변수의 값을 읽어서 dto에 저장 후 dao.getBoard(dto)
					// http://localhost:8181/JSP_MVC_M2/getBoard.do?seq=5
					int seq = Integer.parseInt(request.getParameter("seq")) ; // request.getParameter("seq")가 String 형태라서 int로 변환시켜야함
					
					// 2. dto에 seq 값을  setter 주입
					BoardDTO dto = new BoardDTO ();
					
					dto.setSeq(seq);
					
					// 3. DAO의 getBoard (dto) 호출 후 리턴 값을 받아서 저장
					BoardDAO dao = new BoardDAO () ;
					
					// 리턴값을 받을 DTO 선언
					
					BoardDTO board = new BoardDTO () ;
					
					board = dao.getBoard(dto);  // 리턴값으로 board를 넘겨준다.
					
					// 4. 세션 변수에 저장후 뷰 페이지로 전송
					HttpSession session = request.getSession();
					
					session.setAttribute("board", board) ;
					
					// 5. 뷰 페이지
					response.sendRedirect("getBoard.jsp");
					
				}else if (path.equals("/updateBoard.do")) {
					System.out.println("/updateBoard.do 요청");
					// 로직 처리
				}else if (path.equals("/deleteBoard.do")) {
					System.out.println("/deleteBoard.do 요청");
					// 로직 처리
				}
	
			}	
		
		
		                                                                 // response :server에서 client로 보내는 객체
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);			//
	}  // dopost로 받아도 doget으로 받아서 위의 do get으로 던져줌

}