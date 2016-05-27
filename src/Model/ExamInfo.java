package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Core.DBOper;

public class ExamInfo {       //������Ϣ��
	public int Id;//���
	public String ClassNum;//�༶���
	public String ClassName;//�༶����
	public String PageNum;//�Ծ���
	public String Subject;//��Ŀ
	public String PageType;//�Ծ�����
	public int TotalScore;//�ܷ�
	public int ExamTime;//����ʱ��
	public Date StartTime;//��ʼʱ��
	public Date EndTime;//����ʱ��
	public Date SubTime;//�ύʱ��
	public String SubNum;//�ύ��
	public int DelFlag;//ɾ����ʶ
	public String State;//״̬
	public String Remark;//��ע
	
	
	public ArrayList<ExamInfo> getExamByStuNum(String stuNum) throws SQLException{
		ArrayList<ExamInfo> ExamArr = new ArrayList<ExamInfo>();
		String sql = "select e.* from ExamInfo e,StuInfo s where s.ClassNum = 					 e.ClassNum and s.StuNum = ? and e.DelFlag = 0";
		String[] params={stuNum};
		DBOper db=new DBOper();
		ResultSet rst = db.executeQuery(sql, params);
		while(rst.next()){
			ExamInfo e = new ExamInfo();
			//班级名称
			if(rst.getString(3) == null){
				e.ClassName = "";
			}else{
				e.ClassName =rst.getString(3);
			}
			//试卷编号
			if(rst.getString(4) == null){
				e.PageNum = "";
			}else{
				e.PageNum =rst.getString(4);
			}
			//科目
			if(rst.getString(5) == null){
				e.Subject = "";
			}else{
				e.Subject =rst.getString(5);
			}
			//试卷类型
			if(rst.getString(6) == null){
				e.PageType = "";
			}else{
				e.PageType =rst.getString(6);
			}
			//分数
			e.TotalScore =rst.getInt(7);
			//考试时间
			e.ExamTime =rst.getInt(8);
			
			e.StartTime = rst.getDate(9);
			e.EndTime = rst.getDate(10);
			e.SubTime = rst.getDate(11);
				
			ExamArr.add(e);
		}
		
		return ExamArr;
	}
}
