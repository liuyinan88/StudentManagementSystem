package com.lyn.dao;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lyn.model.StudentClass;
import com.lyn.util.StringUtil;

//班级信息与数据库的操作

public class ClassDao extends BassDao {
	public boolean addClass(StudentClass cl) {
		//向表中添加班级信息
		String sql="insert into s_class value(null,?,?)";//第一个id设置为自增所以不用添加
		try {
			PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, cl.getName());
			preparedStatement.setString(2, cl.getInfo());
			if(preparedStatement.executeUpdate()>0) return true;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<StudentClass> getClassList(StudentClass studentClass){
		List<StudentClass> retList=new ArrayList<StudentClass>();
		String sqlString ="select * from s_class";
		if(!StringUtil.isEmpty(studentClass.getName())) {
			sqlString+=" where name like '%"+studentClass.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement =con.prepareStatement(sqlString);
			//preparedStatement.setString(1, "%"+studentClass.getName()+"%");
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				StudentClass sc=new StudentClass();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) {
		String sql="delete from s_class where id=?";
		try {
			PreparedStatement preparedStatement =con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public boolean update(StudentClass sc) {
		String sql="update s_class set name=?,info=? where id=?";
		try {
			PreparedStatement preparedStatement =con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
