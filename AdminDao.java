package com.lyn.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyn.model.Admin;

public class AdminDao extends BassDao {
	//����Ա����
	public Admin login(Admin admin) {
	String sql="select * from s_admin where name=? and password=?";//?��ռλ��
	Admin adminRst=null;
	try {
		PreparedStatement prst=con.prepareStatement(sql);
		//��sql��䴫�ݸ����ݿ����
		prst.setString(1, admin.getName());
		prst.setString(2, admin.getPassword());
		ResultSet executeQuery = prst.executeQuery();
		//�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ��
		if(executeQuery.next()) {
			adminRst=new Admin();
			adminRst.setId(executeQuery.getInt("id"));
			adminRst.setName(executeQuery.getString("name"));
			adminRst.setPassword(executeQuery.getString("password"));
			adminRst.setCreateDate(executeQuery.getString("createData"));
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
/*	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	return adminRst;
	}
	public String editPassword(Admin admin,String newPassword) {
		//�޸����뺯��
		String sql="select * from s_admin where id=? and password=?";//?��ռλ��
		PreparedStatement prst=null;
		int id=0;
		try {
			//��sql��䴫�ݸ����ݿ����
			prst=con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			//�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ��
			if(!executeQuery.next()) {
				String retString="���������";
				return retString;
			}
			id=executeQuery.getInt("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String retString="�޸�ʧ�ܣ�";
		String sqlString="update s_admin set password = ? where id = ?";
		try {
			prst=con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst=prst.executeUpdate();
			if(rst>0) {
				retString="�����޸ĳɹ���";
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retString;
	}
}
