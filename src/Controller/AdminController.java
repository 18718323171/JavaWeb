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
		// action ͨ�����ݹ����Ĳ�ͬa������ȡ��ͬ��ֵ����aΪnullʱ����ֵIndex(Ĭ�Ͻ���)
		String action = request.getParameter("a") == null ? "Index" : request.getParameter("a");
		HttpSession session = request.getSession();

		if (action.equals("Index")) { // Ĭ�Ͻ��룬a==null
			// ͨ���ж�session���Ƿ���ڸù���Ա��ţ���Ϊ��֤���Ѿ���¼
			if (session.getAttribute("AdminNum") == null) {// session�и�ѧ��Ϊ�գ���ת��ѧ����¼ҳ��
				response.sendRedirect("View/Home/AdminLogin.html");//�ض���
			} else {//session�и�ѧ�Ų�Ϊ�գ���ѧ���Ѿ���¼������ѧ����ҳ
				AdminInfo s = new AdminInfo();
				ExamInfo ei = new ExamInfo();
				
				try {
					//��ѯ���а��ŵĿ��Դ洢
					ArrayList<ExamInfo> ExamArr = ei.getAllExam();//�洢������԰��Ŷ�������
					//��ѯ����Ա��Ϣ�洢
					s = s.getAdminfoByAdminNum(session.getAttribute("AdminNum").toString());//�洢�������Ա��Ϣ����
					if (s != null) {
						request.setAttribute("AdminInfo", s);
						request.setAttribute("ExamArr", ExamArr);
					}
				} catch (ParseException e) {
					// TODO 
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				//����ת��
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/Home/Admin.jsp");
				dispatcher.forward(request, response);
				
				//response.sendRedirect("View/Home/index.html");//�ض���
			}
		} else if (action.equals("CheckLogin")) {// ���ݵĲ���aΪ"CheckLogin"������ѧ����¼��֤����
			// ȡ�ô��ݹ�����ѧ�ź�����
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//��֤��¼��Ϣ�Ƿ���ȷ 
			String rst = new AdminInfo().CheckLogin(username, password);

			if (rst == "success") {// ��֤�ɹ�
				session.setAttribute("AdminNum", username);//�ɹ��򽫸õ�¼ѧ�Ŵ���session
				response.getWriter().print("success");
			} else {// ��֤ʧ��
				response.getWriter().print("error");
			}
		} else if(action.equals("UpdatePwd")){  //����aΪ"UpdatePwd"�����й���Ա�����޸�
			if (session.getAttribute("AdminNum") == null) {
				response.sendRedirect("View/Home/AdminLogin.html");
			}else{
				String adminNum=(String) session.getAttribute("AdminNum");
				// ȡ�ô��ݹ����ľ������������
				String oldPwd = request.getParameter("oldPwd");
				String newPwd = request.getParameter("newPwd");
				
				String msg=new AdminInfo().CheckLogin(adminNum,oldPwd);//��֤�������Ƿ���ȷ
				if(msg=="success"){//��������ȷ ������������
					int n=new AdminInfo().updatePwd(adminNum, newPwd);//ִ�и���
					if(n>0){//���³ɹ�
						response.getWriter().print("success");
					}else{//����ʧ��
						response.getWriter().print("wrong");
					}
				}else{//�����벻��ȷ
					response.getWriter().print("error");
				}
			}
		}else{//����a������������ȴ�����
			
		}
	}
	

}
