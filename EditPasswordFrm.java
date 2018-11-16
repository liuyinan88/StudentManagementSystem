package com.lyn.view;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.lyn.dao.AdminDao;
import com.lyn.dao.StudentDao;
import com.lyn.dao.TeacherDao;
import com.lyn.model.Admin;
import com.lyn.model.Student;
import com.lyn.model.Teacher;
import com.lyn.util.StringUtil;


public class EditPasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField passWordTextField;
	private JTextField newPassWordTextField;
	private JTextField confirmPasswordTextField;
	private JLabel currentUserLabel ;
	private JLabel TitleLabel;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPasswordFrm frame = new EditPasswordFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public EditPasswordFrm() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 405);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setClosable(true);//可关闭
		setIconifiable(true);//可隐藏放大缩小
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801:");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/password.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		passWordTextField = new JTextField();
		passWordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801:");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		newPassWordTextField = new JTextField();
		newPassWordTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		lblNewLabel.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		lblNewLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		
		TitleLabel = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		TitleLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 28));
		
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//确认修改
				submitEdit(e);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//重置
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u7528\u6237:");
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		currentUserLabel = new JLabel("");
		//currentUserLabel.setEnabled(false);
		currentUserLabel.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(TitleLabel)
					.addContainerGap(616, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(193)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label_1)
						.addComponent(label)
						.addComponent(label_3))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(passWordTextField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(confirmPasswordTextField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
						.addComponent(newPassWordTextField, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
					.addGap(156))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(242)
					.addComponent(submitButton)
					.addGap(111)
					.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(TitleLabel)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passWordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPassWordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		if("管理员".equals(MainFrm.userType.getName())){
			Admin admin =(Admin) MainFrm.userObject;
			currentUserLabel.setText("[管理员]"+admin.getName());
		}else if("学生".equals(MainFrm.userType.getName())){
			Student student =(Student) MainFrm.userObject;
			currentUserLabel.setText(student.getName()+"[同学]");
		}else if("教师".equals(MainFrm.userType.getName())){
			Teacher teacher=(Teacher)MainFrm.userObject;
			currentUserLabel.setText("[教师]"+teacher.getName());
		}
	}

	protected void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		//【确认修改】子功能的实现！！！
		String oldPassword=passWordTextField.getText().toString();
		String newPassword=newPassWordTextField.getText().toString();
		String confirmPassword=confirmPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if(StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if(StringUtil.isEmpty(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "请确认密码！");
			return;
		}
		if(!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		if("管理员".equals(MainFrm.userType.getName())) {
			AdminDao adminDao=new AdminDao();
			Admin adminTmp=new Admin();
			Admin admin =(Admin)MainFrm.userObject;
			//adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		if("学生".equals(MainFrm.userType.getName())) {
			StudentDao studentDao =new StudentDao();
			Student  studentTmp=new Student();
			Student student =(Student)MainFrm.userObject;
			studentTmp.setName(student.getName());
			studentTmp.setPassword(oldPassword);
			studentTmp.setId(student.getId());
			JOptionPane.showMessageDialog(this, studentDao.editPassword(studentTmp, newPassword));
			studentDao.closeDao();
			return;
		}
		if("教师".equals(MainFrm.userType.getName())) {
			TeacherDao teacherDao =new TeacherDao();
			Teacher  teacherTmp=new Teacher();
			Teacher teacher =(Teacher)MainFrm.userObject;
			teacherTmp.setName(teacher.getName());
			teacherTmp.setPassword(oldPassword);
			teacherTmp.setId(teacher.getId());
			JOptionPane.showMessageDialog(this, teacherDao.editPassword(teacherTmp, newPassword));
			teacherDao.closeDao();
			return;
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【重置】子功能的实现！！！
		passWordTextField.setText("");
		newPassWordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
