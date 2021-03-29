package Word;

import java.util.ArrayList;

public interface WordDAO {
	
	// 단어 추가 
		public abstract int insert(WordVO vo);
		
	// 단어 전체 리스트 
		public abstract ArrayList<WordVO> select();
		
	// 단어 리스트 
		public abstract WordVO select(int index);
		
	// 단어 삭제 
		public abstract int delete(int no);
		
	

} // END -------------------------------------
