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
		
		JButton btnStudy = new JButton("단어 공부");
        btnStudy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 호출
				File1FrameS file1FrameS  = new File1FrameS();
				file1FrameS.setVisible(true);
				
			}
				
		});
		btnStudy.setBounds(91, 111, 213, 44);
		getContentPane().add(btnStudy);
		
		JButton btnTest = new JButton("단어 테스트");
		btnTest.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 호출
				TestFrameS testFrameS = new TestFrameS();
				testFrameS.setVisible(true);
				dispose();
				
			}
		});
		btnTest.setBounds(91, 211, 213, 44);
		getContentPane().add(btnTest);
		
		JButton btnGame = new JButton("게임");
		btnGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "파일 중비중 ...");
			}
		}); 
		btnGame.setBounds(91, 309, 213, 44);
		getContentPane().add(btnGame);
		
		JLabel lblWelcome = new JLabel("환영합니다.");
		lblWelcome.setBounds(52, 22, 86, 15);
		getContentPane().add(lblWelcome);
		
		JButton btnLogout = new JButton("로그아웃");
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
