package Model;

import java.lang.reflect.Array;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Core.DBOper;

public class StuInfo {    //ѧ����Ϣ��
	public int Id;//���
	public String StuNum;//ѧ��
	public String StuPwd;//����
	public String StuName;//����
	public String Gender;//�Ա�
	public String IdCard;//���֤��
	public String ClassNum;//�༶���
	public String ClassName;//�༶����
	public Date SubTime;//ע��ʱ��
	public int DelFlag;//ɾ����ʶ
	public String State;//״̬
	public String Remark;//��ע
	
	private DBOper db;
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
			// TODO �Զ����ɵ� catch ��
			//e.printStackTrace();
			return "error";
		}
	}
	
	//����ѧ�Ų�ѯѧ����Ϣ��
	public StuInfo getStuInfoByStuNum(String stuNum) throws ParseException{
		StuInfo s = new StuInfo();
		
		String sql = "select * from StuInfo where DelFlag =0 and  StuNum =?";
		String[] params = {stuNum};
		
		DBOper db = new DBOper();
		ResultSet rst =  db.executeQuery(sql, params);
		
		try {
			if(rst.next()){
				//ȡ��ѧ������
				if(rst.getString(2) == null){
					s.StuNum="";
				}else{
					s.StuNum=rst.getString(2);
				}
				//ȡ����������
				if(rst.getString(4) == null){
					s.StuName="";
				}else{
					s.StuName=rst.getString(4);
				}
				//ȡ���Ա�����
				if(rst.getString(5) == null){
					s.Gender="";
				}else{
					s.Gender=rst.getString(5);
				}
				//ȡ�����֤����
				if(rst.getString(6) == null){
					s.IdCard="";
				}else{
					s.IdCard=rst.getString(6);
				}
				//ȡ���༶�������
				if(rst.getString(7) == null){
					s.ClassNum="";
				}else{
					s.ClassNum=rst.getString(7);
				}
				//ȡ���༶����
				if(rst.getString(8) == null){
					s.ClassName="";
				}else{
					s.ClassName=rst.getString(8);
				}
				//ȡ��ע��ʱ������
				if(rst.getDate(9) == null){
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					s.SubTime=sdf.parse( sdf.format(date));//��ϵͳ��ǰʱ�丳ֵ
				}else{
					s.SubTime=rst.getDate(9);
				}
				
			}else{
				
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return s;
	}
	
	
	public ArrayList<StuInfo> getAllStuInfo(){
		ArrayList<StuInfo> list = new ArrayList<StuInfo>();
	
		String sql = "select * from StuInfo where DelFlag =0";
		
		//�������ص�����
		for(int i = 0; i< 10; i++){
			StuInfo s = new StuInfo();
			list.add(s);
		}
		return list;
	}

}

