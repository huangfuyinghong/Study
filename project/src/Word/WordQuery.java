package Word;

public interface WordQuery {

	// 1. DB�� ����� �����  
				public static final String URL = 
						"jdbc:oracle:thin:@localhost:1521:xe";  // ������ ����Ŭ DB ���
				public static final String USER = "project";
				public static final String PASSWORD = "project";
//				public static final String driver = "oracle.jdbc.driver.OracleDriver";
				
				
				public static final String TABLE_NAME= "engword";
				public static final String NO = "no";
				public static final String  WORD = "word";
				public static final String MEAN = "mean";
				
				
				
				
				
		// --------------------------------------------------------------------- // 
				
				
				// �ܾ� �߰� 
				// insert into engword values (n.nextval, ?, ?, ); 
				public static final String INSERT_WORD
				= "insert into " + TABLE_NAME
				+ " values (no.nextval, ?, ?)"; 
				
				// ��ü �ܾ� ����Ʈ 
				// select * from engword order by no;
				public static final String SELECT_ALL_WORD
				= "select * from " + TABLE_NAME
				+ " order by " + NO;
				
				public static final String SELECT_WORD
				= "select * from " + TABLE_NAME
				+ " order by " + NO + "=?";
				
				
				// �ܾ� ����  
				// delete from engword where no = ?; 
				public static final String DELETE_WORD
				= "delete from " + TABLE_NAME
				+ " where " + NO + "=?";
				

}  // end -----------------------------------------------
