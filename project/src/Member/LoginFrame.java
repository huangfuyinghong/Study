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
		textId.setText("���̵�");
		textId.setBounds(65, 73, 258, 39);
		getContentPane().add(textId);
		textId.setColumns(10);

		textPw = new JTextField();
		textPw = new JPasswordField();
		textPw.setText("��й�ȣ");
		textPw.setColumns(10);
		textPw.setBounds(65, 148, 258, 39);
		getContentPane().add(textPw);

		JButton btnLogin = new JButton("�α���");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchMember();
			}
		});
		btnLogin.setBounds(122, 244, 154, 37);
		getContentPane().add(btnLogin);
		
		JButton btnJoin = new JButton("ȸ������");
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ ȣ��
				JoinFrame joinFrame = new JoinFrame();
				joinFrame.setVisible(true);
			}
		});
		btnJoin.setBounds(28, 321, 145, 32);
		getContentPane().add(btnJoin);

		JButton btnChPw = new JButton("��й�ȣ ã��/����");
		btnChPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ ȣ��
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
			JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ �ٽ� Ȯ�� ��Ź�帳�ϴ�.");
		}

	} // end searchMember()
		

}  // end  --------------------------------------------------
