package com.lyn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.lyn.dao.AdminDao;
import com.lyn.dao.ClassDao;
import com.lyn.model.StudentClass;
import com.lyn.util.StringUtil;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentClassFrm extends JInternalFrame {
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentClassFrm frame = new AddStudentClassFrm();
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
	public AddStudentClassFrm() {
		getContentPane().setBackground(SystemColor.control);
		
		setClosable(true);//可关闭
		setIconifiable(true);//可隐藏放大缩小
		
		JLabel label = new JLabel("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 28));
		label.setEnabled(true);
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0:");
		label_1.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\u4ECB\u7ECD:");
		label_2.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		 classInfoTextArea = new JTextArea();
		
		JButton submitButton = new JButton("\u63D0\u4EA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//提交功能
				submitClass(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//重置功能
				resetValue(e);
			}
		});
		resetButton.setIcon(new ImageIcon(AddStudentClassFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(191)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(classInfoTextArea, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(submitButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
									.addGap(96)
									.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addGap(223))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);
		setTitle("\u6DFB\u52A0\u73ED\u7EA7\u4FE1\u606F");
		setBounds(100, 100, 800, 400);

	}

	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【提交】功能实现
		String className =classNameTextField.getText().toString();
		String classInfo=classInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(className)) {
			JOptionPane.showMessageDialog(this, "班级名称不能为空！");
			return;
		}
		StudentClass scl =new StudentClass();
		scl.setName(className);
		scl.setInfo(classInfo);
		ClassDao classDao=new ClassDao();
		if(classDao.addClass(scl)) {
			JOptionPane.showMessageDialog(this, "班级添加成功！");
		}else {
			JOptionPane.showMessageDialog(this, "班级添加失败！");
		}
		classDao.closeDao();
		resetValue(ae);		
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		//【重置】功能实现
		classNameTextField.setText("");
		classInfoTextArea.setText("");
		
	}
}
