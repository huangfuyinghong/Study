package Member;

public interface OracleQuery {
	
	// 1. DB에 사용할 상수들  
		public static final String URL = 
				"jdbc:oracle:thin:@localhost:1521:xe";  // 접속할 오라클 DB 경로
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
		
		
		
		// SQL 문장 작성  
		
		// 회원 가입 시 입력 내용 
		// insert into member values (cid.nextval, ?, ?, ?, ?, ?)
		public static final String SQL_INSERT 
		= "insert into " + TABLE_NAME 
				+ " values (cid.nextval, ?, ?, ?, ?, ?)";
		
		
		// 로그인 시 입력 내용
		// 회원 정보를 가져온다, 일치하는 회원 정보가 있다면 세션에 넣는다, 결과를 보고한다. 
		// select * from member where id = ? and pw = ?
		public static final String SQL_SELECT_BY_LOGIN
		= "select * from " + TABLE_NAME
		+ " where " + C_ID + "=?" + " and " + C_PW + "=?";
		
		
		// 비밀 번호 찾기/변경 
		// 회원 정보를 가져온다, 일치하는 회원정보가 있다면 해당 회원정보의 비밀번호를 변경한다. 
		// update member set pw = ? where id = ? and where phone = ?
		public static final String SQL_UPDATE 
		= "update " + TABLE_NAME
		+ " set " + C_PW + "=?"
		+ " where " + C_ID + "=?" + " and " + C_PHONE + "=?";
		

}
