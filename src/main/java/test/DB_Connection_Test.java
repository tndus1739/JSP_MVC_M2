package test;

import common.JDBCUtil;
import java.sql.* ;

public class DB_Connection_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    // DB 연결 테스트                        // 다른 패지지에 있는 클래스를 할 때는 반드시 import
		JDBCUtil.getConnection();
		
		// ORacle에 연결된 conn객체를 받는다.
		Connection conn = JDBCUtil.getConnection();     // getConnection(); 호출마면 오라클에 연결된 conn객체를 받는다.

				
	}
	
	
}