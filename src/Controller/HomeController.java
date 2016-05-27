package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import Core.DBOper;
import Model.ExamInfo;
import Model.StuInfo;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// action 通过传递过来的不同a参数而取不同的值，当a为null时，赋值Index(默认进入)
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // 默认进入a==null
			// 通过判断session中是否存在该学号，不为空证明已经登录
			if (session.getAttribute("username") == null) {// session中该学号为空，跳转到学生登录页面
				response.sendRedirect("View/Home/login.html");
			} else {//session中该学号不为空，该学生已经登录，进入学生主页
				
				StuInfo s = new StuInfo();
				ExamInfo ei = new ExamInfo();
				
				try {
					ArrayList<ExamInfo> ExamArr = ei.getExamByStuNum(session.getAttribute("username").toString());//存储结果考试安排对象数组
					s = s.getStuInfoByStuNum(session.getAttribute("username").toString());//存储结果学生信息对象

					if (s != null) {
						request.setAttribute("StuInfo", s);
						request.setAttribute("ExamArr", ExamArr);
					}
				} catch (ParseException e) {
					// TODO 
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//请求转发
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/student.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("View/Home/index.html");//重定向
			}
		} else if (action.equals("CheckLogin")) {// 传递的参数a为"CheckLogin"，进行学生登录验证处理
			// 取得传递过来的学号和密码
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//验证登录信息是否正确 
			String rst = new StuInfo().CheckLogin(username, password);

			if (rst == "success") {// 验证成功
				session.setAttribute("username", username);//成功则将该登录学号存入session
				response.getWriter().print("success");
			} else {// 验证失败
				response.getWriter().print("error");
			}
		} else {//参数a的其它情况，等待完善

		}
	}
}
