package Member;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MemberMain {

	private static MemberDAO dao;
	private JFrame frame;

	
	
	public static void main(String[] args) {
		dao = MemberDAOImple.getInstance();   // ��Ŭ�� ��ü�� �ҷ����� 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMain window = new MemberMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MemberMain() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("���� Study");
		frame.setBounds(100, 100, 315, 364);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_EngStudy = new JLabel("���� Study");
		lbl_EngStudy.setFont(new Font("����", Font.PLAIN, 40));
		lbl_EngStudy.setBounds(50, 80, 199, 50);
		frame.getContentPane().add(lbl_EngStudy);
		
		JButton btn_Start = new JButton("START");
        btn_Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				// ������ ȣ��
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				
			}
				
		});
		btn_Start.setFont(new Font("����", Font.PLAIN, 24));
		btn_Start.setBounds(66, 204, 159, 43);
		frame.getContentPane().add(btn_Start);

     }
	
} // end ------------------------------------
