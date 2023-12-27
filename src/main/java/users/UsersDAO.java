package users;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;

public class UsersDAO {

	// SQL 쿼리를 접근하는 객체 선언
	
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;		     // 기본값 null로 선언
	
	// SQL 쿼리를 적용하는 상수 선언
	
	private final String USERS_LOGIN = "select * from users where id = ?  and password = ? "; 
			
	
	
	// 메소드 
	
	public UsersDTO login(UsersDTO dto) {     // login 이라는 메소드 
		System.out.println("login메소드 호출");
		
		// 리턴으로 돌려줄 UserDTO -> 
		UsersDTO user = null ;
		
		try {
			
			conn = JDBCUtil.getConnection();
			
			// USERS_LOGIN = "select * from users where id = ?  and password = ? "   // select 쿼리이기 때문에 rs로 값을 받아야 함
			pstmt = conn.prepareStatement(USERS_LOGIN);
			
			// ? 변수의 값 할당
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword()); 
			
			System.out.println(dto.getId());
			System.out.println(dto.getPassword());
			
			// pstmt 실행 후 rs로 쿼리한 레코드 저장
			
			rs = pstmt.executeQuery() ;     // select
			
			// rs의 값이 존재할 때 인증 성공 : 레코드 1개가 출력( 아이디 , 패스워드가 맞을 때)
			
			while (rs.next())  {
				
				// 리턴으로 돌려줄 dto 선언
				
				
				user = new  UsersDTO () ;
				
				user.setId(rs.getNString("ID"));
				user.setName(rs.getNString("NAME"));
				user.setPassword(rs.getNString("PASSWORD"));
				user.setRole(rs.getNString("ROLE"));
				 
				System.out.println("인증성공 : 해당 ID와 PASSWORD가 정확히 일치합니다.");
			}
			
			
		} catch (Exception e ) {
			
			System.out.println("인증시 문제발생");
			e.printStackTrace();
			
		} finally {
			
			JDBCUtil.close(rs, pstmt, conn);
			
		}
		return user ;
	}
	
}
