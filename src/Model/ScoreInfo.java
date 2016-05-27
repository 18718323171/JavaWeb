package Model;

import java.sql.Date;

public class ScoreInfo {       //成绩信息表
	public int Id;//编号
	public String StuNum;//学号
	public String StuName;//姓名
	public String PageNum;//试卷编号
	public String Subject;//科目
	public Date SubTime;//提交时间
	public int DelFlag;//删除标识
	public String State;//状态
	public String Remark;//备注
}
