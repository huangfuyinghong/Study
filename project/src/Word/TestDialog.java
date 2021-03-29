package Word;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TestDialog extends JDialog {
	
	private static WordDAO dao;
	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private String[] colNames = {"단어", "입력한 내용", "->", "정답", "점수"}; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체
	private DefaultTableModel tableModel; // 테이블 형태를 만들 모델 변수

	
	public TestDialog() {
		
		dao = WordDAOImple.getInstance();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("정답 확인");
		contentPanel.add(lblNewLabel);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(200, 200, 254, 312);
		getContentPane().add(scrollPane_2);
		
		// 테이블 기본형태 초기화
		tableModel = new DefaultTableModel(colNames, 0); // 모델 이름과 행 개수 설정
		table = new JTable(tableModel); // 테이블 모델을 테이블에 적용
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPane_2.setViewportView(table);
		
		
		
		

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudyFrame studyFrame = new StudyFrame();
				studyFrame.setVisible(true);
			}
		}); 
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				StudyFrame studyFrame = new StudyFrame();
				studyFrame.setVisible(true);
			}
		}); 
		buttonPane.add(cancelButton);

	}


}
