package com.wzy.attendence.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Record {
	private int recordId;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date recordTime;
	private CourseTime courseTime;
	private boolean late;
	private Student stu;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	public CourseTime getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(CourseTime courseTime) {
		this.courseTime = courseTime;
	}
	public boolean isLate() {
		return late;
	}
	public void setLate(boolean late) {
		this.late = late;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", recordTime=" + recordTime + ", courseTime=" + courseTime + ", late="
				+ late + ", stu=" + stu + "]";
	}
	
	
	
}
