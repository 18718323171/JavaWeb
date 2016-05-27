package Model;

import java.sql.Date;

public class ExecuteInfo {       //操作日志
	public int Id;//编号
	public String AdminNum;//管理员编号
	public String AdminName;//管理员姓名
	public String ExecuteDescription;//操作详情
	public Date SubTime;//删除标识
	public String Remark;//备注
}
