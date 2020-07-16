package com.wzy.attendence.entity;

public class Student {
	private int stuId;
	private String stuClass;
	private int stuCardId;
	private String stuName;
	private String stuSex;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public int getStuCardId() {
		return stuCardId;
	}
	public void setStuCardId(int stuCardId) {
		this.stuCardId = stuCardId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuClass=" + stuClass + ", stuCardId=" + stuCardId + ", stuName="
				+ stuName + ", stuSex=" + stuSex + "]";
	}
	
}
