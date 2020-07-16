package com.wzy.attendence.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wzy.attendence.service.CourseTimeService;
import com.wzy.attendence.service.RecordService;
import com.wzy.attendence.service.StuService;

public class ThreadSpringServiceUtil {
	private static ApplicationContext ctx = null;
	private static RecordService recordService;
	private static CourseTimeService courseTimeService;
	private static StuService stuService;
	static {
		ctx = new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml");
		recordService = (RecordService)ctx.getBean(RecordService.class);
		courseTimeService = (CourseTimeService)ctx.getBean(CourseTimeService.class);
		stuService = (StuService)ctx.getBean(StuService.class);
	}
	public static RecordService getRecordService() {
		return recordService;
	}
	public static CourseTimeService getCourseTimeService() {
		return courseTimeService;
	}
	public static StuService getStuService() {
		return stuService;
	}
}
