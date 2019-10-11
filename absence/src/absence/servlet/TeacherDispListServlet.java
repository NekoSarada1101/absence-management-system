
package absence.servlet;

import absence.beans.AbsenceBeans;
import absence.beans.HomeroomBeans;
import absence.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherdisplist")
public class TeacherDispListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String classCode = request.getParameter("classcode");
        List<HomeroomBeans> homeroomList = (List<HomeroomBeans>) session.getAttribute("homeroomlist");

        for (HomeroomBeans bean : homeroomList) {
            if (bean.getClassCode().equals(classCode)) {
                request.setAttribute("className", bean.getCourseName() + bean.getGrade() + bean.getClassName());
            }
        }

        //公欠リストを取得
        TeacherDao teacherDao = new TeacherDao();
        List<AbsenceBeans> list = teacherDao.getList(classCode);

        session.setAttribute("list", list);
        request.getRequestDispatcher("WEB-INF/jsp/teacherabsencelist.jsp").forward(request, response);
    }
}
