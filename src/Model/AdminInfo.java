package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Core.DBOper;

public class AdminInfo {    //管理员信息表
	public int Id;//编号
	public String AdminNum;//管理员编号
	public String AdminType;//管理员类型
	public String AdminPwd;//管理员密码
	public String AdminName;//管理员姓名
	public String Gender;//性别
	public int DelFlag;//删除标识
	public String State;//状态
	public String Remark;//备注
	
	//管理员编号、密码验证学生登录信息
	public  String CheckLogin(String username, String password){
			String sql="select * from AdminInfo where AdminNum=? and AdminPwd=? and DelFlag=0";
			String[] params={username,password};
			
			DBOper db=new DBOper();
			ResultSet rst = db.executeQuery(sql, params);
			
			try {
				if(rst.next()){   
					return "success";
				}else{
					return "error";  
				}
			} catch (SQLException e) {
				// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
				//e.printStackTrace();
				return "error";
			}
		}
	
	//通过管理员编号查询数据库表中的管理员信息并封装
		public AdminInfo getAdminfoByAdminNum(String AdminNum) throws ParseException{
			AdminInfo s = new AdminInfo();
			
			String sql = "select * from AdminInfo where DelFlag =0 and AdminNum =?";
			String[] params = {AdminNum};
			
			DBOper db = new DBOper();
			ResultSet rst =  db.executeQuery(sql, params);
			
			try {
				if(rst.next()){
					//取出编号存储
					if(rst.getString(2) == null){
						s.AdminNum="";
					}else{
						s.AdminNum=rst.getString(2);
					}
					//取出姓名存储
					if(rst.getString(5) == null){
						s.AdminName="";
					}else{
						s.AdminName=rst.getString(5);
					}
					//取出性别存储
					if(rst.getString(6) == null){
						s.Gender="";
					}else{
						s.Gender=rst.getString(6);
					}
					
				}else{//查询结果没有记录
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return s;
		}
		
		//修改密码
		public int updatePwd(String AdminNum,String newPwd){
			String sql = "update admininfo set AdminPwd=? where AdminNum=?";
			String[] params = {newPwd,AdminNum};
			
			DBOper db = new DBOper();
			int n =  db.executeUpdate(sql, params);
			return n;
		}
}
