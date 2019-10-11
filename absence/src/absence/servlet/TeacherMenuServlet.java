package absence.servlet;

import absence.beans.HomeroomBeans;
import absence.beans.TeacherBeans;
import absence.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/teachermenu")
public class TeacherMenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        TeacherBeans teacherBeans = (TeacherBeans) session.getAttribute("teacherBeans");

        TeacherDao teacherDao = new TeacherDao();
        List<HomeroomBeans> homeroomList = teacherDao.getHomeroom(teacherBeans.getTeacherId());

        session.setAttribute("homeroomlist", homeroomList);
        request.getRequestDispatcher("WEB-INF/jsp/teachermenu.jsp").forward(request, response);
    }
}
