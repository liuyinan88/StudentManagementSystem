package com.lyn.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.lyn.dao.AdminDao;
import com.lyn.dao.StudentDao;
import com.lyn.dao.TeacherDao;
import com.lyn.model.Admin;
import com.lyn.model.Student;
import com.lyn.model.Teacher;
import com.lyn.model.UserType;
import com.lyn.util.StringUtil;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JComboBox  userTypeComboBox;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("\u767B\u5165\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 561);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel(" \u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u767B\u5165\u754C\u9762");
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u732A.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("\u7528  \u6237 \u540D");
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		userNameTextField = new JTextField();
		userNameTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6       \u7801");
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u7528\u6237\u7C7B\u578B");
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userType.png")));
		label_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u732A.png")));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));
		userTypeComboBox.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton loginButton = new JButton("\u767B\u5165");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u767B\u5F55.png")));
		loginButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u5F00\u53D1\u8005\uFF1A\u5218\u9038\u5357");
		lblNewLabel_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(207)
					.addComponent(label)
					.addGap(8)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(246)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(387)
					.addComponent(loginButton)
					.addGap(68)
					.addComponent(resetButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(835)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(246)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordTextField))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3)
							.addGap(9)
							.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(lblNewLabel))
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(label_3))
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addGap(41)
					.addComponent(lblNewLabel_1))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName=userNameTextField.getText().toString();
		String password=passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin=null;
		if("管理员".equals(selectedItem.getName())) {
			//系统管理员登入
			AdminDao adminDao=new AdminDao();
			Admin adminTmp=new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin=adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin==null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}//
			JOptionPane.showMessageDialog(this, "欢迎["+selectedItem.getName()+"]"+admin.getName()+"登入本系统！");
			this.dispose();//登入成功后隐藏登入界面
			new MainFrm(selectedItem, admin).setVisible(true);
			
		}else if("教师".equals(selectedItem.getName())){
			//教师登入
			Teacher teacher=null;
			TeacherDao teacherDao=new TeacherDao();
			Teacher teacherTmp=new Teacher();
			teacherTmp.setName(userName);
			teacherTmp.setPassword(password);
			teacher=teacherDao.login(teacherTmp);
			teacherDao.closeDao();
			if(teacher==null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}//
			JOptionPane.showMessageDialog(this, "欢迎["+selectedItem.getName()+"]"+teacher.getName()+"登入本系统！");
			this.dispose();//登入成功后隐藏登入界面
			new MainFrm(selectedItem, teacher).setVisible(true);
		}
		else {
			//学生登入
			Student student=null;
			StudentDao studentDao=new StudentDao();
			Student  studentTmp=new Student();
			studentTmp.setName(userName);
			studentTmp.setPassword(password);
			student=studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student==null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}//
			JOptionPane.showMessageDialog(this, "欢迎["+selectedItem.getName()+"]"+student.getName()+"登入本系统！");
			this.dispose();//登入成功后隐藏登入界面
			new MainFrm(selectedItem, student).setVisible(true);
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText(" ");
		passwordTextField.setText(" ");
		userTypeComboBox.setSelectedIndex(0);
		
	}
}
