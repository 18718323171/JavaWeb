<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
	<link href="../../Public/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="../../Public/css/examAdmin.css" rel="stylesheet" type="text/css">	
<title>考生管理员界面</title>
</head>
<body>
	<!--背景图片开始-->
	<div>
		<image src="../../Public/images/header6.jpg" width="100%" height="140px">
	</div>
	<!--背景图片结束-->
	
	<!--顶栏开始-->
	<div class="Head bg-primary">
		用户编号:<span></span>&nbsp;&nbsp;姓名:<span></span><span
			class="exit"><span><a href="#" style="color: white">注销</a></span>&nbsp;<span><a
				href="#" style="color: white">退出</a></span></span>
	</div>
	<!--顶栏结束-->
	<!-- 主体内容开始 -->
	<div class="main">
		<!--左右栏框分布源码开始-->
		<!--左栏框开始-->
		<span class="main-left" id="div_left"> <!--左栏内容开始-->
			<div class="left-style text">
				<a href="#" onclick="hiddenOp('userInfo')">用户信息</a>
			</div>
			<div class="left-style text" ><a href="javascript:void(0)" onclick="hiddenOp('stuInfo')">考生信息</a></div>
								<ul style="display:none;" id="ul-1">
								<li><a href="javascript:void(0)" onclick="hiddenOp2('querydiv')">查询</a></li>
								<li><a href="javascript:void(0)" onclick="hiddenOp2('insertdiv')">添加</a></li>
								<!-- <li><a href="javascript:void(0)" onclick="test_hiddenOp('Math_test')"></a></li> -->
								</ul>
			<div class="left-style text">
				<a href="#" id="b01" onclick="hiddenOp('updatePwd')">修改密码</a>
			</div> <!--左栏内容结束-->
		</span>
		<!--左栏框结束-->
		
		<!--右栏框开始-->
					<span class="main-right" id="main_content_right" id="div_right">
						<!--右栏内容边框开始-->
							<!--用户信息开始-->
								<div class="right-style" id="userInfo">
									<h2 style="text-align:center;">用户信息</h2><hr style="border:solid 1px #666666">
									<div class="right-info-style"><span>编号：<input type="text" id="txtNum" readonly="readonly" value="007" style="border:none;"></span></div>
									<div class="right-info-style"><span>姓名：<input type="text" id="txtName" readonly="readonly" value="张三" style="border:none;"></span></div>
									<div class="right-info-style"><span>性别：<input type="text" id="txtGender" readonly="readonly" value="男" style="border:none;"></span></div>
									<!-- <div class="right-info-style"><span>联系电话：<input type="text" id="txtTel" readonly="readonly" value="13876543210" style="border:none;"></span></div> -->
									<!-- <div class="right-info-style"><span>常用邮箱：<input type="text" id="txtEmail" readonly="readonly" value="1091313628@qq.com" style="border:none;"></span></div> -->
									<div class="right-info-style"><span>最近登录IP：<input type="text" id="txtIP" readonly="readonly" value="192.1.3.4" style="border:none;"></span></div>
									<div class="right-info-style"><span>最近登录时间：<input type="text" id="txtTime" readonly="readonly" value="2016/5/5 22:22:22" style="border:none;"></span></div>
									<div style="text-align:center;margin-top:6%;"><input type="button" style="width:20%;" value="修改" onclick="update()"><input type="button" style="width:20%;" value="取消" onclick="updateCancel()"></div>
								</div>
								<!--用户信息结束-->
								<!--考生信息开始-->
								<div class="right-style" id="stuInfo" style="display:none;">
									<!-- 查询开始 -->
									<div id="querydiv" >
										<h2 style="text-align:center;">考生信息查询</h2><hr style="border:solid 1px #666666">
										<div>
											学号：<input type="text" />&nbsp;&nbsp;或&nbsp;姓名:<input type="text" /> <input type="button" style="float: right;" value="查询"/>
										</div>
									</div>
									<!-- 查询结束 -->
									<!-- 修改开始 -->
									<div id="insertdiv" style="display:none;">
										<h2 style="text-align:center;">考生信息添加</h2><hr style="border:solid 1px #666666">
										<div>
											学号:<input type="text" >&nbsp;&nbsp;姓名:<input type="text" >&nbsp;&nbsp;班级:<input type="text" ><input type="button" style="float: right;" value="添加"/>
										</div>
									</div>
									<!-- 修改结束 -->
								<!-- 考生信息结束 -->
								</div>
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
	</div>
	<!-- 主体内容结束 -->
	<!--底栏开始-->
		<div style="text-align:center;float:none;margin:10px;">@官方声明</div>
		<!--底栏结束-->
		<script type="text/javascript" src="../../Public/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="../../Public/js/stuAdmin.js"></script>
		<script src="../../Public/js/bootstrap.min.js"></script>
</body>
</html>