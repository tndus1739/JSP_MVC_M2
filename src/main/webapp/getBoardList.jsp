<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  java.util.* : List, ArrayList -->
    
<%@ page import = "java.util.*" %>    
<%@ page import = "board.BoardDTO" %>   <!--  board : 패키지 이름 / BoardDTO : 파일 이름 -->


<% 

	// Session 변수에 저장된 ArrayList 를 가지고 옴

	List<BoardDTO> boardList = new ArrayList<>();

	//  세션에서 가져온 값은 Object 타입이어서 (List 타입으로 변환)
	
	try {
		
		boardList = (List) session.getAttribute("boardList");     // 바로 호출하지말고 do요청을 해야함

	} catch ( Exception e ) {
		
		response.sendRedirect("/getBoardList.do");
	}
	
	

%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 목록</title>
</head>
<body>
<center>
	<h1>  글 목록 </h1>
	<hr>
	
	<table border = "1" width = "700px">
	
		<tr> <th bgcolor = "pink" width = "100px" > 번호 </th>
			 <th bgcolor = "pink" width = "200px"> 제목 </th>
			 <th bgcolor = "pink" width = "150px"> 작성자 </th>
			 <th bgcolor = "pink" width = "150px"> 등록일 </th>
			 <th bgcolor = "pink" width = "100px"> 조회수 </th>
		</tr>
		
		
		<!--  ArrayList의 BoardDTO를 끄집어내서 출력 : loop 돌리면서 출력 -->
		
		<%
			for (BoardDTO  k :  boardList) {
				
		%>
		
		
		<tr> <td align = "center" > <%= k.getSeq()  %></td>
			 <td> <%= k.getTitle()  %></td>
			 <td> <%= k.getWrite()  %></td>
			 <td> <%= k.getRegdate()  %></td>
			 <td> <%= k.getCnt()  %></td>
		</tr>
	
		<%
			}
		
		%>
		
	
		
	
	
	</table>



</center>
</body>
</html>