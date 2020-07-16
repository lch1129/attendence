package com.wzy.attendence.service;

import java.util.List;

import com.wzy.attendence.entity.CourseTime;
import com.wzy.attendence.entity.Record;
import com.wzy.attendence.entity.Student;

public interface RecordService {
	public int addRecord(Record record);
	
	public Record queryOneRecord(CourseTime courseTime,Student stu);
	
	public List<Record> queryLateRecordByCourseId(int courseId);
	
	public List<Record> queryLateRecordByCourseTime(CourseTime courseTime);
	
	public int queryLateTimes(Student stu,int courseId);

	public List<Record> queryRecordByCourseTime(CourseTime courseTime);
}
