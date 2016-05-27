package Model;

import java.lang.reflect.Array;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Core.DBOper;

public class StuInfo {    //学锟斤拷锟斤拷息锟斤拷
	public int Id;//锟斤拷锟�
	public String StuNum;//学锟斤拷
	public String StuPwd;//锟斤拷锟斤拷
	public String StuName;//锟斤拷锟斤拷
	public String Gender;//锟皆憋拷
	public String IdCard;//锟斤拷锟街わ拷锟�
	public String ClassNum;//锟洁级锟斤拷锟�
	public String ClassName;//锟洁级锟斤拷锟斤拷
	public Date SubTime;//注锟斤拷时锟斤拷
	public int DelFlag;//删锟斤拷锟斤拷识
	public String State;//状态
	public String Remark;//锟斤拷注
	
	//学号、密码验证学生登录信息
	public  String CheckLogin(String username, String password){
		String sql="select * from StuInfo where StuNum=? and StuPwd=? and DelFlag=0";
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
	
	//通过学号查询数据库表中的学生信息
	public StuInfo getStuInfoByStuNum(String stuNum) throws ParseException{
		StuInfo s = new StuInfo();
		
		String sql = "select * from StuInfo where DelFlag =0 and  StuNum =?";
		String[] params = {stuNum};
		
		DBOper db = new DBOper();
		ResultSet rst =  db.executeQuery(sql, params);
		
		try {
			if(rst.next()){
				//取出学号存储
				if(rst.getString(2) == null){
					s.StuNum="";
				}else{
					s.StuNum=rst.getString(2);
				}
				//取出姓名存储
				if(rst.getString(4) == null){
					s.StuName="";
				}else{
					s.StuName=rst.getString(4);
				}
				//取出性别存储
				if(rst.getString(5) == null){
					s.Gender="";
				}else{
					s.Gender=rst.getString(5);
				}
				//取出身份证存储
				if(rst.getString(6) == null){
					s.IdCard="";
				}else{
					s.IdCard=rst.getString(6);
				}
				//取出班级编号存储
				if(rst.getString(7) == null){
					s.ClassNum="";
				}else{
					s.ClassNum=rst.getString(7);
				}
				//取出班级名称存储
				if(rst.getString(8) == null){
					s.ClassName="";
				}else{
					s.ClassName=rst.getString(8);
				}
				//取出注册时间存储
				if(rst.getDate(9) == null){
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					s.SubTime=sdf.parse( sdf.format(date));
				}else{
					s.SubTime=rst.getDate(9);
				}
				
			}else{//查询结果没有记录
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	
	public ArrayList<StuInfo> getAllStuInfo(){
		ArrayList<StuInfo> list = new ArrayList<StuInfo>();
	
		String sql = "select * from StuInfo where DelFlag =0";
		
		//锟斤拷锟斤拷锟斤拷锟截碉拷锟斤拷锟斤拷
		for(int i = 0; i< 10; i++){
			StuInfo s = new StuInfo();
			list.add(s);
		}
		return list;
	}

}

