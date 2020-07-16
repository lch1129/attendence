package com.wzy.attendence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzy.attendence.dao.RecordDao;
import com.wzy.attendence.entity.CourseTime;
import com.wzy.attendence.entity.Record;
import com.wzy.attendence.entity.Student;
import com.wzy.attendence.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{

	@Autowired
	private RecordDao recordDao;
	
	@Override
	public int addRecord(Record record) {
		return recordDao.insertRecord(record);
	}

	@Override
	public Record queryOneRecord(CourseTime courseTime, Student stu) {
		return recordDao.selectOneRecord(stu, courseTime);
	}

	@Override
	public List<Record> queryLateRecordByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return recordDao.selectLateRecordByCourse(courseId);
	}

	@Override
	public List<Record> queryLateRecordByCourseTime(CourseTime courseTime) {
		// TODO Auto-generated method stub
		return recordDao.selectLateRecordByCourseTime(courseTime);
	}

	@Override
	public int queryLateTimes(Student stu, int courseId) {
		return recordDao.selectLateTimes(stu, courseId);
	}

	@Override
	public List<Record> queryRecordByCourseTime(CourseTime courseTime) {
		// TODO Auto-generated method stub
		return recordDao.selectRecordByCourseTime(courseTime);
	}

	

}
