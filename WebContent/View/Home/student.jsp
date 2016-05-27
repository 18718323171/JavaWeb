<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.ExamInfo"%>
<%@page import="Model.StuInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
    <link href="./Public/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="./Public/css/examAdmin.css" rel="stylesheet" type="text/css">
<title>学生主页</title>
</head>
<body>
<%
		StuInfo student = (StuInfo)request.getAttribute("StuInfo");//接收后台存在request中的StuInfo对象
		String stuName = student.StuName; //姓名
		String stuNum = student.StuNum;   //学号
		String className = student.ClassName;  //班级
		String gender = student.Gender;		   //性别
		String idCard = student.IdCard;		   //身份证
		String subTime = ((Object)student.SubTime).toString();//注册时间
		
		ArrayList<ExamInfo> ExamArr = (ArrayList<ExamInfo>)request.getAttribute("ExamArr");//接收后台存在request中的试卷对象数组
		String pageNum="";					   //试卷编号
		String subject="";                     //科目
		String pageType="";					   //试卷类型
		int totalScore=0;					   //总分
		int examTime=0;						   //考试时间
		
	%>
	<!--背景图片开始-->
		<div>
			<image src="./Public/images/header6.jpg" width="100%" height="140px">
		</div>
		<!--背景图片结束-->
	<!--顶栏开始-->
		<div class="Head bg-primary">
			学号:<span><%= stuNum %></span>&nbsp;&nbsp;姓名:<span><%= stuName %></span><span class="exit"><span><a href="#" style="color:white">注销</a></span>&nbsp;<span><a href="#" style="color:white">退出</a></span></span>
		</div>
		<!--顶栏结束-->
	<!--主体内容开始-->
		<div class="main">
			<!--左右栏框分布源码开始-->
				<!--左栏框开始-->
					<span class="main-left" id="div_left">
						<!--左栏内容开始-->
							<div class="left-style text"><a href="#" onclick="hiddenOp('userInfo')">学生信息</a></div>
							<div class="left-style text" ><a href="javascript:void(0)" onclick="hiddenOp('testManage')">学生考试</a></div>
							<div class="left-style text"><a href="#" id="b01" onclick="hiddenOp('updatePwd')">修改密码</a></div>
							<!--左栏内容结束-->
					</span>
					<!--左栏框结束-->
				<!--右栏框开始-->
					<span class="main-right" id="main_content_right" id="div_right">
						<!--右栏内容边框开始-->
							<!--用户信息开始-->
								<div class="right-style" id="userInfo">
									<h2 style="text-align:center;">学生信息</h2><hr style="border:solid 1px #666666">
									<div class="right-info-style"><span>学号：<input type="text" id="txtNum" readonly="readonly" value="<%= stuNum %>" style="border:none;"></span></div>
									<div class="right-info-style"><span>姓名：<input type="text" id="txtName" readonly="readonly" value="<%= stuName %>" style="border:none;"></span></div>
									<div class="right-info-style"><span>性别：<input type="text" id="txtGender" readonly="readonly" value="<%= gender %>" style="border:none;"></span></div>
									<div class="right-info-style"><span>身份证：<input type="text" id="txtIdCard" readonly="readonly" value="<%= idCard %>" style="border:none;"></span></div>
									<!-- <div class="right-info-style"><span>常用邮箱：<input type="text" id="txtEmail" readonly="readonly" value="1091313628@qq.com" style="border:none;"></span></div>
									<div class="right-info-style"><span>最近登录IP：<input type="text" id="txtIP" readonly="readonly" value="192.1.3.4" style="border:none;"></span></div> -->
									<div class="right-info-style"><span>最近登录时间：<input type="text" id="txtTime" readonly="readonly" value="<%= subTime %>" style="border:none;"></span></div>
									<div style="text-align:center;margin-top:6%;"><input type="button" style="width:20%;" value="修改" onclick="update()"><input type="button" style="width:20%;" value="取消" onclick="updateCancel()"></div>
								</div>
								<!--用户信息结束-->
							<!--学生考试开始-->
								<div class="right-style" id="testManage" style="display:none;">
									
									</div>
								<!--学生考试结束-->
							<!--修改密码开始-->
								<div class="right-style" id="updatePwd" style="display:none;">
										<h2 style="text-align:center;">修改密码</h2><hr style="border:solid 1px #666666">
										
										<div style="height:60%;padding-top:5%;">
											<div class="right-pwd-style">旧密码：<input class="right-pwd-txtStyle pwd" type="text"></div>
											<div class="right-pwd-style">新密码：<input class="right-pwd-txtStyle pwd" type="text"></div>
											<div class="right-pwd-style">确认密码：<input class="right-pwd-txtStyle pwd" type="text"></div>
											<div class="right-pwd-style"><input type="button" style="width:20%;" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" style="width:20%;" value="重置"></div>
										</div>
										
								</div>
								<!--修改密码结束-->
							<!--右栏内容边框结束-->
					</span>
					<!--右栏框结束-->
				<!--左右栏框分布源码结束-->
			</div>
		<!--主体内容结束-->
	<h2>学生基本信息</h2><hr>
	学号：<%= stuNum %><br>
	姓名：<%= stuName %><br>
	性别：<%= gender %><br>
	身份证号码：<%= idCard %><br>
	班级：<%= className %><br>
	<h2>学生考试安排</h2><hr>
	<% for(int i =0; i< ExamArr.size(); i++){
			ExamInfo e = ExamArr.get(i);
			pageNum=e.PageNum;
			subject = e.Subject;
			pageType = e.PageType;
			totalScore = e.TotalScore;
			examTime = e.ExamTime;
			%>
			科目：<%= subject %>
			<%-- <a href="ExamController?a=getPageInfo&pageNum=<%=pageNum %>&subject=<%= subject%>
			&pageType=<%= pageType%>&totalScore=<%= totalScore%>&examTime=<%= examTime%>
			&stuName=<%= stuName%>&className=<%= className%>">试卷编号:</a> --%>
			试卷编号：<%= pageNum %>
			班级：<%=className %>
	<% }%> 
	
	<input type="hidden" id="LinkPage" value="ExamController?a=getPageInfo&pageNum=<%=pageNum %>
	&subject=<%= subject%>&pageType=<%= pageType%>&totalScore=<%= totalScore%>
	&examTime=<%= examTime%>&stuName=<%= stuName%>&className=<%= className%>"/>
	 <input type="button" value="我要考试" onclick="getPageInfo()"/> 
	<%-- <a href="./ExamController?a=getPageInfo&pageNum=<%=pageNum %>" >我要考试</a> --%>
	
	<!-- <script type="text/javascript" src="./Public/js/jquery-1.11.1.min.js"></script> -->
	<script type="text/javascript" src="./Public/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="./Public/js/student.js"></script>
	<script type="text/javascript" src="./Public/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function getPageInfo(){
			var LinkPage = $("#LinkPage").val();
			var L="./";
			//alert(LinkPage);
			//$.post('ExamController?a=getPageInfo',{"pageNum":pageNum, "subject":subject,"pageType":pageType,"totalScore":totalScore,"examTime":examTime,"stuName":stuName,"className":className});
			window.location.href="./"+LinkPage;
			
		}
	</script>
</body>
</html>