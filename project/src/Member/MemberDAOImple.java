package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleDriver;

public class MemberDAOImple implements MemberDAO, OracleQuery {
	
	
	// Singleton ���� ���� 
	// 1. private static �ڱ��ڽ� Ÿ�� ��� ���� ����  
	private static MemberDAOImple instance = null; 
	
	// 2. private ������ 
	  private MemberDAOImple() {
		  // TODO : DB ����̹� ���
		  try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("����̹� �ε� ����");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	  }	  
	  
	// 3. public static �ڱ��ڽ��� �����ϴ� �޼ҵ� 
	  public static MemberDAOImple getInstance() { 
		  if (instance == null) {
			  instance = new MemberDAOImple();
		  }
		  return instance;
	  }
	
	// ------------------------------------------------------------
	
	
	  
    // ȸ������ 
	@Override
	public int insert(MemberVO vo) {
		// TODO : vo�� DB�� ���� 
		System.out.println("insert() - vo : " + vo);
		
		int result = 0; 
		
		Connection conn = null; 
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_INSERT);
		
			pstmt.setString(1, vo.getNick());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());

			result = pstmt.executeUpdate();
			System.out.println(result + "���� �����Ͱ� �߰���.");
			
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

	
	// �α��� 
	@Override
	public MemberVO select(String id, String pw) {
		System.out.println("select() - id : " + id + ", pw : " + pw);
		// TODO : DB���� �ε��� ������(vo)�� ���� 
		MemberVO vo = null;
		
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB ���� ����");
			
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
		// TODO Ư�� �ε����� �����͸� DB���� ����
		int result = 0; 
		
		Connection conn = null; 
		PreparedStatement pstmt = null; 

		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB���� ����");
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.setString(3, phone);
			

			
			result = pstmt.executeUpdate();
			System.out.println(result + "���� �����Ͱ� �����.");
			
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
