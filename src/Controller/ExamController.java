package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.QAInfo;
import Model.StuInfo;
import Model.TestPageInfo;

/**
 * Servlet implementation class goExamController
 */
@WebServlet("/goExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExamController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession hs = request.getSession();
		if (action.equals("Index")) {
			// HomeController?a=getPageInfo
		} else if (action.equals("getPageInfo")) {
			System.out.println("我进来了");
			String stuName = request.getParameter("stuName");
			String className = request.getParameter("className");
			String pageNum = request.getParameter("pageNum");
			String pageType = request.getParameter("pageType");
			String subject = request.getParameter("subject");
			String totalScore = request.getParameter("totalScore");
			String examTime = request.getParameter("examTime");
			System.out.println("totalScore" + totalScore);

			request.setAttribute("stuName", stuName);
			request.setAttribute("className", className);
			request.setAttribute("pageType", pageType);
			request.setAttribute("subject", subject);
			request.setAttribute("totalScore", totalScore);
			request.setAttribute("examTime", examTime);

			TestPageInfo tpi = new TestPageInfo();
			ArrayList<QAInfo> qaInfoArr = tpi.getPageInfoByPageNum4(pageNum);
			request.setAttribute("qaInfoArr", qaInfoArr);
			request.getRequestDispatcher("View/Home/OnlineExam.jsp").forward(request, response);
		} else {
			System.out.println("123");
		}

	}

}
