package com.wzy.attendence.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzy.attendence.entity.Absence;
import com.wzy.attendence.entity.Course;
import com.wzy.attendence.entity.CourseTime;
import com.wzy.attendence.entity.Record;
import com.wzy.attendence.entity.Student;
import com.wzy.attendence.service.CourseService;
import com.wzy.attendence.service.CourseTimeService;
import com.wzy.attendence.service.RecordService;
import com.wzy.attendence.service.StuService;

@Controller
@RequestMapping("/select")
public class selectController {
	@Autowired
	private CourseTimeService courseTimeService;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private StuService stuService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("a")
	public String a() {
		return "a";
	}
	
	@RequestMapping("b")
	public String b() {
		return "b";
	}
	
	@RequestMapping("tomain")
	public String main() {
		return "main";
	}
	
	@RequestMapping("totop")
	public String top() {
		return "top";
	}
	
	@RequestMapping("tobody")
	public String body() {
		return "body";
	}
	
	@RequestMapping("toleft")
	public String left() {
		return "left";
	}
	
	@ResponseBody
	@RequestMapping(value="/initselect",method=RequestMethod.GET)
	private Map<String,Object> initselect(){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		List<Course> courseList = courseService.queryAllCourse();
		if(courseList !=null && courseList.size() != 0) {
			modelMap.put("success", true);
			modelMap.put("courseList", courseList);
			return modelMap;
		}
		else {
			modelMap.put("success", false);
			return modelMap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/initselectcoursetime",method=RequestMethod.GET)
	private Map<String,Object> initselectcoursetime(HttpServletRequest req){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		String courseId = req.getParameter("courseId");
		List<CourseTime> courseTimeList = courseTimeService.queryCourseTimeByCourseId(Integer.valueOf(courseId));
		if(courseTimeList == null || courseTimeList.size()==0) {
			modelMap.put("success", false);
			return modelMap;
		}else {
			modelMap.put("success", true);
			modelMap.put("courseTimeList", courseTimeList);
			return modelMap;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/selectbyterm",method=RequestMethod.POST)
	private Map<String,Object> selectbyterm(HttpServletRequest req){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		String courseId = req.getParameter("courseId");
		List<Student> stuList = stuService.queryAllStu();
		List<Integer> lateNumList = new ArrayList<Integer>();
		List<Integer> absenceNumList = new ArrayList<Integer>();
		for(Student stu:stuList) {
			int num = recordService.queryLateTimes(stu, Integer.valueOf(courseId));
			lateNumList.add(num);
		}
		List<CourseTime> courseTimeList = courseTimeService.queryCourseTimeByCourseId(Integer.valueOf(courseId));
		for(Student stu:stuList) {
			int absenceNum=0;
			for(CourseTime courseTime:courseTimeList) {
				Record r =recordService.queryOneRecord(courseTime, stu);
				if(r==null) {
					absenceNum++;
				}
			}
			absenceNumList.add(absenceNum);
		}
		modelMap.put("stuList", stuList);
		modelMap.put("lateNumList", lateNumList);
		modelMap.put("absenceNumList", absenceNumList);
		modelMap.put("success", true);
		return modelMap;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/selectbycoursestarttime",method=RequestMethod.POST)
	private Map<String,Object> selectbycoursetime(HttpServletRequest req){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		String courseTimeId = req.getParameter("courseTimeId");
		if(courseTimeId == null || courseTimeId.equals("0")) {
			modelMap.put("success", false);
			return modelMap;
		}
		CourseTime courseTime = courseTimeService.queryCourseTimeByCourseTimeId(Integer.valueOf(courseTimeId));
		List<Record> lateList = recordService.queryLateRecordByCourseTime(courseTime);
		String teacherName = courseTime.getCourse().getCourseTeacher();
		String courseName = courseTime.getCourse().getCourseName();
		int requireNumber = stuService.queryAllStu().size();
		int actualNumber = recordService.queryRecordByCourseTime(courseTime).size();
		int lateNumber = lateList.size();
		float latePoint;
		if(actualNumber==0) {
			latePoint=0;
		}else {
			latePoint = (float)lateNumber/actualNumber;
		}
		float attendancePoint = (float)actualNumber/requireNumber;
		List<Absence> absenceList = new ArrayList<Absence>();
		List<Student> stuList = stuService.queryAllStu();
		for(Student stu:stuList) {
			Record r = recordService.queryOneRecord(courseTime, stu);
			if(r==null) {
				Absence absence = new Absence();
				absence.setCourseTime(courseTime);
				absence.setStu(stu);
				absenceList.add(absence);
			}
		}
		modelMap.put("teacherName", teacherName);
		modelMap.put("courseName", courseName);
		modelMap.put("requireNumber", requireNumber);
		modelMap.put("actualNumber", actualNumber);
		modelMap.put("lateNumber", lateNumber);
		modelMap.put("latePoint", latePoint);
		modelMap.put("attendancePoint", attendancePoint);
		modelMap.put("lateList", lateList);
		modelMap.put("absenceList", absenceList);
		modelMap.put("success", true);
		return modelMap;
	}
}
