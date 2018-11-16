package com.lyn.dao;
import java.sql.Connection;
import java.sql.SQLException;

import com.lyn.util.DbUtil;

//创建用以数据库连接的对象，整个项目与数据库的交互都用这个对象
//获取DbUtil建立起来的连接，传给每个与数据库交互的对象
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
