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
	private String[] colNames = {"�ܾ�", "�Է��� ����", "->", "����", "����"}; // ���̺� ����� �� �̸���
	private Object[] records = new Object[colNames.length]; // ���̺� �����͸� ������ �迭 ��ü
	private DefaultTableModel tableModel; // ���̺� ���¸� ���� �� ����

	
	public TestDialog() {
		
		dao = WordDAOImple.getInstance();
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("���� Ȯ��");
		contentPanel.add(lblNewLabel);
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(200, 200, 254, 312);
		getContentPane().add(scrollPane_2);
		
		// ���̺� �⺻���� �ʱ�ȭ
		tableModel = new DefaultTableModel(colNames, 0); // �� �̸��� �� ���� ����
		table = new JTable(tableModel); // ���̺� ���� ���̺� ����
		table.setFont(new Font("����", Font.PLAIN, 15));
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
