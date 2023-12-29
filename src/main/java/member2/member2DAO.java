package member2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class member2DAO {

	
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	
	
	// sql 쿼리를 상수로 지정함 
	
	private final String MEMBER_INSERT = " insert into member2 values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ";
	
	
	
	
	
	
	
	
	
}
