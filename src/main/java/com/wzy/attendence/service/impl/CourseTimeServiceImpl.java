package com.wzy.attendence.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzy.attendence.dao.CourseTimeDao;
import com.wzy.attendence.entity.CourseTime;
import com.wzy.attendence.service.CourseTimeService;

@Service
public class CourseTimeServiceImpl implements CourseTimeService{

	@Autowired
	private CourseTimeDao courseTimeDao;

	@Override
	public CourseTime queryCourseTimeByDate(Date date){
		return courseTimeDao.selectCourseTimeByDate(date);
	}

	@Override
	public List<CourseTime> queryCourseTimeByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return courseTimeDao.selectCourseTimeByCourseId(courseId);
	}

	@Override
	public CourseTime queryCourseTimeByStartTime(Date startTime) {
		// TODO Auto-generated method stub
		return courseTimeDao.selectCourseTimeByStartTime(startTime);
	}

	@Override
	public CourseTime queryCourseTimeByCourseTimeId(int courseTimeId) {
		// TODO Auto-generated method stub
		return courseTimeDao.selectCourseTimeById(courseTimeId);
	}
	
	

}
