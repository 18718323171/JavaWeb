<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.AdminInfo"%>
<%@page import="Model.ExamInfo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
<script type="text/javascript" src="./Public/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">	
			function updatepwd(){
				//获得输入的用户名和密码
	 			var oldPwd = $("#oldPwd").val();
	 			var newPwd1 = $("#newPwd1").val();
	 			var newPwd2 = $("#newPwd2").val();
				if(oldPwd!=""){   //旧密码不为空
					if(newPwd1 !=""){      //新密码不为空
						if(newPwd2 !=""){  //确认新密码不为空
							if(newPwd1==newPwd2){
								$.post("./AdminController",{ "oldPwd":oldPwd,"newPwd":newPwd1, "a":"UpdatePwd"},function(rst){
									if(rst == "success"){  //返回"success"修改成功
										alert("密码修改成功！");
									}else if(rst == "error"){ //返回"error",用户名和密码验证失败
										alert("旧密码错误！");
									}else{
										alert("修改异常！");
									}
								});
							}else{
								alert("再次输入的密码不一致！");
							}
						}else{
							alert("确认新密码不能为空！");
						}
					}else{
						alert("新密码不能为空!");
					}
				}else{
					alert("旧密码不能为空！");
				}
			}
	</script>
</head>
<body>
<%
		AdminInfo admin = (AdminInfo)request.getAttribute("AdminInfo");//接收后台存在request中的StuInfo对象
		String adminNum = admin.AdminNum;   //学号
		String adminName = admin.AdminName; //姓名
		String gender = admin.Gender;		//性别
		
		ArrayList<ExamInfo> ExamArr = (ArrayList<ExamInfo>)request.getAttribute("ExamArr");//接收后台存在request中的试卷对象数组
		String pageNum="";					   //试卷编号
		String classNum="";                    //班级编号
		String className="";                   //班级名称
		String subject="";                     //科目
		String pageType="";					   //试卷类型
		int totalScore=0;					   //总分
		int examTime=0;						   //考试时间
		 %>
<h1>欢迎进入管理员主页</h1><hr>
管理员基本信息：<br>
编号：<%= adminNum %>&nbsp;&nbsp;&nbsp;&nbsp;
姓名：<%= adminName %>&nbsp;&nbsp;&nbsp;&nbsp;
性别：<%= gender %>&nbsp;&nbsp;&nbsp;&nbsp;
<hr>

修改密码：<br>
输入旧密码：<input type="text" id="oldPwd"><br>
输入新密码：<input type="text" id="newPwd1"><br>
确认新密码：<input type="text" id="newPwd2"><br>
<input type="button" value="确定" onclick="updatepwd()">
<hr>
已经安排的考试：<br>
<% for(int i =0; i< ExamArr.size(); i++){
			ExamInfo e = ExamArr.get(i);
			
			pageNum=e.PageNum;
			classNum=e.ClassNum;
			className=e.ClassName;
			subject = e.Subject;
			pageType = e.PageType;
			totalScore = e.TotalScore;
			examTime = e.ExamTime;
			%>
			试卷编号：<%= pageNum %>
			考试班级编号：<%= classNum %>
			考试班级名称：<%= className %>
			科目：<%= subject %>
			试卷类型：<%= pageType %>
			总分：<%= totalScore %>
			考试时间：<%= examTime %>
            <br>
	<% }%> 
<br>安排考试:<br>

</body>
</html>