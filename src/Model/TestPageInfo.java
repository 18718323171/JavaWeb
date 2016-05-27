package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Core.DBOper;

public class TestPageInfo {   //�Ծ���Ϣ��
	public int Id;//���
	public String PageNum;//�Ծ���
	public String Subject;//��Ŀ
	public String PageType;//�Ծ�����
	public String[] ChoicesIds;//ѡ�����
	public String[] JudgeIds;//�ж����
	public String[] CompletionIds;//������
	public String[] ShortQuestionIds;//������
	public String[] BigQuestionIds;//�������
	public int TotalScore;//�ܷ�
	public Date SubTime;//�ύʱ��
	public int DelFlag;//ɾ����ʶ
	public String State;//״̬
	public String Remark;//��
	
	//根据PageNum来查询试卷的题目信息
	public ArrayList<QAInfo> getPageInfoByPageNum4(String pageNum){
		
		String sql = "select ChoicesIds from testpageinfo where PageNum = ? ";
		String[] params={pageNum};
		DBOper db=new DBOper();
		ResultSet rst = db.executeQuery(sql, params);
		String ids1 = null;
		StuInfo s = new StuInfo();
		try {
			if(rst.next()){
				ids1 = rst.getString(1);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			//return null;
		}
		String[] ids2 = ids1.split(",");
		int[] ids3= new int[ids2.length];
		for(int i=0;i<ids2.length;i++){
			ids3[i] =Integer.parseInt( ids2[i]);
		}
		QAInfo qaInfo = new QAInfo();
		ArrayList<QAInfo> qaInfoArr = qaInfo.getQAInfoByChoicesId(ids3);
		return qaInfoArr;
		//String sql="select * from TestPageInfo as p, QAInfo as q where p.PageNum = PageNum and q.Id in(p.ChoicesIds)" ;
		
		
	}
}
