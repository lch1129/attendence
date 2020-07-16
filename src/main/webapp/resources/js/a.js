/**
 * 
 */
function initselect(){
	$.getJSON("/attendence/select/initselect", function(data) {
		if(data.success) {
			handleSelectList(data.courseList);
		} 
		else{
			alert("网页加载错误！");
		}
	});
}

function handleSelectList(data){
	var html = "<option value='0' selected='selected'></option>";
	$('#course_time').html(html);
	var html = "<option value='0' selected='selected'>请选择课程</option>";
	data.map(function(item, index){
		html += '<option value="' + item.courseId + '">' + item.courseName + '</option>';
	});
	$('#course_name').html(html);
}

function findCourseTime(){
	$.ajax({
		"type" : "GET",
		"url" : "/attendence/select/initselectcoursetime",
		"data" : "courseId=" + $('#course_name option:selected').val(), 
		"dataType" : "JSON",
		"success" : handleSelectCourseTimeList
	});
}

function handleSelectCourseTimeList(data){
	if(data.success){
		var html = "<option value='0' selected='selected'>请选择课时</option>";
		data.courseTimeList.map(function(item, index){
			html += '<option value="' + item.courseTimeId + '">' + item.startTime + '</option>';
		});
		$('#course_time').html(html);
	}else{
		var html = "<option value='0' selected='selected'></option>";
		$('#course_time').html(html);
	}
}

function handleList(data){
	$('#late tbody').html('');
	$('#late_btn').attr("hidden",'true');
	$('#attendance tbody').html('');
	$('#attendance_btn').attr("hidden",'true');
	if(data.success){
		var teacherName = data.teacherName;
		var courseName = data.courseName;
		var requireNumber = data.requireNumber;
		var actualNumber = data.actualNumber;
		var lateNumber = data.lateNumber;
		var latePoint = data.latePoint;
		var attendancePoint = data.attendancePoint;
		var lateList = data.lateList;
		var absenceList = data.absenceList;
		$('#teacher_name').html('任课老师:' + teacherName);
		$('#class_name').html('上课班级:A1651班');
		$('#require_number').html('应到人数:' + requireNumber + '人');
		$('#actual_number').html('实到人数:' + actualNumber + '人');
		$('#attendance_point').html('到课率:' + toParent(attendancePoint));
		$('#late_number').html('迟到人数:' + lateNumber);
		$('#late_point').html('迟到率:' + toParent(latePoint));
		var html1 = '';
		lateList.map(function(item, index){
			html1 += '<tr><td>' + item.stu.stuName + '</td><td>' + item.stu.stuCardId + '</td></tr>';
		});
		$('#late tbody').append(html1);
		$('#late_btn').removeAttr("hidden");
		$("#late_btn").click(function(){
			$("#late").table2excel({
				exclude: ".noExl",
				name: "Excel Document Name",
				filename: courseName+$('#course_time option:selected').text()+"迟到名单",
				exclude_img: true,
				exclude_links: true,
				exclude_inputs: true
			});
		});
		
		var html2 = '';
		absenceList.map(function(item, index){
			html2 += '<tr><td>' + item.stu.stuName + '</td><td>' + item.stu.stuCardId + '</td></tr>';
		});
		$('#attendance tbody').append(html2);
		$('#attendance_btn').removeAttr("hidden");
		$("#attendance_btn").click(function(){
			$("#attendance").table2excel({
				exclude: ".noExl",
				name: "Excel Document Name",
				filename: courseName+$('#course_time option:selected').text()+"缺勤名单",
				exclude_img: true,
				exclude_links: true,
				exclude_inputs: true
			});
		});
	}else{
		alert('查询条件错误，请重新选择！');
	}
}

function toParent(point){
	if(point==0){
		return 0;
	}
	var str=Number(point*100).toFixed();
	str+="%";
	return str;
}
$(document).ready(function(){
	initselect();
	$("#submit").click(function(){
		$.ajax({
			"type" : "POST",
			"url" : "/attendence/select/selectbycoursestarttime",
			"data" : "courseTimeId=" + $('#course_time option:selected').val(), 
			"dataType" : "JSON",
			"success" : handleList
		});
	});
});