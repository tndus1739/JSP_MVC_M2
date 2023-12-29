<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--  java.util.* : List, ArrayList -->

<%@ page import="java.util.*"%>
<%@ page import="board.BoardDTO"%>
<!--  board : 패키지 이름 / BoardDTO : 파일 이름 -->


<!-- jsp파일에서 말고 위의 자바 백엔드 파일에서 수정을 하면 톰캣이 자동으로 재실행 -->

<%
// Session 변수에 저장된 ArrayList 를 가지고 옴

List<BoardDTO> boardList = new ArrayList<>(); //boardList 에는 dto가 들어있음
//     타입          변수
//  세션에서 가져온 값은 Object 타입이어서 (List 타입으로 변환)

try { // catch 블락은 마지막 밑에

	boardList = (List) session.getAttribute("boardList"); // list 타입으로 캐스팅해줘야 함  // 바로 호출하지말고 do요청을 해야함

	// boardList가  null 값이기 때문에 그냥 불러오면 오류가 남			// 캐스팅 반드시 필요 (다운캐스팅)

	// boardList = (List<BoardDTO>) session.getAttribute("boardList"); -> <BoardDTO> 생략가능
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<hr>

		<!-- 검색 기능 추가 - 시작  -->
		
		
		
		
		
		
		
		<table border="1" width="700px">
			<tr><td>
				<form method="post" action="getBoardList.do">		 <!-- 변수 2개 : searchCondition, searchKeword  -->
					<select name="searchCondition">
						<option value="TITLE">제목 검색</option>    <!-- 옵션으로 선택한게 변수의 값으로 넘어감 -->
						<option value="WRITE">글쓴이 검색</option>	<!-- 테이블의 컬럼이름 -->
						<option value="CONTENT">내용 검색</option>
						<option value="REGDATE">날짜 검색</option>

						</select> <input type="text" name="searchKeyword" size="40"> <input
							type="submit" value="검색시작">

				</form>
			</td> </tr>
			

		</table>
		
		★ 날짜 검색시 : 23/12/29 형식으로 검색하세요 <!-- DB에 저장된 방식 -->
		
		
		<!-- 검색 기능 추가 - 끝  -->
		<p />

		<table border="1" width="700px">

			<tr>
				<!-- td 개수가 맞아야한다. -->
				<th bgcolor="pink" width="100px">번호</th>
				<th bgcolor="pink" width="200px">제목</th>
				<th bgcolor="pink" width="150px">작성자</th>
				<th bgcolor="pink" width="150px">등록일</th>
				<th bgcolor="pink" width="100px">조회수</th>
			</tr>


			<!--  ArrayList의 BoardDTO를 끄집어내서 출력 : loop 돌리면서 출력 -->

			<%
			for (BoardDTO k : boardList) { // for문 시작    : boardList안에 각 각의 방에 BoardDTO가 들어있음
			%>


			<tr>
				<!-- td 개수가 맞아야한다. -->
				<td align="center"><%=k.getSeq()%></td>

				<!--  제목에 링크를 건다 : 글 상세 내용을 볼 수 있도록 ( get title에 링크 걸기) -->

				<td><a href="getBoard.do?seq=<%=k.getSeq()%>"> <%=k.getTitle()%>
				</a> <!--  링크 대소문자 주의  --></td>
				<td><%=k.getWrite()%></td>
				<td><%=k.getRegdate()%></td>
				<td><%=k.getCnt()%></td>
			</tr>

			<%
			} // for문 블락의 끝

			// 모두 사용됨 : boardList
			// 세션 변수의 값을 제거 : 서버의 메모리에서 세션 변수 boardList에 저장한 값을 제거

			session.removeAttribute("boardList");

			} catch (Exception e) {

			response.sendRedirect("getBoardList.do"); // do요청을 보냄
			}
			%>





		</table>

		<br> <a href="http://localhost:8181/JSP_MVC_M2"> 홈으로 </a>
		<p />
		<a href="insertBoard.jsp"> 새글쓰기 </a>

	</center>
</body>
</html>