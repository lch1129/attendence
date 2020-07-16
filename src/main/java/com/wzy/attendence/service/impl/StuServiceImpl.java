package com.wzy.attendence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzy.attendence.dao.StuDao;
import com.wzy.attendence.entity.Student;
import com.wzy.attendence.service.StuService;

@Service
public class StuServiceImpl implements StuService {

	@Autowired
	private StuDao stuDao;
	
	@Override
	public Student queryStuByStuId(int stuId) {
		return stuDao.selectStuByStuId(stuId);
	}

	@Override
	public List<Student> queryAllStu() {
		// TODO Auto-generated method stub
		return stuDao.selectAllStu();
	}

}
