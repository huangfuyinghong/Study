package Word;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class File1FrameA extends JFrame {
	
	private static WordDAO dao;
	
	private JTable table;
	private String[] colNames = { "번호", "단어", "뜻 " }; // 테이블 헤더에 들어갈 이름들
	private Object[] records = new Object[colNames.length]; // 테이블 데이터를 저장할 배열 객체 
	private DefaultTableModel tableF;
	
	private JLabel lbl1, lbl2;
	private JTextField textWord, textMean;
	
	public File1FrameA() { 
		initialize();
	}

	private void initialize() {
		
		dao = WordDAOImple.getInstance();
		
		setBounds(100, 100, 450, 519);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JScrollPane scrollPaneF = new JScrollPane();
		scrollPaneF.setBounds(53, 40, 329, 317);
		getContentPane().add(scrollPaneF);
		
		tableF = new DefaultTableModel(colNames, 0);
		table = new JTable(tableF); // 테이블 모델을 테이블에 적용
		table.setFont(new Font("굴림", Font.PLAIN, 15));
		scrollPaneF.setViewportView(table);
		
		lbl1 = new JLabel("단어 List");
		lbl1.setBounds(23, 10, 106, 23);
		getContentPane().add(lbl1);
		
		lbl2 = new JLabel("---------- 단어 추가 ----------");
		lbl2.setBounds(122, 375, 185, 15);
		getContentPane().add(lbl2);
		
		textWord = new JTextField();
		textWord.setBounds(36, 414, 116, 21);
		getContentPane().add(textWord);
		textWord.setColumns(10);
		
		textMean = new JTextField();
		textMean.setColumns(10);
		textMean.setBounds(178, 414, 116, 21);
		getContentPane().add(textMean);
		
		JButton btnNewButton = new JButton("추가");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			insertWord();
			selectWord();

			}
		}); 
		btnNewButton.setBounds(328, 413, 78, 23);
		getContentPane().add(btnNewButton);
	}
	
	
	
	
	  public void selectWord() { 
	    	tableF.setRowCount(0); // 테이블 데이터 초기화
	    	ArrayList<WordVO> list = dao.select();
	    	int size = list.size();
	    	for (int i = 0; i < size; i++) {
	    		records[0] = list.get(i).getNo();
	    		records[1] = list.get(i).getWord();
	    		records[2] = list.get(i).getMean();
	    		tableF.addRow(records);
	    	}
	    	
	    }  // end selectAllWord() 
	  
	    public void insertWord() { 
	    	
	    	
	    	String word = textWord.getText();
	    	String mean = textWord.getText();
	    	
	    	
	    	if(word.equals("") || mean.equals("")) { 
	    		JOptionPane.showMessageDialog(null, "저장할 단어와 뜻을 입력하세요.");
	    		return; // 함수 종료
	    	}
	    	
	    	WordVO vo = new WordVO(0, word, mean);
	    	
	    	int result= dao.insert(vo);
	    	if (result == 1) { 
	    		clearTextFields();
	    		    JOptionPane.showMessageDialog(null, "단어 추가 완료");
	    		} else { 
	    			JOptionPane.showMessageDialog(null, "단어 추가 실패");
	    		}
	    	
	    } // end insertWord()
	    
	    
	    // 텍스트 필드 초기화 함수
	    private void clearTextFields() {
	    	textWord.setText("");
	    	textMean.setText("");
	    }

}
