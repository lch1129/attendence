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
	var html = '';
	data.map(function(item, index){
		html += '<option value="' + item.courseId + '">' + item.courseName + '</option>';
	});
	$('#course_name').html(html);
}

function handleList(data){
	$('#result tbody').html("");
	$('#result_btn').attr("hidden",'true');
	if(data.success){
		var html = '';
		for(var i=0;i<data.stuList.length;i++){
			html += '<tr><td>' + data.stuList[i].stuName + '</td><td>' + data.stuList[i].stuId + '</td><td>' + 
			data.lateNumList[i] + '</td><td>' + data.absenceNumList[i] + '</td></tr>';
		}
		$('#result tbody').append(html);
		$('#result_btn').removeAttr("hidden");
		$("#result_btn").click(function(){
			$("#result").table2excel({
				exclude: ".noExl",
				name: "Excel Document Name",
				filename: $('#course_name option:selected').text()+"学期考勤结果",
				exclude_img: true,
				exclude_links: true,
				exclude_inputs: true
			});
		});
	}
}

$(document).ready(function(){
	initselect();
	$("#submit").click(function(){
		$.ajax({
			"type" : "POST",
			"url" : "/attendence/select/selectbyterm",
			"data" : "courseId=" + $('#course_name option:selected').val(), 
			"dataType" : "JSON",
			"success" : handleList
		});
	});
});