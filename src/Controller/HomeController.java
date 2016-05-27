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

import org.apache.catalina.Session;

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
		// �ύ��post�������루������a��
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // Ĭ�Ͻ���,a==null
			// ����Ƿ��¼�ɹ���session���Ƿ���username�ֶΣ�
			if (session.getAttribute("username") == null) {// session��username�ֶ�Ϊ�ձ�ʾδ��¼
															// ���ص���¼ҳ��
				response.sendRedirect("View/Home/login.html");
			} else {
				StuInfo s = new StuInfo();
				ExamInfo ei = new ExamInfo();
				try {
					ArrayList<ExamInfo> ExamArr = ei.getExamByStuNum(session.getAttribute("username").toString());
					s = s.getStuInfoByStuNum(session.getAttribute("username").toString());

					if (s != null) {
						request.setAttribute("StuInfo", s);
						request.setAttribute("ExamArr", ExamArr);
						//System.out.print(s.StuName);
					}
				} catch (ParseException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ��ת��ѧ����ҳ
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/student.jsp");
				dispatcher.forward(request, response);
				
				
				//response.sendRedirect("View/Home/index.html");
			}
		} else if (action.equals("CheckLogin")) {// ����aΪ"CheckLogin"�������ǵ�¼ҳ������
			// ����ѧ����¼ҳ�洫������ֵ
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// ִ�в�ѯ���ݿ�
			String rst = new StuInfo().CheckLogin(username, password);

			if (rst == "success") {// ��¼��Ϣ��ȷ
				session.setAttribute("username", username);
				response.getWriter().print("success");
			} else {// ��¼��Ϣ����
				response.getWriter().print("error");
			}
		} else {

		}
	}
}
