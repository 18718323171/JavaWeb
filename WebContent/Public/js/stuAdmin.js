function update(){                             //用户信息修改按钮事件
				//姓名
				updateTxtStyle($("#txtName"));
				//性别
				updateTxtStyle($("#txtGender"));
				//常用邮箱
				//updateTxtStyle($("#txtEmail"));
				//联系电话
				//updateTxtStyle($("#txtTel"));
			}
			function updateCancel(){                       //用户信息取消按钮事件
				var txtName =$("txtName");   
				if(txtName.attr("readonly") != "readonly"){   //如果readonly的值不为"readonly"则表示正处于												    修改状态
					//姓名
					updateCancelTxtStyle($("#txtName"));
					//性别
					updateCancelTxtStyle($("#txtGender"));
					//常用邮箱
					//updateCancelTxtStyle($("#txtEmail"));
					//联系电话
					//updateCancelTxtStyle($("#txtTel"));
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
					$("#stuInfo").css("display","none");
					$("#userInfo").css("display", "none");
					
				}else if(param1 == "userInfo"){
					$("#"+param1).css("display", "");
					$("#stuInfo").css("display","none");
					$("#updatePwd").css("display", "none");
				}else if(param1 == "stuInfo"){
					$("#"+param1).css("display", "");
					$("#userInfo").css("display","none");
					$("#updatePwd").css("display", "none");
				}
				ulShow();
			}
			function ulShow(){                //实现试题管理下拉框显隐功能
				//var stuInfo = $("#stuInfo");
				var ul = $("#ul-1");
				if($("#stuInfo").css("display") == "none"){
					ul.css("display","none");
				}else {
					ul.css("display","");
				}
			}

			function hiddenOp2(param1){      //语文、英语、数学题框的显隐操作
				//alert(param1);
				if(param1 == "querydiv"){
					$("#"+param1).css("display", "");
					$("#insertdiv").css("display","none");
					
				}else if(param1 == "insertdiv"){
					$("#"+param1).css("display", "");
					$("#querydiv").css("display","none");
				}
				ulShow();
			}