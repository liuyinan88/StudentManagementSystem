package com.lyn.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lyn.dao.ClassDao;
import com.lyn.dao.StudentDao;
import com.lyn.model.Student;
import com.lyn.model.StudentClass;
import com.lyn.util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;



public class AddStudentFrm extends JInternalFrame {
	private JTextField studentNameTextField;
	private JPasswordField studentPasswordField;
    private JRadioButton studentSexManRadioButton;
    private JRadioButton studentSexFemalRadioButton;
	private JRadioButton studentSexUnkonwRadioButton;
	private JComboBox studentClassComboBox;
	private ButtonGroup sexButtonGroup;

    
    
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrm frame = new AddStudentFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudentFrm() {
		setClosable(true);
		setIconifiable(true);//¿ÉÒþ²Ø·Å´óËõÐ¡
		
		setTitle("\u5B66\u751F\u6DFB\u52A0");
		setBounds(100, 100, 750, 450);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		studentNameTextField = new JTextField();
		studentNameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		studentNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		studentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_1.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		studentClassComboBox = new JComboBox();
		studentClassComboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		studentClassComboBox.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u767B\u5165\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		studentPasswordField = new JPasswordField();
		studentPasswordField.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/\u6027\u522B.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		studentSexManRadioButton = new JRadioButton("\u7537");
		studentSexManRadioButton.setSelected(true);
		studentSexManRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		studentSexFemalRadioButton = new JRadioButton("\u5973");
		studentSexFemalRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		studentSexUnkonwRadioButton = new JRadioButton("\u4FDD\u5BC6");
		studentSexUnkonwRadioButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(studentSexManRadioButton);
		sexButtonGroup.add(studentSexFemalRadioButton);
		sexButtonGroup.add(studentSexUnkonwRadioButton);

		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddStudentFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u6DFB\u52A0");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ Light", Font.PLAIN, 28));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(189)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentPasswordField))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(studentSexManRadioButton)
										.addGap(18)
										.addComponent(studentSexFemalRadioButton)
										.addGap(18)
										.addComponent(studentSexUnkonwRadioButton))))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(204)
								.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(82)
								.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_4)))
					.addContainerGap(185, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(studentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(studentPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(studentSexManRadioButton)
						.addComponent(studentSexFemalRadioButton)
						.addComponent(studentSexUnkonwRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		studentNameTextField.setText("");
		studentPasswordField.setText("");
		studentClassComboBox.setSelectedIndex(0);
		sexButtonGroup.clearSelection();
		studentSexManRadioButton.setSelected(true);

	}

	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String studentName = studentNameTextField.getText().toString();
		String studentPassword = studentPasswordField.getText().toString();
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ñ§ÉúÐÕÃû!");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´ÃÜÂë!");
			return;
		}
		StudentClass sc = (StudentClass)studentClassComboBox.getSelectedItem();
		String sex = studentSexManRadioButton.isSelected() ? studentSexManRadioButton.getText() : (studentSexFemalRadioButton.isSelected() ? studentSexFemalRadioButton.getText() : studentSexUnkonwRadioButton.getText());
		Student student = new Student();
		student.setName(studentName);
		student.setClassId(sc.getId());
		student.setPassword(studentPassword);
		student.setSex(sex);
		StudentDao studentDao = new StudentDao();
		if(studentDao.addStudent(student)){
			JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦!");
		}else{
			JOptionPane.showMessageDialog(this, "Ìí¼ÓÊ§°Ü!");
		}
		resetValue(ae);

	}
	private void setStudentClassInfo(){
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(new StudentClass());
		for (StudentClass sc : classList) {
			studentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}


}
