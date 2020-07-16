package com.wzy.attendence.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.wzy.attendence.entity.CourseTime;
import com.wzy.attendence.entity.Record;
import com.wzy.attendence.entity.Student;

public interface RecordDao {
	public int insertRecord(Record record);
	
	public Record selectOneRecord(@Param(value="stu")Student stu,
			@Param(value="courseTime")CourseTime courseTime);
	
	public List<Record> selectLateRecordByCourse(int courseId);
	
	public List<Record> selectRecordByCourseTime(CourseTime courseTime);
	
	public List<Record> selectLateRecordByCourseTime(CourseTime courseTime);
	
	public int selectLateTimes(@Param(value="stu")Student stu,@Param(value="courseId")int courseId);
	
	
}
