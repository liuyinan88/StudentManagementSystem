package com.lyn.model;

public enum UserType {
	//成员变量
	ADMIN("管理员",0),TEACHER("教师",1),STUDENT("学生",2);
	private String name;
	private int index;
	//构造函数
	private UserType(String name,int index) {
		this.name=name;
		this.index=index;	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
   @Override
   //改写toString函数将中文name传入userTypeComboBox.setModel()中的地址
	public String toString() {
	   return this.name;
  }
}
