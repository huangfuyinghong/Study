package Member;

//데이터 클래스(닉네임, 아이디(pk), 비밀번호, 비밀번호 확인,  이메일, 휴대전화 번호(pk))
public class MemberVO {
	
	// 멤버 변수(필드, 프로퍼티) 
		private int cid;
		private String nick;
		private String id;
		private String pw;
		private String email;
		private String phone; 
		
		// 기본 생성자 
		public MemberVO() {}
		

		public MemberVO(String id, String pw) { 
			this.id = id;
			this.pw = pw;
		}
		
		public MemberVO(int cid, String nick, String id, String pw, String email, String phone) {
			this.cid = cid;
			this.nick = nick;
			this.id = id;
			this.pw = pw;
			this.email = email;
			this.phone = phone;
		}

		// getter/ setter 메소드 
		public int getCid() { 
			return cid;
		}
		
		public void setCid(int cid) { 
			this.cid = cid;
		}
		
		public String getNick() {
			return nick;
		}

		public void setNick(String nick) {
			this.nick = nick;
		} 

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPw() {
			return pw;
		}

		public void setPw(String pw) {
			this.pw = pw;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		} 
		
		@Override
		public String toString() { 
			String str = "번호 : " + nick + "\n"
					+ "아이디 : " + id + "\n"
					+ "비밀번호 : " + pw + "\n"
					+ "이메일 : " + email + "\n"
					+ "휴대전화 번호" + phone + "\n\n";
			return str;
		}
	
} // END ---------------------------------
