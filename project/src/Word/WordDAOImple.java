package Word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class WordDAOImple implements WordDAO, WordQuery {
	
	// Singleton ���� ���� 
		// 1. private static �ڱ��ڽ� Ÿ�� ���� ����  
		private static WordDAOImple instance = null; 
		
		// 2. private ������ 
		private WordDAOImple() { 
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
		public static WordDAOImple getInstance() { 
			if (instance == null ) { 
				instance = new WordDAOImple();
			}
			return instance;
		}
		
		
		// ------------------------------------------------------------ // 
		
// �ܾ� �߰� 
		@Override
		public int insert(WordVO vo) {
			//TODO : vo�� DB�� ���� 
			
			System.out.println("insert() - vo :" + vo);
			
            int result = 0; 
			
			Connection conn = null; 
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB���� ����");
				pstmt = conn.prepareStatement(INSERT_WORD);
				

				pstmt.setString(1, vo.getWord());
				pstmt.setString(2, vo.getMean());
				
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
			
	
// �ܾ� ��ü  ����Ʈ 
		@Override
		public ArrayList<WordVO> select() {
			// TODO : DB���� ��ü ������(list)�� ���� 
			
        ArrayList<WordVO> list = new ArrayList<WordVO>();
			
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			
			try {
				conn= DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB ���� ����");
				pstmt = conn.prepareStatement(SELECT_ALL_WORD);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) { 
					int no = rs.getInt(NO);
					String word = rs.getString(WORD);
					String mean = rs.getString(MEAN);			
                	WordVO vo = new WordVO(no, word, mean);
					list.add(vo);

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
			
			return list;
		}
		

		
// �ܾ� ����
		@Override
		public int delete(int no) {
			// TODO : �ش� ��ȣ�� �����͸� DB���� ����  
			
            int result = 0;
			
			Connection conn = null; 
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB���� ����");
				pstmt = conn.prepareStatement(DELETE_WORD);
				
				pstmt.setInt(1, no);
				
				result = pstmt.executeUpdate();
				System.out.println(result + "���� �����Ͱ� ������.");
			
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
		
// �ܾ� ���� ����Ʈ 
		@Override
		public WordVO select(int index) {
			// DB���� �ε��� ������(vo)�� ����
			
			WordVO vo = null; 
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB ���� ����");
				
				pstmt = conn.prepareStatement(SELECT_WORD);
				
				pstmt.setInt(1, index);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) { 
					int no = rs.getInt(NO);
					String word = rs.getString(WORD);
					String mean = rs.getString(MEAN);
					vo = new WordVO(no, word, mean);
					
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



	

} // end  ---------------------------------------------
