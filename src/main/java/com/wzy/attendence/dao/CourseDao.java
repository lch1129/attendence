package com.wzy.attendence.dao;

import java.util.List;

import com.wzy.attendence.entity.Course;

public interface CourseDao {
	List<Course> selectAllCourse();
}
