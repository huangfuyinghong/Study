package Word;

import java.util.ArrayList;

public interface WordDAO {
	
	// �ܾ� �߰� 
		public abstract int insert(WordVO vo);
		
	// �ܾ� ��ü ����Ʈ 
		public abstract ArrayList<WordVO> select();
		
	// �ܾ� ����Ʈ 
		public abstract WordVO select(int index);
		
	// �ܾ� ���� 
		public abstract int delete(int no);
		
	

} // END -------------------------------------
