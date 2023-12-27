<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  지시어  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- view 페이지 : 클라이언트에게 보여지는 페이지 -->
	<center>

		<h1>새 글 등록 - 로그인한 사용자만 등록 가능</h1>
		<hr>
		<!--form 태그안에 변수 값을 담아서 insertBoard.do 호출   -->
		<form method="post" action="insertBoard.do">
			<!-- do 요청은 Board_Controller.java에서 받도록 설정   -->
			<table border="1" cellpadding="10" cellspacing="0">
				<!-- cellpadding : cell과 cell 사이의 간격  -->
				<tr>
					<td bgcolor="pink">제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td bgcolor="pink">작성자</td>
					<td><input type="text" name="write" size="10"></td>
				</tr>
				<tr>
					<td bgcolor="pink">내용</td>
					<td><textarea name="content" cols="40" rows="10"> </textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="새 글등록"></td>
				</tr>

			</table>


		</form>

<br> <a href="http://localhost:8181/JSP_MVC_M2"> 홈으로 </a>
		<p /> <a href = "getBoardList.do"> 새글쓰기 </a>



	</center>



</body>
</html>