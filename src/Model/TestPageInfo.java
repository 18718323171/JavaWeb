package Model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Core.DBOper;

public class TestPageInfo {   //锟皆撅拷锟斤拷息锟斤拷
	public int Id;//锟斤拷锟�
	public String PageNum;//锟皆撅拷锟斤拷
	public String Subject;//锟斤拷目
	public String PageType;//锟皆撅拷锟斤拷锟斤拷
	public String[] ChoicesIds;//选锟斤拷锟斤拷锟�
	public String[] JudgeIds;//锟叫讹拷锟斤拷锟�
	public String[] CompletionIds;//锟斤拷锟斤拷锟斤拷
	public String[] ShortQuestionIds;//锟斤拷锟斤拷锟斤拷
	public String[] BigQuestionIds;//锟斤拷锟斤拷锟斤拷锟�
	public int TotalScore;//锟杰凤拷
	public Date SubTime;//锟结交时锟斤拷
	public int DelFlag;//删锟斤拷锟斤拷识
	public String State;//状态
	public String Remark;//锟斤拷
	
	//通过试卷编号查询试卷的试题内容
	public ArrayList<QAInfo> getPageInfoByPageNum4(String pageNum){
		//取得这张试卷的选择题编号ChoicesIds
		String sql = "select ChoicesIds from testpageinfo where PageNum = ? ";
		String[] params={pageNum};
		
		DBOper db=new DBOper();
		ResultSet rst = db.executeQuery(sql, params);
		
		String ids1 = null;
		StuInfo s = new StuInfo();
		
		try {
			if(rst.next()){
				ids1 = rst.getString(1);//取得这张试卷的选择题编号集合
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//return null;
		}
		String[] ids2 = ids1.split(",");//通过逗号分隔符分离每个选择题编号存入字符串数组
		int[] ids3= new int[ids2.length];//创建一个与上面字符串数组长度相同的的int类型数组
		//将字符串数组中的每个元素转为int类型再存入int数组
		for(int i=0;i<ids2.length;i++){
			ids3[i] =Integer.parseInt( ids2[i]);
		}
		
		QAInfo qaInfo = new QAInfo();
		ArrayList<QAInfo> qaInfoArr = qaInfo.getQAInfoByChoicesId(ids3);
		
		return qaInfoArr;//返回题目数组
		//String sql="select * from TestPageInfo as p, QAInfo as q where p.PageNum = PageNum and q.Id in(p.ChoicesIds)" ;

	}
}
