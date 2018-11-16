package com.lyn.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.lyn.dao.TeacherDao;
import com.lyn.model.Teacher;
import com.lyn.util.StringUtil;

public class ManageTeacherFrm extends JInternalFrame {
	private JTable teacherListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JTextField editTeacherAgeTextField;
	private JPasswordField editTeacherPasswordField;
	private JButton editTeacherSubmitButton;
	private JButton deleteTeacherButton;
	private JRadioButton editTeacherSexManRadioButton;
	private JRadioButton editTeacherSexFemalRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTeacherFrm frame = new ManageTeacherFrm();
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
	public ManageTeacherFrm() {
		setClosable(true);
		setIconifiable(true);
		
		getContentPane().setBackground(new Color(153, 204, 204));
		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		getContentPane().setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		setBounds(100, 100, 950, 600);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u8001\u5E08.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		searchTeacherNameTextField.setColumns(10);
		
		JButton searchTeacherButton = new JButton("\u67E5\u8BE2");
		searchTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询
				searchTeacher(e);
			}
		});
		searchTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchTeacherButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(179)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addGap(100)
					.addComponent(searchTeacherButton, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(138, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(134, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE))
					.addGap(108))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(searchTeacherButton)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u8001\u5E08.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		editTeacherNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u6027\u522B.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		ButtonGroup buttonGroup=new ButtonGroup();
		editTeacherSexManRadioButton = new JRadioButton("\u7537");
		editTeacherSexManRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		editTeacherSexManRadioButton.setSelected(true);
		
		editTeacherSexFemalRadioButton = new JRadioButton("\u5973");
		editTeacherSexFemalRadioButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		buttonGroup.add(editTeacherSexManRadioButton);
		buttonGroup.add(editTeacherSexFemalRadioButton);
		
		JLabel label_3 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_3.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u804C\u79F0\u8BC4\u5B9A.png")));
		label_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u6559\u5E08\u5E74\u9F84\uFF1A");
		label_4.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u5E74\u9F84.png")));
		label_4.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		editTeacherAgeTextField = new JTextField();
		editTeacherAgeTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u767B\u5165\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_5.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		editTeacherSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editTeacherSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//信息修改
				editTeacherAct(ae);
			}
		});
		editTeacherSubmitButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u786E\u8BA4.png")));
		editTeacherSubmitButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		deleteTeacherButton = new JButton("\u5220\u9664\u4FE1\u606F");
		deleteTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//删除教师
				deletTeacher(ae);
			}
		});
		deleteTeacherButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteTeacherButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		
		editTeacherPasswordField = new JPasswordField();
		editTeacherPasswordField.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherTitleTextField, 117, 117, 117))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherPasswordField)))
					.addGap(82)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(editTeacherSubmitButton)
							.addGap(111)
							.addComponent(deleteTeacherButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(editTeacherSexManRadioButton)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editTeacherSexFemalRadioButton))
								.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(editTeacherSexManRadioButton)
						.addComponent(editTeacherSexFemalRadioButton))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherSubmitButton, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteTeacherButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(editTeacherPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				//点击ListTable
				selectedTableRow(me);
			}
		});
		teacherListTable.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08ID", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u6559\u5E08\u804C\u79F0", "\u6559\u5E08\u5E74\u9F84", "\u767B\u5165\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(teacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Teacher());
		setAuthority();
	}
	protected void editTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//【信息修改】按钮功能实现
		int row=teacherListTable.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String teacherName=editTeacherNameTextField.getText().toString();
		String teacherSex=editTeacherSexManRadioButton.isSelected()?editTeacherSexManRadioButton.getText().toString():editTeacherSexFemalRadioButton.getText().toString();
		String teacherTitle=editTeacherTitleTextField.getText().toString();
		int teacherAge = 0;
		try {
			teacherAge = Integer.parseInt(editTeacherAgeTextField.getText().toString());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "年龄只允许输入数字！");
			return;
		}
		String teacherPassword=editTeacherPasswordField.getText().toString();
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
		Teacher teacher=new Teacher();
		teacher.setId(Integer.parseInt(teacherListTable.getValueAt(row, 0).toString()));
		teacher.setName(teacherName);
		teacher.setSex(teacherSex);
		teacher.setTitle(teacherTitle);
		teacher.setAge(teacherAge);	
		teacher.setPassword(teacherPassword);
		TeacherDao teacherDao=new TeacherDao();
		if(teacherDao.update(teacher)) {
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else {
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
	}

	protected void searchTeacher(ActionEvent e) {
		// TODO Auto-generated method stub
		//【查询】按钮功能实现
		String teacherNameString=searchTeacherNameTextField.getText().toString();
		Teacher teacher=new Teacher();
		teacher.setName(teacherNameString);
		setTable(teacher);
	}

	protected void deletTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		//删除按钮功能实现
		int row=teacherListTable.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(this, "请选择要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定删除？")!=JOptionPane.OK_OPTION)return; 
		int id=Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
		TeacherDao teacherDao=new TeacherDao();
		if(teacherDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
	}

	private void setTable(Teacher teacher){
		if("教师".equals(MainFrm.userType.getName())) {
			Teacher tLogined=(Teacher) MainFrm.userObject;
			teacher.setName(tLogined.getName());
			searchTeacherNameTextField.setText(teacher.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		dft.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
		for (Teacher t : teacherList) {
			Vector v = new Vector();
			v.add(t.getId());
			v.add(t.getName());
			v.add(t.getSex());
			v.add(t.getTitle());
			v.add(t.getAge());
			v.add(t.getPassword());
			dft.addRow(v);
		}
		teacherDao.closeDao();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		//点击显示教师信息等
		DefaultTableModel dft=(DefaultTableModel) teacherListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 1).toString()); 
		editTeacherTitleTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 3).toString());
		editTeacherAgeTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 4).toString());
		editTeacherPasswordField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 5).toString());	
		String sex=dft.getValueAt(teacherListTable.getSelectedRow(), 2).toString();
		if(sex.equals(editTeacherSexManRadioButton.getText()))editTeacherSexManRadioButton.setSelected(true);
		if(sex.equals(editTeacherSexFemalRadioButton.getText()))editTeacherSexFemalRadioButton.setSelected(true);
	}
	private void setAuthority() {
		if("教师".equals(MainFrm.userType.getName())){
			deleteTeacherButton.setEnabled(false);
			searchTeacherNameTextField.setEnabled(false);
		}
	}
}
