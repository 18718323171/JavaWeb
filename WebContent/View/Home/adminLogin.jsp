<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<script type="text/javascript" src="../../Public/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">	
			function checklogin(){
				//获得输入的用户名和密码
	 			var username = $("#username").val();
	 			var password = $("#password").val();
				if(username!=""){   //用户名不为空
					if(password !=""){      //密码不为空
						//window.location.href = "./DoLogin";             //直接页面跳转
						//jq异步跳转，并不刷新本页面
						$.post('../../AdminController',{"username":username, "password":password, "a":"CheckLogin"},function(rst){
							if(rst == "success"){  //返回"success"，用户名和密码验证成功
								window.location.href="../../AdminController";//登录成功后回到（get)AdminController安排
								//index.jsp
							}else if(rst == "error"){ //返回"error",用户名和密码验证失败
								alert("用户名或密码错误！请重新输入！");
							}else{
								alert("deng");
							}
						});
					}else{
						alert("密码不能为空!");
					}
				}else{
					alert("用户名不能为空！");
				}
			}
	</script>
</head>
<body>
<h1>在线考试系统管理员登录</h1>
<input type="text" id="username"><br>
<input type="text" id="password"><br>
<input type="button" value="登录" onclick="checklogin()">
</body>
</html>