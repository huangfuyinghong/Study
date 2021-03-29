package Member;

public interface MemberDAO {
	
	// 회원가입 
	public abstract int insert(MemberVO vo);
	
	
	// 로그인 
	public abstract MemberVO select(String id, String pw);
	
	
	// 비밀번호 찾기 변경 
	public abstract int update(String id, String phone, String pw);
	
	
	

} // END -------------------------------------
