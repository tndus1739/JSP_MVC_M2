<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 폼 페이지</h1>
	<hr>
	<p />

	<form method="post" action="login.us">
		<!--  중요한 정보니까 post 방식으로 넘기기  -->
		<table>

			<tr>
				<td> ID : </td>
				<td> <input type = "text" name = "id"> </td>
			</tr>
			<tr>
				<td> password : </td>
				<td> <input type = "password" name = "password"> </td>
			</tr>
			<tr>
				<td colspan="2" align="center"> <input type= "submit" value="로그인">
				</td>
			</tr>




		</table>




	</form>

	<p />
	<a href="http://localhost:8181/JSP_MVC_M2"> 홈으로 </a>





</body>
</html>