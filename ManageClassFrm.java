package com.lyn.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.lyn.dao.ClassDao;
import com.lyn.model.StudentClass;
import com.lyn.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClassFrm extends JInternalFrame {
	private JTable classListTable;
	private JTextField searchClassNameTextField;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClassFrm frame = new ManageClassFrm();
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
	public ManageClassFrm() {
		setClosable(true);//可关闭
		setIconifiable(true);//可隐藏放大缩小
		getContentPane().setBackground(new Color(153, 204, 204));
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 900, 620);
		
		JScrollPane scrollPane = new JScrollPane();
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		label.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u641C\u7D22");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//查询按钮
				StudentClass sc=new StudentClass();
				sc.setName(searchClassNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0:");
		label_1.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F:");
		label_2.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		editClassInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//确认修改按钮
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u5220\u9664.png")));
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//删除按钮
				deleteClassAct(ae);
				
			}
		});
		submitDeleteButton.setFont(new Font("微软雅黑 Light", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(label)
							.addGap(31)
							.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(82)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editClassInfoTextArea))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)))))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(searchButton, 0, 0, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(searchClassNameTextField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(submitDeleteButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(375);
		classListTable.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StudentClass());//在初始化中调用setTable

	}
	protected void deleteClassAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//删除按钮功能实现
		if(JOptionPane.showConfirmDialog(this, "确认删除？")!=JOptionPane.OK_OPTION) {
			return;
		}
		int index=classListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();
		int id=Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassDao classDao =new ClassDao();
		if(classDao.delete(id)) {
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else {
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		classDao.closeDao();
		setTable(new StudentClass());//在初始化中调用setTable
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//确认修改按钮功能实现
		ClassDao classDao=new ClassDao();
		int index=classListTable.getSelectedRow();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();
		String className=dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo=dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName=editClassNameTextField.getText().toString();
		String editClassInfo=editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的名称！");
			return;
		}
		if(className.equals(editClassName)&&classInfo.equals(editClassInfo)) {
			JOptionPane.showMessageDialog(this, "您没有做任何修改！");
			return;
		}
		int id=Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		StudentClass sc=new StudentClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if(classDao.update(sc)) {
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else {
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		classDao.closeDao();
		setTable(new StudentClass());
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		//点击显示班级信息等-函数
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());  
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());	
	}

	private void setTable(StudentClass studentClass) {
		DefaultTableModel dft=(DefaultTableModel) classListTable.getModel();
		dft.setRowCount(0);//初始化列表清空
		ClassDao classDao=new ClassDao();
		List<StudentClass> classList = classDao.getClassList(studentClass);
		for(StudentClass sc:classList) {
			Vector v =new Vector<>();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);//把Vector给dft的Modle，会按照v.add的顺序添加数据
		}
		classDao.closeDao();
	}
}
