package Word;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class WordDAOImple implements WordDAO, WordQuery {
	
	// Singleton 패턴 적용 
		// 1. private static 자기자신 타입 변수 선언  
		private static WordDAOImple instance = null; 
		
		// 2. private 생성자 
		private WordDAOImple() { 
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
		public static WordDAOImple getInstance() { 
			if (instance == null ) { 
				instance = new WordDAOImple();
			}
			return instance;
		}
		
		
		// ------------------------------------------------------------ // 
		
// 단어 추가 
		@Override
		public int insert(WordVO vo) {
			//TODO : vo를 DB에 저장 
			
			System.out.println("insert() - vo :" + vo);
			
            int result = 0; 
			
			Connection conn = null; 
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB연결 성공");
				pstmt = conn.prepareStatement(INSERT_WORD);
				

				pstmt.setString(1, vo.getWord());
				pstmt.setString(2, vo.getMean());
				
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
			
	
// 단어 전체  리스트 
		@Override
		public ArrayList<WordVO> select() {
			// TODO : DB에서 전체 데이터(list)를 선택 
			
        ArrayList<WordVO> list = new ArrayList<WordVO>();
			
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			
			try {
				conn= DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB 연결 성공");
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
		

		
// 단어 삭제
		@Override
		public int delete(int no) {
			// TODO : 해당 번호의 데이터를 DB에서 삭제  
			
            int result = 0;
			
			Connection conn = null; 
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB연결 성공");
				pstmt = conn.prepareStatement(DELETE_WORD);
				
				pstmt.setInt(1, no);
				
				result = pstmt.executeUpdate();
				System.out.println(result + "행의 데이터가 삭제됨.");
			
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
		
// 단어 한줄 리스트 
		@Override
		public WordVO select(int index) {
			// DB에서 인덱스 데이터(vo)를 선택
			
			WordVO vo = null; 
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB 연결 성공");
				
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
