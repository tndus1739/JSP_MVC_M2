package test;

import org.eclipse.jdt.internal.compiler.batch.Main;

import board.BoardDAO;
import board.BoardDTO;

public class Board_Insert_Test02 {
	
	public static void main(String[] args) {
		
	// 객체 만들려면 메인메소드 필요
		
		
	// Board 테이블에 값이 잘 들어가는지 테스트 : BoardDTO , BoardDAO : insertBoard (dto)   -->  insertBoard라는 메소드를 만들었는데 이 메소드가 잘 작동되는지 테스트  
	//                                                                                   (dto가 매개변수)
	
	
	// 1. BoardDTO 에 setter를 사용해서 각 필드의 값을 insert
	BoardDTO dto = new BoardDTO ();      // 패키지가 다르기 때문에 inmport 필요
	
	dto.setTitle("제목입니다 - 26일");
	dto.setContent("내용입니다 - 26일");
	dto.setWrite("김길동");
	
	// 2. BoardDAO 의 insertBoard(dto) 가 잘 작동하는지 메소드 테스트
	
	BoardDAO dao = new BoardDAO ();
	dao.insertBoard(dto);
	
	
	
	
	
	
	
	
	
	}	
}
