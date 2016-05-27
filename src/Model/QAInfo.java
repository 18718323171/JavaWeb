package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Core.DBOper;

public class QAInfo {       //����
	public int Id;//���
	public String Subject;//��Ŀ
	public String QuestionType;//��Ŀ����
	public String Article;//��Ŀ����
	public String Question;//��Ŀ
	public String Answer;//��
	public String TrueAnswer;//��׼��
	public int Score;//��ֵ
	public Date SubTime;//�ύʱ��
	public int DelFlag;//ɾ����ʶ
	public String State;//״̬
	public String Remark;//��
	
	public ArrayList<QAInfo> getQAInfoByChoicesId(int[] choicesId){
		ArrayList<QAInfo> qaInfoArr = new ArrayList<QAInfo>();
		String p = "";
		if(choicesId.length > 0){
			p = "(";
			for(int i =0; i < choicesId.length; i ++){
				if(i != choicesId.length - 1){
					p += "?,";
				}else{
					p+="?";
				}
			}
			p+=")";
		}
		String sql = "select * from qainfo where id in"+p;
		//int[][] params = {choicesId};
		DBOper db=new DBOper();
		ResultSet rst = db.executeQuery3(sql,choicesId);
		try {
			while(rst.next()){//这个本本身就是遍历查询，不需要下面的那个for
				//for(int i=0;i<choicesId.length;i++){
					QAInfo qaInfo = new QAInfo();
					qaInfo.Subject = rst.getString(2);
					qaInfo.QuestionType = rst.getString(3);
					qaInfo.Question = rst.getString(5);
					qaInfo.Answer = rst.getString(6);
					qaInfo.TrueAnswer = rst.getString(7);
					qaInfo.Score = rst.getInt(8);
					qaInfoArr.add(qaInfo);
				//}
			}
		} catch (SQLException e) {
			System.out.println("QAInfo里的catch");
			e.printStackTrace();
			//return null;
		}
		return qaInfoArr;
	}
}
