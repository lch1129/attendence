package com.wzy.attendence.dao;

import java.util.Date;
import java.util.List;

import com.wzy.attendence.entity.CourseTime;

public interface CourseTimeDao {
	public CourseTime selectCourseTimeByDate(Date date);
	
	public List<CourseTime> selectCourseTimeByCourseId(int courseId);
	
	public CourseTime selectCourseTimeByStartTime(Date startTime);

	public CourseTime selectCourseTimeById(int courseTimeId);
}
