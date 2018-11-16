package com.lyn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.print.attribute.standard.RequestingUserName;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.lyn.dao.ClassDao;
import com.lyn.dao.StudentDao;
import com.lyn.model.Admin;
import com.lyn.model.Student;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JPasswordField;

import com.lyn.model.StudentClass;
import com.lyn.model.UserType;
import com.lyn.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageStudentFrm extends JInternalFrame {
	private JTextField searchStudentNameTextField;
	private JTable studentListTable;
	private JTextField editStudenNameTextField;
	private JPasswordField editStudentPasswordPasswordField;
	private JComboBox editStudentClassComboBox;
	private JComboBox searchStudentComboBox;
	private List<StudentClass> studentClassList;
	private ButtonGroup editSexButtonGroup;
	private JRadioButton editStudentSexManRadioButton;
	private JRadioButton editStudentSexFemalRadioButton;
	private JRadioButton editStudentSexUnknownRadioButton;
	private JButton deleteStudentButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentFrm frame = new ManageStudentFrm();
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
	public ManageStudentFrm() {
		setClosable(true);
		setIconifiable(true);//可隐藏放大缩小
		getContentPane().setBackground(new Color(153, 204, 204));
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 900, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		searchStudentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		searchStudentComboBox = new JComboBox();
		searchStudentComboBox.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//查询按钮
				searchStudent(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editStudenNameTextField = new JTextField();
		editStudenNameTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		editStudenNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_3.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editStudentClassComboBox = new JComboBox();
		editStudentClassComboBox.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_4.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u6027\u522B.png")));
		label_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editSexButtonGroup=new ButtonGroup();
		editStudentSexManRadioButton = new JRadioButton("\u7537");
		editStudentSexManRadioButton.setSelected(true);
		editStudentSexManRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editStudentSexFemalRadioButton = new JRadioButton("\u5973");
		editStudentSexFemalRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editStudentSexUnknownRadioButton = new JRadioButton("\u4FDD\u5BC6");
		editStudentSexUnknownRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		//radioButton三选一实现
		editSexButtonGroup.add(editStudentSexManRadioButton);
		editSexButtonGroup.add(editStudentSexFemalRadioButton);
		editSexButtonGroup.add(editStudentSexUnknownRadioButton);
		
		JLabel label_5 = new JLabel("\u767B\u5165\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//确认修改按钮
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		deleteStudentButton = new JButton("\u5220\u9664\u5B66\u751F");
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//删除按钮
				deleteStudent(ae);
			}
		});
		deleteStudentButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteStudentButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editStudentPasswordPasswordField = new JPasswordField();
		editStudentPasswordPasswordField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(119)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editStudentClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editStudenNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_4)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(editStudentSexManRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editStudentSexFemalRadioButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editStudentSexUnknownRadioButton))
						.addComponent(editStudentPasswordPasswordField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(deleteStudentButton)
						.addComponent(submitEditButton))
					.addContainerGap(44, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 748, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editStudenNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(editStudentSexManRadioButton)
						.addComponent(editStudentSexFemalRadioButton)
						.addComponent(editStudentSexUnknownRadioButton)
						.addComponent(submitEditButton))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(editStudentClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(deleteStudentButton)
						.addComponent(editStudentPasswordPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48))
		);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//ListTabel
				selectedTableRow(arg0);
			}
			
		});
		studentListTable.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5C5E\u73ED\u7EA7", "\u5B66\u751F\u6027\u522B", "\u767B\u5165\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		setStudentClassInfo();
		setTable(new Student());
		setAuthority();
	}
	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【确认修改】功能实现
		int row = studentListTable.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的学生！");
			return;
		}
		String studentName=editStudenNameTextField.getText().toString();
		String studentPassword=editStudentPasswordPasswordField.getText().toString();
		if(StringUtil.isEmpty(studentName)) {
			JOptionPane.showMessageDialog(this, "请填写学生姓名!");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)) {
			JOptionPane.showMessageDialog(this, "请填写学生密码!");
			return;
		}
		Student student=new Student();
		student.setName(studentName);//设置学生姓名
		student.setPassword(studentPassword);//设置密码
		StudentClass sc=(StudentClass)editStudentClassComboBox.getSelectedItem();
		student.setClassId(sc.getId());//设置学生班级ID
		student.setId(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()));//设置学生ID
		if(editStudentSexManRadioButton.isSelected())student.setSex(editStudentSexManRadioButton.getText().toString());
		if(editStudentSexFemalRadioButton.isSelected())student.setSex(editStudentSexFemalRadioButton.getText().toString());
		if(editStudentSexUnknownRadioButton.isSelected())student.setSex(editStudentSexUnknownRadioButton.getText().toString());
		StudentDao studentDao=new StudentDao();
		if(studentDao.update(student)) {
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else {
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
	}

	protected void deleteStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【删除】按钮功能实现
		int row = studentListTable.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的学生！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确认删除？")!=JOptionPane.OK_OPTION) {
			return;
		}
		StudentDao studentDao=new StudentDao();
		if(studentDao.delete(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()))) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		//点击显示班级信息等-函数
		DefaultTableModel dft=(DefaultTableModel) studentListTable.getModel();
		editStudenNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 1).toString());  
		editStudentPasswordPasswordField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 4).toString());	
		String className=dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<editStudentClassComboBox.getItemCount();i++) {
			StudentClass sc =(StudentClass)editStudentClassComboBox.getItemAt(i);
			if(className.equals(sc.getName())){
				editStudentClassComboBox.setSelectedIndex(i);
			}
		}
		String sex=dft.getValueAt(studentListTable.getSelectedRow(), 3).toString();
		editSexButtonGroup.clearSelection();
		if(sex.equals(editStudentSexManRadioButton.getText()))editStudentSexManRadioButton.setSelected(true);
		if(sex.equals(editStudentSexFemalRadioButton.getText()))editStudentSexFemalRadioButton.setSelected(true);
		if(sex.equals(editStudentSexUnknownRadioButton.getText()))editStudentSexUnknownRadioButton.setSelected(true);
	}

	protected void searchStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【查询】按钮功能实现
		Student student=new Student();
		student.setName(searchStudentNameTextField.getText().toString());
		StudentClass sc=(StudentClass)searchStudentComboBox.getSelectedItem();
		student.setClassId(sc.getId());
		setTable(student);	
	}

	private void setTable(Student student){
		if("学生".equals(MainFrm.userType.getName())){
			Student s = (Student)MainFrm.userObject;
			student.setName(s.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		dft.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList(student);
		for (Student s : studentList) {
			Vector v = new Vector();
			v.add(s.getId());
			v.add(s.getName());
			v.add(getClassNameById(s.getClassId()));
			v.add(s.getSex());
			v.add(s.getPassword());
			dft.addRow(v);
		}
		studentDao.closeDao();
	}
	private void setStudentClassInfo() {
		ClassDao classDao=new ClassDao();
		studentClassList=classDao.getClassList(new StudentClass());
		for(StudentClass sc : studentClassList) {
			searchStudentComboBox.addItem(sc);
			editStudentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
	private String getClassNameById(int id) {
		for(StudentClass sc : studentClassList) {
			if(sc.getId()==id) return sc.getName();
		}
		return "";
	}
	private void setAuthority() {
		if("学生".equals(MainFrm.userType.getName())) {
			Student s=(Student)MainFrm.userObject;
			searchStudentNameTextField.setEnabled(false);
			searchStudentNameTextField.setText(s.getName());		
			for(int i=0;i<searchStudentComboBox.getItemCount();i++) {
				StudentClass sc=(StudentClass)searchStudentComboBox.getItemAt(i);
				if(sc.getId()==s.getClassId()) {
					searchStudentComboBox.setSelectedIndex(i);
				}
			}
			searchStudentComboBox.setEnabled(false);
			deleteStudentButton.setEnabled(false);
			for(int i=0;i<editStudentClassComboBox.getItemCount();i++) {
				StudentClass sc=(StudentClass)editStudentClassComboBox.getItemAt(i);
				if(sc.getId()==s.getClassId()) {
					editStudentClassComboBox.setSelectedIndex(i);
				}
				editStudentClassComboBox.setEnabled(false);
			}
		}
	}
}
