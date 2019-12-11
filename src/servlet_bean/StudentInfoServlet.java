package chapter5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentInfoServlet
 */
@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 業務ロジック用のJavaBeans(部品が持つ機能をまとめたクラス)のインスタンスを生成
	StudentInfoBean stdInfoBean = new StudentInfoBean();

    public StudentInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentNo;
		String studentName;
		int schoolYear;

		try {
			studentNo = Integer.parseInt(request.getParameter("studentno"));
			studentName = request.getParameter("studentname");
			schoolYear = Integer.parseInt(request.getParameter("schoolyear"));
		} catch(NumberFormatException e) {
			getServletContext().getRequestDispatcher("/errorinput.html").forward(request,  response);
			return;
		}

		// 入力フォームから受け取ったデータをStudentRecordBean インスタンスに格納
		// データ保持用のJavaBeans(部品が持つ要素をまとめたクラス)のインスタンスを生成
		StudentRecordBean stdRecord = new StudentRecordBean();
		stdRecord.setStudentNo(studentNo);
		stdRecord.setStudentName(studentName);
		stdRecord.setSchoolYear(schoolYear);

		// 業務ロジック用のJavaBeansのリストに新規生成後に入力フォームから受け取ったデータを格納したStudentRecordBeanインスタンスを追加
		stdInfoBean.addStudentRecord(stdRecord);

		// Sessionオブジェクトに業務ロジック用のJavaBeansを格納
		HttpSession session = request.getSession();
		session.setAttribute("stdInfoBean", stdInfoBean);

		// studentinfo_check.jspへ画面遷移
		getServletContext().getRequestDispatcher("/studentinfo_check.jsp").forward(request,  response);
	}
}
