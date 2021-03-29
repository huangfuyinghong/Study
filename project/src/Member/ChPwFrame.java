package Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ChPwFrame extends JFrame {
	
	private static MemberDAO dao;
	private JTextField textId, textPhone, textPw;
	
	public ChPwFrame() {
		initialize();
	}
	
	
	public void initialize() {
		dao = MemberDAOImple.getInstance();
	
		setTitle("비밀번호 찾기/변경");
		setBounds(100, 100, 435, 332);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("아이디 입력");
		lblId.setBounds(68, 39, 95, 30);
		getContentPane().add(lblId);
		
		JLabel lblphone = new JLabel("휴대번호 입력");
		lblphone.setBounds(68, 94, 95, 30);
		getContentPane().add(lblphone);
		
		textId = new JTextField();
		textId.setBounds(164, 38, 185, 33);
		getContentPane().add(textId);
		textId.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(164, 93, 185, 33);
		getContentPane().add(textPhone);
		
		JLabel lblChPw = new JLabel("변경할 비밀번호 입력");
		lblChPw.setBounds(25, 157, 126, 30);
		getContentPane().add(lblChPw);
		
		textPw = new JTextField();
		textPw.setColumns(10);
		textPw.setBounds(164, 154, 185, 33);
		getContentPane().add(textPw);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chPwMember();
			}
		}); 
		btnOk.setBounds(110, 217, 158, 34);
		getContentPane().add(btnOk);
		
	} // end initialize()
	
	
	
	protected void chPwMember() { 
		
		String id = textId.getText();
		String phone = textPhone.getText();
		String pw = textPw.getText();
		
		if(id.equals("") || phone.equals("") || pw.equals("")) { 
			JOptionPane.showMessageDialog(null, "빈칸에 정보를 입력하세요.");
			return; // 함수 종료
		}
		
	
			int index = Integer.parseInt(textId.getText());
				int result = dao.update(id, phone, pw);
				if(result == 1) { 
					JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
					dispose();
				} else { 
					JOptionPane.showMessageDialog(null, "기존에 사용하신 아이디와 휴대전화 번호 다시 확인 부탁드립니다.");
			}
		
	}


} // end  ---------------------------------------------------
