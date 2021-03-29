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
	private String[] colNames = { "��ȣ", "�ܾ�", "�� " }; // ���̺� ����� �� �̸���
	private Object[] records = new Object[colNames.length]; // ���̺� �����͸� ������ �迭 ��ü 
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
		table = new JTable(tableF); // ���̺� ���� ���̺� ����
		table.setFont(new Font("����", Font.PLAIN, 15));
		scrollPaneF.setViewportView(table);
		
		lbl1 = new JLabel("�ܾ� List");
		lbl1.setBounds(23, 10, 106, 23);
		getContentPane().add(lbl1);
		
		lbl2 = new JLabel("---------- �ܾ� �߰� ----------");
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
		
		JButton btnNewButton = new JButton("�߰�");
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
	    	tableF.setRowCount(0); // ���̺� ������ �ʱ�ȭ
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
	    		JOptionPane.showMessageDialog(null, "������ �ܾ�� ���� �Է��ϼ���.");
	    		return; // �Լ� ����
	    	}
	    	
	    	WordVO vo = new WordVO(0, word, mean);
	    	
	    	int result= dao.insert(vo);
	    	if (result == 1) { 
	    		clearTextFields();
	    		    JOptionPane.showMessageDialog(null, "�ܾ� �߰� �Ϸ�");
	    		} else { 
	    			JOptionPane.showMessageDialog(null, "�ܾ� �߰� ����");
	    		}
	    	
	    } // end insertWord()
	    
	    
	    // �ؽ�Ʈ �ʵ� �ʱ�ȭ �Լ�
	    private void clearTextFields() {
	    	textWord.setText("");
	    	textMean.setText("");
	    }

}
