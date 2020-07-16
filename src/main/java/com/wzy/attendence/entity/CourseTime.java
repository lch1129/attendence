package com.wzy.attendence.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CourseTime {
	private int courseTimeId;
	private Course course;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date startTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date endTime;
	public int getCourseTimeId() {
		return courseTimeId;
	}
	public void setCourseTimeId(int courseTimeId) {
		this.courseTimeId = courseTimeId;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "CourseTime [courseTimeId=" + courseTimeId + ", course=" + course + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
}
