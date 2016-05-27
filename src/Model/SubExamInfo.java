package Model;

import java.sql.Date;

public class SubExamInfo {       //考生答卷信息表
	public int Id;//编号
	public String StuNum;//学号
	public String PageNum;//试卷编号
	public String Subject;//科目
	public String PageType;//试卷类型
	
	public String[] ChoicesIds;//选择题答案
	public String[] JudgeIds;//判断题答案
	public String[] CompletionIds;//填空题答案
	public String[] ShortQuestionIds;//简答题答案
	public String[] BigQuestionIds;//大题题答案
	
	public Date SubTime;//提交时间
	public int DelFlag;//删除标识
	public String State;//状态
	public String Remark;//备注
}
