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
		// action Í¨¹ý´«µÝ¹ýÀ´µÄ²»Í¬a²ÎÊý¶øÈ¡²»Í¬µÄÖµ£¬µ±aÎªnullÊ±£¬¸³ÖµIndex(Ä¬ÈÏ½øÈë)
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // Ä¬ÈÏ½øÈëa==null
			// Í¨¹ýÅÐ¶ÏsessionÖÐÊÇ·ñ´æÔÚ¸ÃÑ§ºÅ£¬²»Îª¿ÕÖ¤Ã÷ÒÑ¾­µÇÂ¼
			if (session.getAttribute("username") == null) {// sessionÖÐ¸ÃÑ§ºÅÎª¿Õ£¬Ìø×ªµ½Ñ§ÉúµÇÂ¼Ò³Ãæ
				response.sendRedirect("View/Home/login.html");
			} else {//sessionÖÐ¸ÃÑ§ºÅ²»Îª¿Õ£¬¸ÃÑ§ÉúÒÑ¾­µÇÂ¼£¬½øÈëÑ§ÉúÖ÷Ò³
				
				StuInfo s = new StuInfo();
				ExamInfo ei = new ExamInfo();
				
				try {
					ArrayList<ExamInfo> ExamArr = ei.getExamByStuNum(session.getAttribute("username").toString());//´æ´¢½á¹û¿¼ÊÔ°²ÅÅ¶ÔÏóÊý×é
					s = s.getStuInfoByStuNum(session.getAttribute("username").toString());//´æ´¢½á¹ûÑ§ÉúÐÅÏ¢¶ÔÏó
=======
		// ï¿½á½»ï¿½ï¿½postï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ë£¨ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½aï¿½ï¿½
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // Ä¬ï¿½Ï½ï¿½ï¿½ï¿½,a==null
			// ï¿½ï¿½ï¿½ï¿½Ç·ï¿½ï¿½Â¼ï¿½É¹ï¿½ï¿½ï¿½sessionï¿½ï¿½ï¿½Ç·ï¿½ï¿½ï¿½usernameï¿½Ö¶Î£ï¿½
			if (session.getAttribute("username") == null) {// sessionï¿½ï¿½usernameï¿½Ö¶ï¿½Îªï¿½Õ±ï¿½Ê¾Î´ï¿½ï¿½Â¼
															// ï¿½ï¿½ï¿½Øµï¿½ï¿½ï¿½Â¼Ò³ï¿½ï¿½
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
					// TODO ï¿½Ô¶ï¿½ï¿½ï¿½ï¿½Éµï¿½ catch ï¿½ï¿½
>>>>>>> 65abe11d5afa90d8d1c97a6d235100bb289034f3
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
<<<<<<< HEAD
				//ÇëÇó×ª·¢
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/student.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("View/Home/index.html");//ÖØ¶¨Ïò
			}
		} else if (action.equals("CheckLogin")) {// ´«µÝµÄ²ÎÊýaÎª"CheckLogin"£¬½øÐÐÑ§ÉúµÇÂ¼ÑéÖ¤´¦Àí
			// È¡µÃ´«µÝ¹ýÀ´µÄÑ§ºÅºÍÃÜÂë
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//ÑéÖ¤µÇÂ¼ÐÅÏ¢ÊÇ·ñÕýÈ· 
			String rst = new StuInfo().CheckLogin(username, password);

			if (rst == "success") {// ÑéÖ¤³É¹¦
				session.setAttribute("username", username);//³É¹¦Ôò½«¸ÃµÇÂ¼Ñ§ºÅ´æÈësession
				response.getWriter().print("success");
			} else {// ÑéÖ¤Ê§°Ü
				response.getWriter().print("error");
			}
		} else {//²ÎÊýaµÄÆäËüÇé¿ö£¬µÈ´ýÍêÉÆ
=======
				// ï¿½ï¿½×ªï¿½ï¿½Ñ§ï¿½ï¿½ï¿½ï¿½Ò³
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/student.jsp");
				dispatcher.forward(request, response);
				
				
				//response.sendRedirect("View/Home/index.html");
			}
		} else if (action.equals("CheckLogin")) {// ï¿½ï¿½ï¿½ï¿½aÎª"CheckLogin"ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Çµï¿½Â¼Ò³ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
			// ï¿½ï¿½ï¿½ï¿½Ñ§ï¿½ï¿½ï¿½ï¿½Â¼Ò³ï¿½æ´«ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Öµ
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// Ö´ï¿½Ð²ï¿½Ñ¯ï¿½ï¿½ï¿½Ý¿ï¿½
			String rst = new StuInfo().CheckLogin(username, password);

			if (rst == "success") {// ï¿½ï¿½Â¼ï¿½ï¿½Ï¢ï¿½ï¿½È·
				session.setAttribute("username", username);
				response.getWriter().print("success");
			} else {// ï¿½ï¿½Â¼ï¿½ï¿½Ï¢ï¿½ï¿½ï¿½ï¿½
				response.getWriter().print("error");
			}
		} else {
>>>>>>> 65abe11d5afa90d8d1c97a6d235100bb289034f3

		}
	}
}
