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

<<<<<<< HEAD
=======
import org.apache.catalina.Session;

>>>>>>> 65abe11d5afa90d8d1c97a6d235100bb289034f3
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
<<<<<<< HEAD
		// action ͨ�����ݹ����Ĳ�ͬa������ȡ��ͬ��ֵ����aΪnullʱ����ֵIndex(Ĭ�Ͻ���)
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // Ĭ�Ͻ���a==null
			// ͨ���ж�session���Ƿ���ڸ�ѧ�ţ���Ϊ��֤���Ѿ���¼
			if (session.getAttribute("username") == null) {// session�и�ѧ��Ϊ�գ���ת��ѧ����¼ҳ��
				response.sendRedirect("View/Home/login.html");
			} else {//session�и�ѧ�Ų�Ϊ�գ���ѧ���Ѿ���¼������ѧ����ҳ
				
				StuInfo s = new StuInfo();
				ExamInfo ei = new ExamInfo();
				
				try {
					ArrayList<ExamInfo> ExamArr = ei.getExamByStuNum(session.getAttribute("username").toString());//�洢������԰��Ŷ�������
					s = s.getStuInfoByStuNum(session.getAttribute("username").toString());//�洢���ѧ����Ϣ����
=======
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
>>>>>>> 65abe11d5afa90d8d1c97a6d235100bb289034f3

					if (s != null) {
						request.setAttribute("StuInfo", s);
						request.setAttribute("ExamArr", ExamArr);
<<<<<<< HEAD
					}
				} catch (ParseException e) {
					// TODO 
=======
						//System.out.print(s.StuName);
					}
				} catch (ParseException e) {
					// TODO �Զ����ɵ� catch ��
>>>>>>> 65abe11d5afa90d8d1c97a6d235100bb289034f3
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
<<<<<<< HEAD
				//����ת��
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/student.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("View/Home/index.html");//�ض���
			}
		} else if (action.equals("CheckLogin")) {// ���ݵĲ���aΪ"CheckLogin"������ѧ����¼��֤����
			// ȡ�ô��ݹ�����ѧ�ź�����
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//��֤��¼��Ϣ�Ƿ���ȷ 
			String rst = new StuInfo().CheckLogin(username, password);

			if (rst == "success") {// ��֤�ɹ�
				session.setAttribute("username", username);//�ɹ��򽫸õ�¼ѧ�Ŵ���session
				response.getWriter().print("success");
			} else {// ��֤ʧ��
				response.getWriter().print("error");
			}
		} else {//����a������������ȴ�����
=======
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
>>>>>>> 65abe11d5afa90d8d1c97a6d235100bb289034f3

		}
	}
}
