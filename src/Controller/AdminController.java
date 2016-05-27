package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AdminInfo;
import Model.ExamInfo;
import Model.StuInfo;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// action 通过传递过来的不同a参数而取不同的值，当a为null时，赋值Index(默认进入)
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // 默认进入，a==null
			// 通过判断session中是否存在该管理员编号，不为空证明已经登录
			if (session.getAttribute("AdminNum") == null) {// session中该学号为空，跳转到学生登录页面
				response.sendRedirect("View/Home/AdminLogin.html");//重定向
			} else {//session中该学号不为空，该学生已经登录，进入学生主页
				AdminInfo s = new AdminInfo();
				ExamInfo ei = new ExamInfo();
				
				try {
					//查询所有安排的考试存储
					ArrayList<ExamInfo> ExamArr = ei.getAllExam();//存储结果考试安排对象数组
					//查询管理员信息存储
					s = s.getAdminfoByAdminNum(session.getAttribute("AdminNum").toString());//存储结果管理员信息对象
					if (s != null) {
						request.setAttribute("AdminInfo", s);
						request.setAttribute("ExamArr", ExamArr);
					}
				} catch (ParseException e) {
					// TODO 
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				//请求转发
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/Admin.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("View/Home/index.html");//重定向
			}
		} else if (action.equals("CheckLogin")) {// 传递的参数a为"CheckLogin"，进行学生登录验证处理
			// 取得传递过来的学号和密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//验证登录信息是否正确 
			String rst = new AdminInfo().CheckLogin(username, password);

			if (rst == "success") {// 验证成功
				session.setAttribute("AdminNum", username);//成功则将该登录学号存入session
				response.getWriter().print("success");
			} else {// 验证失败
				response.getWriter().print("error");
			}
		} else if(action.equals("UpdatePwd")){  //参数a为"UpdatePwd"，进行管理员密码修改
			if (session.getAttribute("AdminNum") == null) {
				response.sendRedirect("View/Home/AdminLogin.html");
			}else{
				String adminNum=(String) session.getAttribute("AdminNum");
				// 取得传递过来的旧密码和新密码
				String oldPwd = request.getParameter("oldPwd");
				String newPwd = request.getParameter("newPwd");
				
				String msg=new AdminInfo().CheckLogin(adminNum,oldPwd);//验证旧密码是否正确
				if(msg=="success"){//旧密码正确 ，更新新密码
					int n=new AdminInfo().updatePwd(adminNum, newPwd);//执行更新
					if(n>0){//更新成功
						response.getWriter().print("success");
					}else{//更新失败
						response.getWriter().print("wrong");
					}
				}else{//旧密码不正确
					response.getWriter().print("error");
				}
			}
		}else{//参数a的其它情况，等待完善
			
		}
	}
	

}
