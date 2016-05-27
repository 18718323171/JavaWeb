<%@page import="java.util.ArrayList"%>
<%@page import="Model.QAInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线考试</title>
</head>
<body>
	<% 
	ArrayList<QAInfo> qaInfoArr = (ArrayList<QAInfo>)request.getAttribute("qaInfoArr");
	String stuNum = (String)session.getAttribute("username");
	String stuName = (String)request.getAttribute("stuName");
	String className = (String)request.getAttribute("className");
	String pageNum = (String)request.getAttribute("pageNum");
	String pageType = (String)request.getAttribute("pageType");
	String subject = (String)request.getAttribute("subject");
	int totalScore = Integer.parseInt((String)request.getAttribute("totalScore"));
	int examTime = Integer.parseInt((String)request.getAttribute("examTime"));
	%>
	<h3>考生信息</h3><!-- StuIfo -->
	学号：<%= stuNum %>姓名：<%= stuName %>班级：<%= className %><hr>
	<h3>考试信息</h3><!-- ExamInfo -->
	科目：<%= subject %>试卷类型：<%= pageType %>总分：<%= totalScore %>考试时间：<%= examTime %>剩余考试时间：<hr>
	<h3>试卷信息</h3><!-- TestPageInfo->QAInfo -->
	一、选择题<br>
	<%
		for(int i=0;i<qaInfoArr.size();i++){
			QAInfo qaInfo = qaInfoArr.get(i);
		%>
			<%=i+1 %>、题目：<%= qaInfo.Question %><br>
			<%  
				String[] strAnswer = qaInfo.Answer.split("\\+");	
			%><input type="radio" value="A" name="<%=i+1%>option"/><%=strAnswer[0] %>&nbsp;
			<input value="B" type="radio" name="<%=i+1%>option"/><%=strAnswer[1] %>&nbsp;
			<input value="C" type="radio" name="<%=i+1%>option"/><%=strAnswer[2] %>&nbsp;
			<input value="D" type="radio" name="<%=i+1%>option"/><%=strAnswer[3] %><br>
			
		<% } %>
		<input type="hidden" id = "totalQuestion" value="<%=qaInfoArr.size() %>"/>
	<hr>
	<input type="button" value="提交" onclick="SubExam()"/>
	提交时间：提交人：<!-- ExamInfo -->
	
	
	<script type="text/javascript" src="./Public/js/jquery-1.11.1.min.js"></script>
	
	<script type="text/javascript">
		function SubExam(){
			//alert("123");
			var totalQuestion = $("#totalQuestion").val();
			
			var s="";//{"'1option':'A', '2option':'B'"}
			var i;
			for(i= 1;i<= parseInt(totalQuestion);i++){
				var question = $("input:radio[name='"+i+"option']:checked").val();
				if(question == null){
					alert("你第"+i+"题没选");
					break;
				}else{
					//s += $("input:radio[name='"+i+"option']:checked").val() +"__";
					if(i == 1){
						s+=question;
					}else{
						s+="#"+question;
					}
				}
			}
			
			if(i == parseInt(totalQuestion) +1 ){
				if(confirm("是否要提交试卷？")){
					$post("./ScoreController")
				}
			}
			
			
		}
	
	</script>
</body>
</html>