package Member;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JoinFrame extends JFrame {
	
	
	private static MemberDAO dao;
	private JTextField textNick, textId, textPw, textEmail, textPhone;
	
	
	public JoinFrame() {
		initialize();
	}
	
	public void initialize() {
		dao = MemberDAOImple.getInstance();
		
		setBounds(100, 100, 450, 453);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNick = new JLabel("닉네임");
		lblNick.setBounds(50, 51, 67, 25);
		getContentPane().add(lblNick);
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(50, 94, 67, 25);
		getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("비밀번호");
		lblPw.setBounds(50, 142, 67, 25);
		getContentPane().add(lblPw);
		
		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(50, 193, 67, 25);
		getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("휴대전화 번호");
		lblPhone.setBounds(50, 242, 85, 25);
		getContentPane().add(lblPhone);
		
		Font txtFont = new Font("굴림", Font.PLAIN, 15);
		
		textNick = new JTextField();
		textNick.setFont(txtFont);
		textNick.setBounds(153, 49, 189, 30);
		getContentPane().add(textNick);
		textNick.setColumns(10);
		
		textId = new JTextField();
		textId.setFont(txtFont);
		textId.setColumns(10);
		textId.setBounds(153, 92, 189, 30);
		getContentPane().add(textId);
		
		textPw = new JTextField();
		textPw.setFont(txtFont);
		textPw.setColumns(10);
		textPw.setBounds(153, 140, 189, 30);
		getContentPane().add(textPw);
		
		textEmail = new JTextField();
		textEmail.setFont(txtFont);
		textEmail.setColumns(10);
		textEmail.setBounds(153, 188, 189, 30);
		getContentPane().add(textEmail);
		
		textPhone = new JTextField();
		textPhone.setFont(txtFont);
		textPhone.setColumns(10);
		textPhone.setBounds(153, 237, 189, 30);
		getContentPane().add(textPhone);
		
		JCheckBox chckbxTerms = new JCheckBox("이용약관 동의");
		chckbxTerms.setBounds(155, 298, 115, 23);
		getContentPane().add(chckbxTerms);
		
		JButton btnCancle = new JButton("취소");
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		}); 
		btnCancle.setBounds(50, 355, 130, 30);
		getContentPane().add(btnCancle);
		
		JButton btnOk = new JButton("확인");
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertMember();
				
			}
		}); 
		btnOk.setBounds(247, 355, 130, 30);
		getContentPane().add(btnOk);
	}

	protected void insertMember() {
		// TODO Auto-generated method stub
		String nick = textNick.getText();
		String id = textId.getText();
		String pw = textPw.getText();
		String email = textEmail.getText();
		String phone = textPhone.getText();
		
		if(nick.equals("") || id.equals("") || pw.equals("") || email.equals("") || phone.equals("")) {  // 이름, 연락처, 이메일 중에 하나라도 입력되지 않으면
			JOptionPane.showMessageDialog(null, "저장할 연락처 정보를 입력하세요.");
			return; // 함수 종료 
	}
		
		// Member 인스턴스 생성  
		MemberVO vo = new MemberVO(0, nick, id, pw, email, phone);
		
		
		int result = dao.insert(vo);
		if (result == 1) { 
			clearTextFields();
			JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
			
		} else { 
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
		}
		
  } // end insertMember () 

	private void clearTextFields() {
		// TODO Auto-generated method stub
		textNick.setText("");
		textId.setText("");
		textPw.setText("");
		textEmail.setText("");
		textPhone.setText("");
	}

} // end ------------------------------------
