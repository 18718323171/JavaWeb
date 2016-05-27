package Core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOper {
    Connection conn=null;   //锟斤拷锟捷匡拷锟斤拷锟斤拷
    PreparedStatement pstmt=null; //执锟斤拷锟斤拷锟捷匡拷锟斤拷锟�
    ResultSet rs=null;     //锟斤拷锟捷硷拷
    
    public DBOper(){
    	try {
			this.conn = this.getconn();    //锟节癸拷锟届函锟斤拷锟斤拷锟斤拷锟斤拷DBOper锟斤拷锟叫撅拷实锟斤拷锟斤拷锟捷匡拷锟斤拷锟斤拷
		} catch (ClassNotFoundException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		}
    }
    //锟斤拷锟斤拷锟斤拷锟捷库方锟斤拷
    public Connection getconn()throws ClassNotFoundException,InstantiationException,IllegalAccessException,SQLException
    {
        //System.out.println("锟斤拷锟斤拷锟斤拷锟捷匡拷晒锟�");
        String driver="com.mysql.jdbc.Driver";   //锟斤拷锟斤拷锟街凤拷锟斤拷
        //String url="jdbc:mysql://localhost:3306/examinationdb?user=root&password=yanjiabin00320&useUnicode=true&characterEncoding=gbk";//锟斤拷锟斤拷锟街凤拷锟斤拷
        String url="jdbc:mysql://localhost:3306/examinationdb?user=root&password=1234567890&useUnicode=true&characterEncoding=gbk";
        //"jdbc:mysql://localhost:3306/newdb?user=root&password=123456&useUnicode=true&characterEncoding=gbk"
        Class.forName(driver);    //锟斤拷锟斤拷JDBC锟斤拷锟斤拷
        //System.out.println("锟斤拷锟斤拷锟斤拷锟捷匡拷晒锟�");
        conn=DriverManager.getConnection(url);//锟斤拷锟斤拷锟斤拷锟捷匡拷
        //System.out.println("锟斤拷锟斤拷锟斤拷锟捷匡拷晒锟�");
        return conn;
    }
    //执锟斤拷锟斤拷锟捷匡拷锟窖拷姆锟斤拷锟斤拷锟斤拷锟斤拷亟锟斤拷锟斤拷
    public ResultSet executeQuery(String sql,String[] params)
    {
        try{
            pstmt=conn.prepareStatement(sql);//锟斤拷取PreparedStatement锟斤拷锟斤拷
            //锟斤拷锟斤拷PrepareStatement锟斤拷锟斤拷锟絪ql锟斤拷锟侥诧拷锟斤拷
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    pstmt.setString(i+1, params[i]);
                }
            }else{
            	System.out.println("params涓虹┖");
            }
            //执锟叫诧拷询锟斤拷锟斤拷锟截斤拷锟斤拷锟�
            rs=pstmt.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public ResultSet executeQuery3(String sql,int[] params)
    {
        try{
            pstmt=conn.prepareStatement(sql);//锟斤拷取PreparedStatement锟斤拷锟斤拷
            //锟斤拷锟斤拷PrepareStatement锟斤拷锟斤拷锟絪ql锟斤拷锟侥诧拷锟斤拷
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    pstmt.setInt(i+1, params[i]);
                }
            }else{
            	System.out.println("params涓虹┖");
            }
            //执锟叫诧拷询锟斤拷锟斤拷锟截斤拷锟斤拷锟�
            rs=pstmt.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public ResultSet executeQuery2(String sql,int[][] params)
    {
        try{
            pstmt=conn.prepareStatement(sql);//锟斤拷取PreparedStatement锟斤拷锟斤拷
            //锟斤拷锟斤拷PrepareStatement锟斤拷锟斤拷锟絪ql锟斤拷锟侥诧拷锟斤拷
            if(params!=null){
                for(int i=0;i<params.length;i++){
//                	pstmt.setInt(i+1,params[i]);
//                	System.out.println("params鐨勯暱搴︼細"+params.length);
//                	System.out.println("***杩欓噷鏄疍BOper閲岀殑params鏁版嵁:"+params[i]);
                    for(int j=0;j<params[i].length;j++){
                    	pstmt.setInt(j+1,params[i][j]);
                    	//System.out.println("params鐨勯暱搴︼細"+params[0].length);
                    	System.out.println("***杩欓噷鏄疍BOper閲岀殑params鏁版嵁:"+params[i][j]);
                    }
                }
            }else{
            	System.out.println("params涓虹┖");
            }
            //执锟叫诧拷询锟斤拷锟斤拷锟截斤拷锟斤拷锟�
            rs=pstmt.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    //执锟斤拷锟斤拷锟捷匡拷锟斤拷拢锟斤拷锟斤拷锟缴撅拷锟斤拷模锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街达拷锟斤拷锟斤拷锟�
    public int executeUpdate(String sql, String[] params)
    {
        int n=0;
        try{
            pstmt=conn.prepareStatement(sql);//锟斤拷取PreparedStatement锟斤拷锟斤拷
            //锟斤拷锟斤拷PrepareStatement锟斤拷锟斤拷锟絪ql锟斤拷锟侥诧拷锟斤拷
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    pstmt.setString(i+1, params[i]);
                }
            }
            //执锟叫诧拷询锟斤拷锟斤拷锟截斤拷锟斤拷锟�
            n=pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return n;
    }
    //锟截闭讹拷锟斤拷锟酵凤拷锟斤拷源锟斤拷锟斤拷
    public void closeAll()
    {
        //锟截憋拷锟斤拷锟捷硷拷
        if(rs!=null){       
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //锟截憋拷Statement
        if(pstmt!=null){      
            try{
                pstmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //锟截憋拷锟斤拷锟捷匡拷锟斤拷锟斤拷
        if(conn!=null){      
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}