package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class MemberDAOImple implements MemberDAO, OracleQuery {
	
	
	// Singleton 패턴 적용 
	// 1. private static 자기자신 타입 멤버 변수 선언  
	private static MemberDAOImple instance = null; 
	
	// 2. private 생성자 
	  private MemberDAOImple() {
		  // TODO : DB 드라이버 등록
		  try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  }	  
	  
	// 3. public static 자기자신을 리턴하는 메소드 
	  public static MemberDAOImple getInstance() { 
		  if (instance == null) {
			  instance = new MemberDAOImple();
		  }
		  return instance;
	  }
	
	// ------------------------------------------------------------
	
	
	  
    // 회원가입 
	@Override
	public int insert(MemberVO vo) {
		// TODO : vo를 DB에 저장 
		System.out.println("insert() - vo : " + vo);
		
		int result = 0; 
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_INSERT);
		
			pstmt.setString(1, vo.getNick());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());

			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 추가됨.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally { 
			
			try {
				pstmt.close();
				conn.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return result;
	}

	
	// 로그인 
	@Override
	public MemberVO select(String id, String pw) {
		System.out.println("select() - id : " + id + ", pw : " + pw);
		// TODO : DB에서 인덱스 데이터(vo)를 선택 
		MemberVO vo = null;
		
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_LOGIN);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				
				id = rs.getString(C_ID);
				pw = rs.getString(C_PW);
				vo = new MemberVO(id, pw);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return vo;
	}

	@Override
	public int update(String id, String phone, String pw) {
		// TODO 특정 인덱스의 데이터를 DB에서 변경
		int result = 0; 
		
		Connection conn = null; 
		PreparedStatement pstmt = null; 

		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.setString(3, phone);
			

			
			result = pstmt.executeUpdate();
			System.out.println(result + "행의 데이터가 변경됨.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
	}


} // end  ---------------------------------------------
