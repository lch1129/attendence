package com.wzy.attendence.service;

import java.util.List;

import com.wzy.attendence.entity.Student;

public interface StuService {
	public Student queryStuByStuId(int stuId);
	
	public List<Student> queryAllStu();
}
