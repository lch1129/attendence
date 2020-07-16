package com.wzy.attendence.service;

import java.util.Date;
import java.util.List;

import com.wzy.attendence.entity.CourseTime;

public interface CourseTimeService {
	public CourseTime queryCourseTimeByDate(Date date);
	
	public List<CourseTime> queryCourseTimeByCourseId(int courseId);
	
	public CourseTime queryCourseTimeByStartTime(Date startTime);

	public CourseTime queryCourseTimeByCourseTimeId(int courseTimeId);
}
