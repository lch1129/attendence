package com.wzy.attendence.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.wzy.attendence.entity.CourseTime;
import com.wzy.attendence.entity.Record;
import com.wzy.attendence.entity.Student;
import com.wzy.attendence.service.CourseTimeService;
import com.wzy.attendence.service.RecordService;
import com.wzy.attendence.service.StuService;
import com.wzy.attendence.util.ThreadSpringServiceUtil;


public class SocketThread extends Thread{
	
	private ServerSocket serverSocket = null;
	private static CourseTimeService courseTimeService;
	private static StuService stuService;
	private static RecordService recordService;

	public SocketThread(ServerSocket serverScoket){
		try {
			if(serverScoket == null) {
				this.serverSocket = new ServerSocket(12345);
				System.out.println("socket start...");
			}
		}catch(Exception e) {
			System.out.println("SocketThread创建socket服务出错");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			Socket ss=serverSocket.accept();
			String ip=ss.getLocalAddress().getHostAddress();
			System.out.println(ip+".....conected");
			byte buf[] = new byte[1024];
			InputStream is = ss.getInputStream();
			String data = null;
			courseTimeService = ThreadSpringServiceUtil.getCourseTimeService();
			stuService = ThreadSpringServiceUtil.getStuService();
			recordService = ThreadSpringServiceUtil.getRecordService();
			while(is.read(buf, 0, buf.length) > 0) {
				data = new String(buf,"ASCII");
				int cardId = Integer.parseInt(data.trim());
				Date recordTime = new Date();
				CourseTime courseTime = courseTimeService.queryCourseTimeByDate(recordTime);
				if(courseTime == null) {
					System.out.println("刷卡无效！此时不在规定刷卡时间范围内！");
				}
				else {
					Student stu = stuService.queryStuByStuId(cardId);
					if(stu == null) {
						System.out.println("无效用户，刷卡失败！");
					}else {
						Record queryRecord = recordService.queryOneRecord(courseTime, stu);
						if(queryRecord == null) {
							Record record = new Record();
							record.setRecordTime(recordTime);
							record.setStu(stu);
							record.setCourseTime(courseTime);
							if(recordTime.before(courseTime.getStartTime())) {
								record.setLate(false);
							}else {
								record.setLate(true);
							}
							int effectedNum = recordService.addRecord(record);
							if(effectedNum == 1) {
								System.out.println(record.getStu().getStuId() + "号" + record.getStu().getStuName() +
										"同学刷卡成功！" + (record.isLate()?"迟到了哦~":"没迟到哦~"));
							}else {
								System.out.println("刷卡失败了，试试再刷一次！");
							}
						}else {
							System.out.println(queryRecord.getStu().getStuId() + "号" + 
									queryRecord.getStu().getStuName() + "同学该节课已经刷过卡，不要重复刷！");	
						}
					}
				}
			}
			ss.close();
			serverSocket.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
