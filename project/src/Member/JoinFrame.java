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
		
		JLabel lblNick = new JLabel("�г���");
		lblNick.setBounds(50, 51, 67, 25);
		getContentPane().add(lblNick);
		
		JLabel lblId = new JLabel("���̵�");
		lblId.setBounds(50, 94, 67, 25);
		getContentPane().add(lblId);
		
		JLabel lblPw = new JLabel("��й�ȣ");
		lblPw.setBounds(50, 142, 67, 25);
		getContentPane().add(lblPw);
		
		JLabel lblEmail = new JLabel("�̸���");
		lblEmail.setBounds(50, 193, 67, 25);
		getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("�޴���ȭ ��ȣ");
		lblPhone.setBounds(50, 242, 85, 25);
		getContentPane().add(lblPhone);
		
		Font txtFont = new Font("����", Font.PLAIN, 15);
		
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
		
		JCheckBox chckbxTerms = new JCheckBox("�̿��� ����");
		chckbxTerms.setBounds(155, 298, 115, 23);
		getContentPane().add(chckbxTerms);
		
		JButton btnCancle = new JButton("���");
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		}); 
		btnCancle.setBounds(50, 355, 130, 30);
		getContentPane().add(btnCancle);
		
		JButton btnOk = new JButton("Ȯ��");
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
		
		if(nick.equals("") || id.equals("") || pw.equals("") || email.equals("") || phone.equals("")) {  // �̸�, ����ó, �̸��� �߿� �ϳ��� �Էµ��� ������
			JOptionPane.showMessageDialog(null, "������ ����ó ������ �Է��ϼ���.");
			return; // �Լ� ���� 
	}
		
		// Member �ν��Ͻ� ����  
		MemberVO vo = new MemberVO(0, nick, id, pw, email, phone);
		
		
		int result = dao.insert(vo);
		if (result == 1) { 
			clearTextFields();
			JOptionPane.showMessageDialog(null, "ȸ������ �Ǿ����ϴ�.");
			
		} else { 
			JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�.");
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
