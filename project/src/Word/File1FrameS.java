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
		
		Font font = new Font("굴림", Font.BOLD, 48);
		JLabel lblOutWord = new JLabel("영어 단어 출력");
		lblOutWord.setFont(font);
		lblOutWord.setBounds(48, 48, 322, 108);
		lblOutWord.setText("apple");
		getContentPane().add(lblOutWord);
		
		JLabel lblOutMean = new JLabel(" 뜻 ");
		lblOutMean. setFont(font);
		lblOutMean.setBounds(48, 221, 322, 108);
		lblOutMean.setText("사과");
		getContentPane().add(lblOutMean);
		
		JButton btnBefore = new JButton("이전");
//		btnBefore.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (index > 0) { // 현재 인덱스가 0보다 크면
//					index--; // 인덱스를 감소
//				} else { // 현재 인덱스가 0이 되면
//					index = size - 1; // 배열의 가장 큰 인덱스 번호로 변경
//				}
//				System.out.println(index);
//				lblOutput.setText(STRINGS[index]);
//			}
//		});
		btnBefore.setBounds(48, 396, 97, 48);
		getContentPane().add(btnBefore);
		
		JButton btnAfter = new JButton("다음");
//		btnAfter.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (index < STRINGS.length - 1) { // 마지막 인덱스보다 작은 경우
//					index++; // 인덱스를 증가
//				} else { // 현재 인덱스가 문자열의 길이 - 1이 되는 경우
//					index = 0; // 인덱스를 0으로 초기화
//				}
//				System.out.println(index);
//				lblOutput.setText(STRINGS[index]);
//			}
//		});
		
		btnAfter.setBounds(273, 396, 97, 44);
		getContentPane().add(btnAfter);
		
		JButton btnNewButton = new JButton("전체 단어 List");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임 호출
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
