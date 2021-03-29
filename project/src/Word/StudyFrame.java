package Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Member.MemberDAO;

public class StudyFrame extends JFrame {
	
	
	private static WordDAO dao;
	
	
	public StudyFrame() {
		initialize();
	}
	
	
public void initialize() {
	
	dao = WordDAOImple.getInstance();
		
		setTitle("Sudy");
		setBounds(100, 100, 404, 464);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnStudy = new JButton("�ܾ� ����");
        btnStudy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ ȣ��
				File1FrameS file1FrameS  = new File1FrameS();
				file1FrameS.setVisible(true);
				
			}
				
		});
		btnStudy.setBounds(91, 111, 213, 44);
		getContentPane().add(btnStudy);
		
		JButton btnTest = new JButton("�ܾ� �׽�Ʈ");
		btnTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ ȣ��
				TestFrameS testFrameS = new TestFrameS();
				testFrameS.setVisible(true);
				dispose();
				
			}
		});
		btnTest.setBounds(91, 211, 213, 44);
		getContentPane().add(btnTest);
		
		JButton btnGame = new JButton("����");
		btnGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "���� �ߺ��� ...");
			}
		}); 
		btnGame.setBounds(91, 309, 213, 44);
		getContentPane().add(btnGame);
		
		JLabel lblWelcome = new JLabel("ȯ���մϴ�.");
		lblWelcome.setBounds(52, 22, 86, 15);
		getContentPane().add(lblWelcome);
		
		JButton btnLogout = new JButton("�α׾ƿ�");
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnLogout.setBounds(250, 18, 97, 23);
		getContentPane().add(btnLogout);
	}
	
	
	
	

}  // end  -------------------------------------------
