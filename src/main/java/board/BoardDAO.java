package board;
import java.sql.* ;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
public class BoardDAO {
	// DAO : DataBase 의 Board 테이블을 접근하는 객체 : SQL 쿼리
	
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	
	// sql 쿼리를 상수로 지정함 (변경불가)
	// insert 쿼리
	private final String BOARD_INSERT =
			"insert into board ( seq , title , write , content ) "
			+ "values ( (select nvl(max(seq) , 0 ) + 1 from board ) , ? , ? , ? ) " ;   // 처음에 값이 없을 때는 max 값이 null이 들어가있기 때문에 
																						// null을 0으로 처리하는 함수 nvl을 적용
	
	
	// DB의 Board 테이블의 모든 레코드를 출력하는 쿼리 : 레코드 여러개 -> 레코드 하나가 dto 하나이고 dto 하나하나를 ArraryList에 담아서 List를 리턴
	
	private final String BOARD_LIST = "select * from board order by seq desc" ;
	
	// DB의 Board 테이블의 글 상세 조회 : 레코드 1개 -> 리턴으로 DTO 돌려줌
	private final String BOARD_GET = "select * from board where seq = ? ";
	
	// DB의 Board 테이블의 Update 쿼리
	private final String BOARD_UPDATE = "update board set title = ? , write = ? , content = ? where seq = ? ";   // ?에 변수값 넘어옴
	
	// DB의 Board 테이블의 Delete 쿼리
	private final String BOARD_DELETE = "delete board where seq = ? " ;
	
	// 글 조회수 증가시키는 쿼리
	
	private final String ADD_CNT = "update board set cnt = cnt + 1 where seq = ? " ;
	
	// insertBoard ( BoardDTO dto ) 메소드  :
	public void insertBoard ( BoardDTO dto ) {				// insertBoard 메소드를 호출하면 try 구문이 실행됨
		System.out.println("insertBoard 기능 처리 =");
		
		try { 
			
		 // conn , pstmt 객체 활성화
			conn = JDBCUtil.getConnection() ;
			pstmt = conn.prepareStatement(BOARD_INSERT);
			
		 // pstmt 객체의 ? 에 변수값 할당
			pstmt.setString(1, dto.getTitle());          // 위의 insertBoard 에서 dto 로 들어온 값을 getTitle로 끄집어내서 ?에 값 할당
			pstmt.setString(2, dto.getWrite());
			pstmt.setString(3, dto.getContent());
			
		// pstmt를 실행해서 DB에 저장
		   pstmt.executeUpdate();
		
		   System.out.println("board 테이블에 값이 잘 insert 되었습니다.");
		   
		} catch (Exception e) { 
			
			System.out.println("board 테이블에 값이  insert 실패했습니다.");
			e.printStackTrace();
		} finally {
			// 사용한 객체 제거
			JDBCUtil.close(pstmt, conn);
			
		}
		
	
	}
	// 리턴타입이 없음
	
		// Board 테이블의 전체 레코드를 출력하는 메소드
		// DB에 레코드 하나를 BoardDTO에 담는다. 각 각의 BoardDTO 를 ArrayList 안에 담아서 리턴
		// 위의 rs, pstmt , conn 객체 사용
	
		public List<BoardDTO> getBoardList (BoardDTO dto)  {     // -> 데이터 양이 많으면 리턴값을 List로
			
			// ★ ArrayList는 while 문 밖에서 선언 ( 안에서 선언하면 0번 방만 계속 반복) 
			// ★ ArrayList 내에 저장되는 BoardDTO 는 while 문 안에서 선언
			
			
			List<BoardDTO> boardList = new ArrayList <>() ;
			
			try {
				
				conn = JDBCUtil.getConnection(); 		// conn 객체 활성화 : Oracle , XE , HR!@ , 1234
				pstmt = conn.prepareStatement(BOARD_LIST) ;
				
				// pstmt 를 실행 후 rs 에 레코드를 저장
				rs = pstmt.executeQuery();		// BOARD_LIST를 select 한 레코드 값을 모두 rs에 담고 있다.
				
				// System.out.println("DB Select 성공");
				
				// rs의 각 레코드를 BoardDTO에 저장 --> 각 각의 DTO를 ArrayLIst에 저장
					// if , do  ~ while  <----->  while
					// rs.next() : 다음 레코드가 존재하면 true , 커서가 다음 레코드로 이동 
				
				
				//  BoardDTO board = new BoardDTO();    : 루프 밖에 선언하면 1번만 6번함 (주의★)
				
				while (rs.next())  {     // 
					
					// BoardDTO 객체 생성 ( 이미 위에서 dto라고 선언했기 때문에 다른 변수명 사용)
					
					BoardDTO board = new BoardDTO();  // 루프 블락 내에서 객체를 선언★★★★★
					
					board.setSeq(rs.getInt("SEQ"));       // " " 안에 대문자 사용
					board.setTitle(rs.getString("TITLE"));
					board.setWrite(rs.getString("WRITE"));
					board.setRegdate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
					
					
					// boardList : ArrayList의 add 메소드를 사용해서 boardDTO를 저장함
					boardList.add(board);
					
					
					
					
				}
			
				
			} catch (Exception e)  {
				
				System.out.println("DB Select 실패");
				e.printStackTrace();       //  실패할 경우 콘솔에 오류 정보 출력
				
			} finally {
				// 사용한 객체 반납 : rs, pstmt , conn
				
				JDBCUtil.close(rs, pstmt, conn);
				
			}
			
			
			return boardList ;
			
		}
	
	
		// 글 상세 조회 : getBoard(dto)  -> 레코드가 하나이기 때문에 리턴값을 그냥 DTO로 해도 됨
		public BoardDTO getBoard (BoardDTO dto) {
			
			System.out.println("getBoard 메소드 호출 성공");
			
			// 하위에 있는 조회수 증가 메소드 호출
			addCNT(dto) ;   
			
			BoardDTO board = new BoardDTO () ;
			
			try {
				
				conn = JDBCUtil.getConnection();
				// BOARD_GET = "select * from board where seq = ? "
				pstmt = conn.prepareStatement(BOARD_GET);
				pstmt.setInt(1, dto.getSeq());    // ?에 값 넣어줌
			
				// rs : 레코드 1개
				
				rs = pstmt.executeQuery();
				
				//rs의 값이 존재할 때 
				
				while (rs.next()) {
				
					board.setSeq(rs.getInt("SEQ"));        // board라는 dto에 담는다. 리턴값으로 board 둘려줌
					board.setTitle(rs.getString("TITLE"));
					board.setWrite(rs.getString("WRITE"));
					board.setContent(rs.getString("CONTENT"));
					board.setRegdate(rs.getDate("REGDATE"));
					board.setCnt(rs.getInt("CNT"));
					
					System.out.println("RS의 레코드를 dto 저장 성공");
		
				}
			
			} catch (Exception e ) {
				
				System.out.println("글 상세조회 실패");
				e.printStackTrace();
			
			} finally {
				
				JDBCUtil.close(rs, pstmt, conn);
			}
			
			
			
			return board ;
			
		}
		
		
		// 글 수정 메소드 : updateBoard(dto)        // select 구문은 rs객체가 필요하지만 delete, insert update는 rs 가 필요없다. 리턴 값도 없다.
		
		public void updateBoard(BoardDTO dto) {
			
			System.out.println("updateBoard 메소드 호출됨");  //  잘 작동하면 주석처리
			
			try {
				
				conn = JDBCUtil.getConnection();
				// BOARD_UPDATE ="update board set title = ? , write = ? , content = ? where seq = ? "
				pstmt = conn.prepareStatement(BOARD_UPDATE);
				
				// ? 변수에 값을 할당
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getWrite());
				pstmt.setString(3, dto.getContent());
				pstmt.setInt(4, dto.getSeq());
				
				// 쿼리를 실행
				pstmt.executeUpdate();          // insert, update, delete 구문일 때 실행
				
				System.out.println("DB 업데이트 성공");
				
			} catch (Exception e) {
				
				System.out.println("DB 업데이트 실패");
				e.printStackTrace();                  // 안찍으면 콘솔에서 원인이 출력이 안됨
			
			} finally {
				
				JDBCUtil.close(pstmt, conn);
			}
			
			
			
			
			
		}
		
		
		// 글 삭제 메소드 : deleteBoared(dto)
		
		public void deleteBoard (BoardDTO dto) {
			
			try {
				
				conn = JDBCUtil.getConnection();
				
				// BOARD_DELETE = "delete board where seq = ? "
				pstmt = conn.prepareStatement(BOARD_DELETE);
				
				// ? 변수값 할당

				pstmt.setInt(1, dto.getSeq());
				
				// 쿼리 실행
				pstmt.executeUpdate();     // insert, update, delete
				System.out.println("DB 업데이트 성공");
			} catch (Exception e) {
				
				System.out.println("DB 업데이트 실패");
				e.printStackTrace();                  // 안찍으면 콘솔에서 원인이 출력이 안됨
			} finally {
				
				JDBCUtil.close(pstmt, conn);
			}
			
			
		}
		
		// 글 조회수 증가시키는 메소드 
		
		public void addCNT ( BoardDTO dto) {
			
			try {
				
				conn = JDBCUtil.getConnection();
				// ADD_CNT = "update board set cnt = cnt + 1 where seq = ? "
				
				pstmt = conn.prepareStatement(ADD_CNT);
				
				pstmt.setInt(1, dto.getSeq());
				
				// 쿼리 실행
				
				pstmt.executeUpdate();
				
				System.out.println("DB 업데이트 성공");
				
			} catch (Exception e) {

				System.out.println("DB 업데이트 실패");
				e.printStackTrace();                  // 안찍으면 콘솔에서 원인이 출력이 안됨
			
				
			} finally {
				JDBCUtil.close(pstmt, conn);
			}		
				
			
			
			
		}
	
	
}
