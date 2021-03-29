package Word;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class TestFrame extends JFrame {
	
	private static WordDAO dao;

	private JFrame TestFrame;
    int count = 100; 
    private JProgressBar progressBar;
	private TestDialog TestDialog;
	private Timer timer;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
	private JTextField textField_1, textField_2, textField_3, textField_4, textField_5;

	
	public TestFrame() {
		initialize();
	}


	private void initialize() {
		
		dao = WordDAOImple.getInstance();
		
		setBounds(100, 100, 436, 374);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(12, 10, 379, 20);
		progressBar.setValue(count);
		getContentPane().add(progressBar);
		
		JButton btnNewButton = new JButton("답변 완료");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.cancel();
				dispose();
				// 다이아  호출
				TestDialog testDialog = new TestDialog();
				testDialog.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(146, 282, 97, 23);
		getContentPane().add(btnNewButton);
		
		lbl1 = new JLabel("New label");
		lbl1.setBounds(43, 69, 117, 20);
		getContentPane().add(lbl1);
		
		lbl2 = new JLabel("New label");
		lbl2.setBounds(43, 102, 117, 20);
		getContentPane().add(lbl2);
		
		lbl3 = new JLabel("New label");
		lbl3.setBounds(43, 141, 117, 20);
		getContentPane().add(lbl3);
		
		lbl4 = new JLabel("New label");
		lbl4.setBounds(43, 176, 117, 20);
		getContentPane().add(lbl4);
		
		lbl5 = new JLabel("New label");
		lbl5.setBounds(43, 214, 117, 20);
		getContentPane().add(lbl5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 59, 188, 28);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(172, 94, 188, 28);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(172, 133, 188, 28);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(172, 168, 188, 28);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(172, 206, 188, 28);
		getContentPane().add(textField_5);
		
		TestDialog = new TestDialog();
		TestDialog.setVisible(false);
		
	}
	
	void startTimer() {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (count > 0) {
					count--;
					progressBar.setValue(count);	
					
				} 
				else {
					TestDialog.setVisible(true);
					timer.cancel();
					dispose();
				    

				}
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 1, 30);
		
	}
	
	

}
