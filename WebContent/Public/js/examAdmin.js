function update(){                             //用户信息修改按钮事件
				//姓名
				updateTxtStyle($("#txtName"));
				//性别
				updateTxtStyle($("#txtGender"));
				//常用邮箱
				updateTxtStyle($("#txtEmail"));
				//联系电话
				updateTxtStyle($("#txtTel"));
			}
			function updateCancel(){                       //用户信息取消按钮事件
				var txtName =$("txtName");   
				if(txtName.attr("readonly") != "readonly"){   //如果readonly的值不为"readonly"则表示正处于												    修改状态
					//姓名
					updateCancelTxtStyle($("#txtName"));
					//性别
					updateCancelTxtStyle($("#txtGender"));
					//常用邮箱
					updateCancelTxtStyle($("#txtEmail"));
					//联系电话
					updateCancelTxtStyle($("#txtTel"));
				}
			}
			function updateCancelTxtStyle(param){     //用户信息取消按钮下级事件
				param.attr("readonly","readonly");
				param.css("border","none");
			}
			function updateTxtStyle(param){           //用户信息修改按钮下级事件
				param.css("border","solid 2px #006699");
				param.css("border-radius","10px");
				param.css("border-left","none");
				param.css("border-bottom","none");
				param.removeAttr("readonly");
			}
			function hiddenOp(param1){      //显隐操作
				//alert(param1);
				if(param1 == "updatePwd"){
					$("#"+param1).css("display", "");
					$("#testManage").css("display","none");
					$("#userInfo").css("display", "none");
					
				}else if(param1 == "userInfo"){
					$("#"+param1).css("display", "");
					$("#testManage").css("display","none");
					$("#updatePwd").css("display", "none");
				}else if(param1 == "testManage"){
					$("#"+param1).css("display", "");
					$("#userInfo").css("display","none");
					$("#updatePwd").css("display", "none");
				}
				ulShow();
			}
			function ulShow(){                //实现试题管理下拉框显隐功能
				//var testManage = $("#testManage");
				var ul = $("#ul-1");
				if($("#testManage").css("display") == "none"){
					ul.css("display","none");
				}else {
					ul.css("display","");
				}
			}

			function test_hiddenOp(param1){      //语文、英语、数学题框的显隐操作
				//alert(param1);
				if(param1 == "Chinese_test"){
					$("#"+param1).css("display", "");
					$("#English_test").css("display","none");
					$("#Math_test").css("display", "none");
					
				}else if(param1 == "English_test"){
					$("#"+param1).css("display", "");
					$("#Chinese_test").css("display","none");
					$("#Math_test").css("display", "none");
				}else if(param1 == "Math_test"){
					$("#"+param1).css("display", "");
					$("#Chinese_test").css("display","none");
					$("#English_test").css("display", "none");
				}
				ulShow();
			}
			$(function(){
				$("#Chinesetest_addBtn").click(function(){
					$(this).hide();
					$("#Chinesetest_addPane").show();
				});
				$("#Chinesetest_addCancel").click(function(){
					$("#Chinesetest_addBtn").show();
					$("#Chinesetest_addPane").hide();
				});
				$("#Mathtest_addBtn").click(function(){
					$(this).hide();
					$("#Mathtest_addPane").show();
				});
				$("#Mathtest_addCancel").click(function(){
					$("#Mathtest_addBtn").show();
					$("#Mathtest_addPane").hide();
				});
				$("#Englishtest_addBtn").click(function(){
					$(this).hide();
					$("#Englishtest_addPane").show();
				});
				$("#Englishtest_addCancel").click(function(){
					$("#Englishtest_addBtn").show();
					$("#Englishtest_addPane").hide();
				});
			});