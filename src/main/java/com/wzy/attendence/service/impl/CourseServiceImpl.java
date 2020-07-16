package com.wzy.attendence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzy.attendence.dao.CourseDao;
import com.wzy.attendence.entity.Course;
import com.wzy.attendence.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> queryAllCourse() {
		return courseDao.selectAllCourse();
	}

}
