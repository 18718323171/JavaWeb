package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Core.DBOper;

public class AdminInfo {    //����Ա��Ϣ��
	public int Id;//���
	public String AdminNum;//����Ա���
	public String AdminType;//����Ա����
	public String AdminPwd;//����Ա����
	public String AdminName;//����Ա����
	public String Gender;//�Ա�
	public int DelFlag;//ɾ����ʶ
	public String State;//״̬
	public String Remark;//��ע
	
	//����Ա��š�������֤ѧ����¼��Ϣ
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
				// TODO �Զ����ɵ� catch ��
				//e.printStackTrace();
				return "error";
			}
		}
	
	//ͨ������Ա��Ų�ѯ���ݿ���еĹ���Ա��Ϣ����װ
		public AdminInfo getAdminfoByAdminNum(String AdminNum) throws ParseException{
			AdminInfo s = new AdminInfo();
			
			String sql = "select * from AdminInfo where DelFlag =0 and AdminNum =?";
			String[] params = {AdminNum};
			
			DBOper db = new DBOper();
			ResultSet rst =  db.executeQuery(sql, params);
			
			try {
				if(rst.next()){
					//ȡ����Ŵ洢
					if(rst.getString(2) == null){
						s.AdminNum="";
					}else{
						s.AdminNum=rst.getString(2);
					}
					//ȡ�������洢
					if(rst.getString(5) == null){
						s.AdminName="";
					}else{
						s.AdminName=rst.getString(5);
					}
					//ȡ���Ա�洢
					if(rst.getString(6) == null){
						s.Gender="";
					}else{
						s.Gender=rst.getString(6);
					}
					
				}else{//��ѯ���û�м�¼
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return s;
		}
		
		//�޸�����
		public int updatePwd(String AdminNum,String newPwd){
			String sql = "update admininfo set AdminPwd=? where AdminNum=?";
			String[] params = {newPwd,AdminNum};
			
			DBOper db = new DBOper();
			int n =  db.executeUpdate(sql, params);
			return n;
		}
}
