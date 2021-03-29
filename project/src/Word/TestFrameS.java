package Word;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestFrameS extends JFrame {
	
	private static WordDAO dao;

	private JFrame TestFrameS;

	
	public TestFrameS() {
		initialize();
	}


	private void initialize() {
		
		dao = WordDAOImple.getInstance();
		
		setBounds(100, 100, 450, 273);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnTestStart = new JButton("Test Start");
		btnTestStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 프레임 호출
				TestFrame testFrame = new TestFrame();
				testFrame.setVisible(true);
				(testFrame).startTimer();
				dispose();
			}
		});
		btnTestStart.setBounds(106, 140, 222, 48);
		getContentPane().add(btnTestStart);
		
		JLabel lblTextExplain = new JLabel("<html> = >> Test Explain : 영어 단어를 보고 뜻을 빈칸에 입력하세요. <br> 문제는 총 5개이고 TEST 시간은 100초 입니다.<br></html>");
		lblTextExplain.setBounds(41, 29, 359, 97);
		getContentPane().add(lblTextExplain);
	}
	
	
	
	
	
	
	
	

}
