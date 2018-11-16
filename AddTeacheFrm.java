package com.lyn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;import org.omg.CORBA.TRANSACTION_UNAVAILABLE;

import com.lyn.dao.TeacherDao;
import com.lyn.model.Teacher;
import com.lyn.util.StringUtil;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddTeacheFrm extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherAgeTextField;
	private JRadioButton teacherSexManRadioButton;
	private JRadioButton teacherSexFemalRadioButton;
	private JPasswordField teacherPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacheFrm frame = new AddTeacheFrm();
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
	public AddTeacheFrm() {
		setClosable(true);
		setIconifiable(true);
		
		getContentPane().setBackground(SystemColor.control);
		setTitle("\u6559\u5E08\u6DFB\u52A0");
		setBounds(100, 100, 750, 450);
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u8001\u5E08.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		teacherNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_1.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u6027\u522B.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		teacherSexManRadioButton = new JRadioButton("\u7537");
		teacherSexManRadioButton.setSelected(true);
		teacherSexManRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		teacherSexFemalRadioButton = new JRadioButton("\u5973");
		teacherSexFemalRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		//实现单选功能
		buttonGroup.add(teacherSexManRadioButton);
		buttonGroup.add(teacherSexFemalRadioButton);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u804C\u79F0\u8BC4\u5B9A.png")));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		teacherTitleTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label_2.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u5E74\u9F84.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		teacherAgeTextField = new JTextField();
		teacherAgeTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		teacherAgeTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//确认添加按钮
				addTeacherAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("\u91CD\u7F6E\u8868\u5355");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//重置表单按钮
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u6DFB\u52A0");
		label_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 28));
		
		JLabel label_4 = new JLabel("\u767B\u5165\u5BC6\u7801\uFF1A");
		label_4.setIcon(new ImageIcon(AddTeacheFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		teacherPasswordField = new JPasswordField();
		teacherPasswordField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(190)
					.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(86)
					.addComponent(resetButton)
					.addContainerGap(196, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_3)
					.addContainerGap(608, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teacherTitleTextField, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
							.addGap(228))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teacherSexManRadioButton)
							.addGap(53)
							.addComponent(teacherSexFemalRadioButton)
							.addGap(315))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
							.addGap(228))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherPasswordField, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherAgeTextField, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
							.addGap(228))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_3)
							.addGap(95))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(teacherSexManRadioButton)
								.addComponent(teacherSexFemalRadioButton))
							.addGap(7)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(teacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(teacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【重置表单】按钮功能实现
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherAgeTextField.setText("");
		teacherSexManRadioButton.setSelected(true);
		teacherPasswordField.setText("");
	}

	protected void addTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【确认修改】按钮功能实现
		String teacherName = teacherNameTextField.getText().toString();
		String teacherSex = teacherSexManRadioButton.isSelected() ? teacherSexManRadioButton.getText().toString() : teacherSexFemalRadioButton.getText().toString();
		String teacherTitle = teacherTitleTextField.getText().toString();
		String teacherPassword = teacherPasswordField.getText().toString();
		int teacherAge = 0;
		try {
			teacherAge = Integer.parseInt(teacherAgeTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)){
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(teacherAge == 0 || teacherAge < 0){
			JOptionPane.showMessageDialog(this, "教师年龄必须大于0！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.addTeacher(teacher)){
			JOptionPane.showMessageDialog(this, "教师添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "教师添加失败！");
		}
		resetValue(ae);
	}
	}

