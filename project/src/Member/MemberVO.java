package Member;

//������ Ŭ����(�г���, ���̵�(pk), ��й�ȣ, ��й�ȣ Ȯ��,  �̸���, �޴���ȭ ��ȣ(pk))
public class MemberVO {
	
	// ��� ����(�ʵ�, ������Ƽ) 
		private int cid;
		private String nick;
		private String id;
		private String pw;
		private String email;
		private String phone; 
		
		// �⺻ ������ 
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

		// getter/ setter �޼ҵ� 
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
			String str = "��ȣ : " + nick + "\n"
					+ "���̵� : " + id + "\n"
					+ "��й�ȣ : " + pw + "\n"
					+ "�̸��� : " + email + "\n"
					+ "�޴���ȭ ��ȣ" + phone + "\n\n";
			return str;
		}
	
} // END ---------------------------------
