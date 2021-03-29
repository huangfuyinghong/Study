package Word;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class File1FrameS extends JFrame {
	
	private static WordDAO dao;
	
	private int index;
	
	
	public File1FrameS() { 
		initialize();
	}

	private void initialize() {
		
		dao = WordDAOImple.getInstance();
		
		setBounds(100, 100, 440, 519);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Font font = new Font("����", Font.BOLD, 48);
		JLabel lblOutWord = new JLabel("���� �ܾ� ���");
		lblOutWord.setFont(font);
		lblOutWord.setBounds(48, 48, 322, 108);
		lblOutWord.setText("apple");
		getContentPane().add(lblOutWord);
		
		JLabel lblOutMean = new JLabel(" �� ");
		lblOutMean. setFont(font);
		lblOutMean.setBounds(48, 221, 322, 108);
		lblOutMean.setText("���");
		getContentPane().add(lblOutMean);
		
		JButton btnBefore = new JButton("����");
//		btnBefore.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (index > 0) { // ���� �ε����� 0���� ũ��
//					index--; // �ε����� ����
//				} else { // ���� �ε����� 0�� �Ǹ�
//					index = size - 1; // �迭�� ���� ū �ε��� ��ȣ�� ����
//				}
//				System.out.println(index);
//				lblOutput.setText(STRINGS[index]);
//			}
//		});
		btnBefore.setBounds(48, 396, 97, 48);
		getContentPane().add(btnBefore);
		
		JButton btnAfter = new JButton("����");
//		btnAfter.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (index < STRINGS.length - 1) { // ������ �ε������� ���� ���
//					index++; // �ε����� ����
//				} else { // ���� �ε����� ���ڿ��� ���� - 1�� �Ǵ� ���
//					index = 0; // �ε����� 0���� �ʱ�ȭ
//				}
//				System.out.println(index);
//				lblOutput.setText(STRINGS[index]);
//			}
//		});
		
		btnAfter.setBounds(273, 396, 97, 44);
		getContentPane().add(btnAfter);
		
		JButton btnNewButton = new JButton("��ü �ܾ� List");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ ȣ��
				File1FrameA file1FrameA = new File1FrameA();
				file1FrameA.setVisible(true);
				file1FrameA.selectWord();
			}
		}); 
		btnNewButton.setBounds(273, 10, 132, 27);
		getContentPane().add(btnNewButton);
	}
	
//	public void studyWord() { 
//		int index = 0;
//		WordVO vo = dao.select(index);
//		lblOutWord.setText(vo.toString());
//		
//	}
//	
	

} // END  ---------------------------------------
