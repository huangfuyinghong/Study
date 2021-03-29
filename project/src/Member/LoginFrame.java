package Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Word.StudyFrame;

public class LoginFrame extends JFrame {
	
	private static MemberDAO dao;
	private JTextField textId, textPw;
	
	
	public LoginFrame() {
		initialize();
	}
	
	
	public void initialize() {
		
		dao = MemberDAOImple.getInstance();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 420);
		getContentPane().setLayout(null);

		textId = new JTextField();
		textId.setText("아이디");
		textId.setBounds(65, 73, 258, 39);
		getContentPane().add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw = new JPasswordField();
		textPw.setText("비밀번호");
		textPw.setColumns(10);
		textPw.setBounds(65, 148, 258, 39);
		getContentPane().add(textPw);

		JButton btnLogin = new JButton("로그인");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchMember();
			}
		});
		btnLogin.setBounds(122, 244, 154, 37);
		getContentPane().add(btnLogin);
		
		JButton btnJoin = new JButton("회원가입");
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 호출
				JoinFrame joinFrame = new JoinFrame();
				joinFrame.setVisible(true);
			}
		});
		btnJoin.setBounds(28, 321, 145, 32);
		getContentPane().add(btnJoin);

		JButton btnChPw = new JButton("비밀번호 찾기/변경");
		btnChPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 호출
				ChPwFrame chpwFrame = new ChPwFrame();
				chpwFrame.setVisible(true);
			}
		});
		btnChPw.setBounds(185, 321, 181, 32);
		getContentPane().add(btnChPw);

	} // end initialize()
	
	
	public void searchMember() {

		String id = textId.getText();
		String pw = textPw.getText();

		MemberVO vo = dao.select(id, pw);
		System.out.println(vo);
		if(vo != null) { 
			dispose();
			StudyFrame studyFrame = new StudyFrame();
			studyFrame.setVisible(true);
		} else { 
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호 다시 확인 부탁드립니다.");
		}

	} // end searchMember()
		

}  // end  --------------------------------------------------
