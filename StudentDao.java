package com.lyn.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.lyn.model.Admin;
import com.lyn.model.Student;
import com.lyn.model.StudentClass;
import com.lyn.util.StringUtil;


public class StudentDao extends BassDao {
	public boolean addStudent(Student student){
		String sql = "insert into s_student values(null,?,?,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassId());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getSex());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Student> getStudentList(Student student){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from s_student");
		if(!StringUtil.isEmpty(student.getName())){
			sqlString.append(" and name like '%"+student.getName()+"%'");
		}
		if(student.getClassId() != 0){
			sqlString.append(" and classId ="+student.getClassId());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));
				s.setClassId(executeQuery.getInt("classId"));
				s.setSex(executeQuery.getString("sex"));
				s.setPassword(executeQuery.getString("password"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id) {
		String sql="delete from s_student where id=?";
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
	
	public boolean update(Student student) {
		String sql="update s_student set name=?,classId=?,sex=?,password=? where id=?";
		try {
			PreparedStatement preparedStatement =con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassId());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getPassword());
			preparedStatement.setInt(5, student.getId());
			if(preparedStatement.executeUpdate()>0) {
				return true;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public String editPassword(Student student,String newPassword) {
		//�޸����뺯��
		String sql="select * from s_student where id=? and password=?";//?��ռλ��
		PreparedStatement prst=null;
		int id=0;
		try {
			//��sql��䴫�ݸ����ݿ����
			prst=con.prepareStatement(sql);
			prst.setInt(1, student.getId());
			prst.setString(2, student.getPassword());
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
		String sqlString="update s_student set password = ? where id = ?";
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
	public Student login(Student student) {
		String sql="select * from s_student where name=? and password=?";//?��ռλ��
		Student studentRst=null;
		try {
			PreparedStatement prst=con.prepareStatement(sql);
			//��sql��䴫�ݸ����ݿ����
			prst.setString(1, student.getName());
			prst.setString(2, student.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			//�����ݿ���Ӧ�Ĳ�ѯ��������ResultSet������й�����ʹ��
			if(executeQuery.next()) {
				studentRst=new Student();
				studentRst.setId(executeQuery.getInt("id"));
				studentRst.setName(executeQuery.getString("name"));
				studentRst.setClassId(executeQuery.getInt("classId"));
				studentRst.setPassword(executeQuery.getString("password"));
				studentRst.setSex(executeQuery.getString("sex"));
				
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
		return studentRst;
		}
}
