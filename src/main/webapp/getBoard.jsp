<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="board.BoardDTO" %>    


<%

		// session 변수에 담긴 값을 불러옴 : 서버의 RAM 
		
		BoardDTO board = new BoardDTO () ;

		//session변수의 값을 가져올 때는 다운캐스팅 필요
		board = ( BoardDTO ) session.getAttribute("board");    // getAttribute : 변수의 값을 가지고 옴)  

	


%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 글 상세 페이지</title>
</head>
<body>


	<h1> 글 상세 페이지 ( 수정이 가능하도록 )</h1>
	<hr> 
	<br> <br>
	
	<form >
		<table border = "1" width = "700px" cellpedding = "5px">
			<tr> <td bgcolor = "pink" align ="center" > 제목 </td>
				 <td> <input type ="text" name = "title" value="<%= board.getTitle() %>" > </td>
			</tr>
			
			<tr> <td bgcolor = "pink" align ="center"> 작성자 </td>
				 <td> <input type ="text" name = "write" value="<%= board.getWrite() %>" > </td>
			</tr>
			
			<tr> <td bgcolor = "pink" align ="center"> 내용 </td>
				 <td> <textarea rows = "10" cols ="70" > <%= board.getTitle() %>" > </textarea> </td>
			</tr>
			
			<tr> <td bgcolor = "pink" align ="center"> 등록일 </td>
				 <td> <%= board.getRegdate() %> </td>
			</tr>
			
			<tr> <td bgcolor = "pink" align ="center"> 조회수 </td>
				 <td> <%= board.getCnt() %> </td>						<!-- 수정 못하도록 --> 
			</tr>
			
			<tr> <td colspan = "2" align = "center"> <input type = "submit" value = "★수정★"> </td>
			</tr>
	
	
	
		</table>
	
	
	
	
	
	</form>
	
	










</body>
</html>