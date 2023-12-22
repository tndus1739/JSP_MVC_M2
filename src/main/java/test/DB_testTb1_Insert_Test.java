package test;

import java.sql.*;
import common.JDBCUtil;

public class DB_testTb1_Insert_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sql = null ;
		Statement stmt = null ;
		PreparedStatement pstmt = null ;
		Connection conn = null ;
		ResultSet rs = null ;
		
		conn = JDBCUtil.getConnection();
		
		sql = "insert into testTb1 ( id , name , email ) " ;
		sql += "values ( nvl (((select Max(id) from testTb1 ) + 1 ) , 1 ) , ";   // select Max(id) from testTb1 가 한컬럼
		sql += " ? , ? )" ;														 // null값을 1로 처리
		
		
		// 자바에서 pstmt 는 예외 처리가 필요하다. 
		
		try {
		
			// pstmt 활성화
			pstmt = conn.prepareStatement(sql);
			
			// pstmt 의 ?에 변수값 할당
			
			for ( int i = 0 ; i < 1000 ; i++) {
				
				pstmt.setString(1, "아아아 - " + i );
				pstmt.setString(2, "aaa@aaa - " + i );
				
				pstmt.executeUpdate();
			
			}
			
			System.out.println("DB에 1000개의 레코드가 저장되었습니다. ");
			
		}catch ( Exception e) {		
			 System.out.println("저장 중 오류가 발생되었습니다.");	
			 e.printStackTrace();
		
		
		} 
		
		JDBCUtil.close(pstmt, conn);
		 
		
		
		/*finally {   // close 메소드 하나 만들면 이거 사용안해도 됨
		
			 // 사용한 객체 제거 , try {} 에서 오류 없어도 작동 , 오류가 발생해도 작동
			// 사용한 객체 반납  --> try , catch로 묶어줘야함
			
			try {
				
				conn.close();
				pstmt.close();
				
				
			} catch ( Exception e ) {
				
				
			}*/
			
			
		
		
		
	}

}
