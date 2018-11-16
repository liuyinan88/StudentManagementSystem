package com.lyn.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lyn.model.UserType;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;//�½��û����Ͷ���
	public static Object userObject;//��Ϊ��ǰ��֪���ĸ���ɫ���룬��������object
	private JMenu manageClassMenu;
	private JMenuItem addStudentMenuItem;
	private JMenu manageTeacherMenu;
	private JMenuItem addTeacherMenuItem;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public MainFrm(UserType userType,Object userObject) {
		//��ֵ
		this.userType=userType;
		this.userObject=userObject;
		
		setTitle("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 900);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menu.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//�޸�����
				editPassword(ae);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		mntmNewMenuItem.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�˳�ϵͳ
				if(JOptionPane.showConfirmDialog(MainFrm.this, "ȷ���˳���")==JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		menuItem.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menu.add(menuItem);
		
		JMenu mnNewMenu = new JMenu(" \u5B66\u751F\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		mnNewMenu.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		addStudentMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ѧ����ӡ�����ʵ�֣�����
				AddStudentFrm addStudentFrm = new AddStudentFrm();
				addStudentFrm.setVisible(true);
				desktopPane.add(addStudentFrm);

			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		addStudentMenuItem.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		mnNewMenu.add(addStudentMenuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ѧ���б�
				ManageStudentFrm studentManageFrm=new ManageStudentFrm();
				studentManageFrm.setVisible(true);
				desktopPane.add(studentManageFrm);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		menuItem_2.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		mnNewMenu.add(menuItem_2);
		
		manageClassMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		manageClassMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		manageClassMenu.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menuBar.add(manageClassMenu);
		
		JMenuItem menuItem_3 = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//�༶���
				addStudentClass(ae);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		menuItem_3.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		manageClassMenu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u73ED\u7EA7\u5217\u8868");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�༶�б�
				ManageClassFrm classManageFrm =new ManageClassFrm();
				classManageFrm.setVisible(true);
				desktopPane.add(classManageFrm);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		menuItem_4.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		manageClassMenu.add(menuItem_4);
		
		manageTeacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		manageTeacherMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8001\u5E08.png")));
		menuBar.add(manageTeacherMenu);
		
		addTeacherMenuItem = new JMenuItem("\u6559\u5E08\u6DFB\u52A0");
		addTeacherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//��ʦ���
				AddTeacheFrm ta =new AddTeacheFrm();
				ta.setVisible(true);
				desktopPane.add(ta);
			}
		});
		addTeacherMenuItem.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		addTeacherMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		manageTeacherMenu.add(addTeacherMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u6559\u5E08\u5217\u8868");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//��ʦ�б�
				ManageTeacherFrm manageTeacherFrm =new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
				desktopPane.add(manageTeacherFrm);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("���� Light", Font.PLAIN, 15));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		manageTeacherMenu.add(mntmNewMenuItem_2);
		
		JMenu menu_2 = new JMenu("\u5E2E\u52A9");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E\u52A9.png")));
		menu_2.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("\u5173\u4E8E\u6211");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//��������
				aboutUs(ae);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menuItem_5.setFont(new Font("΢���ź� Light", Font.PLAIN, 15));
		menu_2.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(51, 102, 153));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void addStudentClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		//���༶��ӡ�����ʵ�֣�����
		AddStudentClassFrm sca =new AddStudentClassFrm();
		sca.setVisible(true);
		desktopPane.add(sca);
		
	}

	protected void editPassword(ActionEvent ae) {
		//���޸����롿��ʾ����ʵ�֣�����
		// TODO Auto-generated method stub
	    EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
	    editPasswordFrm.setVisible(true);
	    desktopPane.add(editPasswordFrm);
	    
	}

	protected void aboutUs(ActionEvent ae) {
		//���������ǡ�����ʵ�֣�����
		// TODO Auto-generated method stub
		String info="����:������\n";
		info+="ѧ��:20152100071\n";
		info+="�༶:���ݿ�2��";
		JOptionPane.showMessageDialog(this, info);
	}
	private void setAuthority() {
		if("ѧ��".equals(userType.getName())) {
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
		}
		if("��ʦ".equals(userType.getName())) {
			addTeacherMenuItem.setEnabled(false);
			
		}
	}
}
