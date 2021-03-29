package Member;

public interface OracleQuery {
	
	// 1. DB�� ����� �����  
		public static final String URL = 
				"jdbc:oracle:thin:@localhost:1521:xe";  // ������ ����Ŭ DB ���
		public static final String USER = "project";
		public static final String PASSWORD = "project";
//		public static final String driver = "oracle.jdbc.driver.OracleDriver";
		
		public static final String TABLE_NAME ="member";
		public static final String C_CID = "cid";
		public static final String C_NICK = "nick";
		public static final String C_ID = "id";
		public static final String C_PW = "pw";
		public static final String C_EMAIL = "email";
		public static final String C_PHONE = "phone";
		
		
		
		// SQL ���� �ۼ�  
		
		// ȸ�� ���� �� �Է� ���� 
		// insert into member values (cid.nextval, ?, ?, ?, ?, ?)
		public static final String SQL_INSERT 
		= "insert into " + TABLE_NAME 
				+ " values (cid.nextval, ?, ?, ?, ?, ?)";
		
		
		// �α��� �� �Է� ����
		// ȸ�� ������ �����´�, ��ġ�ϴ� ȸ�� ������ �ִٸ� ���ǿ� �ִ´�, ����� �����Ѵ�. 
		// select * from member where id = ? and pw = ?
		public static final String SQL_SELECT_BY_LOGIN
		= "select * from " + TABLE_NAME
		+ " where " + C_ID + "=?" + " and " + C_PW + "=?";
		
		
		// ��� ��ȣ ã��/���� 
		// ȸ�� ������ �����´�, ��ġ�ϴ� ȸ�������� �ִٸ� �ش� ȸ�������� ��й�ȣ�� �����Ѵ�. 
		// update member set pw = ? where id = ? and where phone = ?
		public static final String SQL_UPDATE 
		= "update " + TABLE_NAME
		+ " set " + C_PW + "=?"
		+ " where " + C_ID + "=?" + " and " + C_PHONE + "=?";
		

}
