package Member;

public interface MemberDAO {
	
	// ȸ������ 
	public abstract int insert(MemberVO vo);
	
	
	// �α��� 
	public abstract MemberVO select(String id, String pw);
	
	
	// ��й�ȣ ã�� ���� 
	public abstract int update(String id, String phone, String pw);
	
	
	

} // END -------------------------------------
