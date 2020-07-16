package com.wzy.attendence.dao;

import java.util.List;

import com.wzy.attendence.entity.Student;

public interface StuDao {
	public Student selectStuByStuId(int stuId);
	
	public List<Student> selectAllStu();
}
