package absence.servlet;

import absence.beans.TeacherBeans;
import absence.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/teacherauth")
public class TeacherAuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String teacherId = request.getParameter("id");
        String password = request.getParameter("password");

        //ログイン処理
        TeacherDao teacherDao = new TeacherDao();
        TeacherBeans teacherBeans = teacherDao.getby(teacherId, password);

        HttpSession session = request.getSession();
        if (teacherBeans != null) {    //ログイン成功→メニュー画面
            session.setAttribute("teacherBeans", teacherBeans);
            response.sendRedirect("teachermenu");
        } else {                    //失敗→ログイン画面
            session.setAttribute("error", "教員番号またはパスワードが間違っています");
            response.sendRedirect("teacherlogin");
        }
    }
}
