package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Core.DBOper;

public class ExamInfo {       //锟斤拷锟斤拷锟斤拷息锟斤拷
	public int Id;//锟斤拷锟�
	public String ClassNum;//锟洁级锟斤拷锟�
	public String ClassName;//锟洁级锟斤拷锟斤拷
	public String PageNum;//锟皆撅拷锟斤拷
	public String Subject;//锟斤拷目
	public String PageType;//锟皆撅拷锟斤拷锟斤拷
	public int TotalScore;//锟杰凤拷
	public int ExamTime;//锟斤拷锟斤拷时锟斤拷
	public Date StartTime;//锟斤拷始时锟斤拷
	public Date EndTime;//锟斤拷锟斤拷时锟斤拷
	public Date SubTime;//锟结交时锟斤拷
	public String SubNum;//锟结交锟斤拷
	public int DelFlag;//删锟斤拷锟斤拷识
	public String State;//状态
	public String Remark;//锟斤拷注
	
	//通过学号查询数据库考试表中该生所在班级安排要考的试
	public ArrayList<ExamInfo> getExamByStuNum(String stuNum) throws SQLException{
		ArrayList<ExamInfo> ExamArr = new ArrayList<ExamInfo>();
		
		String sql = "select e.* from ExamInfo e,StuInfo s where s.ClassNum = e.ClassNum and s.StuNum = ? and e.DelFlag = 0";
		String[] params={stuNum};
		
		DBOper db=new DBOper();
		ResultSet rst = db.executeQuery(sql, params);
		
		while(rst.next()){
			ExamInfo e = new ExamInfo();
			//取出班级名称存储
			if(rst.getString(3) == null){
				e.ClassName = "";
			}else{
				e.ClassName =rst.getString(3);
			}
			//取出试卷编号存储
			if(rst.getString(4) == null){
				e.PageNum = "";
			}else{
				e.PageNum =rst.getString(4);
			}
			//取出科目存储
			if(rst.getString(5) == null){
				e.Subject = "";
			}else{
				e.Subject =rst.getString(5);
			}
			//取出试卷类型存储
			if(rst.getString(6) == null){
				e.PageType = "";
			}else{
				e.PageType =rst.getString(6);
			}
			//取出总分存储
			e.TotalScore =rst.getInt(7);
			//取出考试时间存储
			e.ExamTime =rst.getInt(8);
				
			ExamArr.add(e);//将第一个安排的考试对象封装进数组里面
		}
		
		return ExamArr;
	}
	
	//查询所有已经安排的考试
	public ArrayList<ExamInfo> getAllExam() throws SQLException{
		ArrayList<ExamInfo> ExamArr = new ArrayList<ExamInfo>();
		
		String sql = "select * from ExamInfo ";
		String[] params={};
		
		DBOper db=new DBOper();
		ResultSet rst = db.executeQuery(sql, params);
		
		while(rst.next()){
			ExamInfo e = new ExamInfo();
			
			//取出班级编号存储
			if(rst.getString(2) == null){
				e.ClassNum = "";
			}else{
				e.ClassNum =rst.getString(2);
			}
			//取出班级名称存储
			if(rst.getString(3) == null){
				e.ClassName = "";
			}else{
				e.ClassName =rst.getString(3);
			}
			//取出试卷编号存储
			if(rst.getString(4) == null){
				e.PageNum = "";
			}else{
				e.PageNum =rst.getString(4);
			}
			//取出科目存储
			if(rst.getString(5) == null){
				e.Subject = "";
			}else{
				e.Subject =rst.getString(5);
			}
			//取出试卷类型存储
			if(rst.getString(6) == null){
				e.PageType = "";
			}else{
				e.PageType =rst.getString(6);
			}
			//取出总分存储
			e.TotalScore =rst.getInt(7);
			//取出考试时间存储
			e.ExamTime =rst.getInt(8);
				
			ExamArr.add(e);//将第一个安排的考试对象封装进数组里面
		}
		return ExamArr;
	}
}
