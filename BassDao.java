package com.lyn.dao;
import java.sql.Connection;
import java.sql.SQLException;

import com.lyn.util.DbUtil;

//�����������ݿ����ӵĶ���������Ŀ�����ݿ�Ľ��������������
//��ȡDbUtil�������������ӣ�����ÿ�������ݿ⽻���Ķ���
public class BassDao {
	public Connection con=new DbUtil().getCon();
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
