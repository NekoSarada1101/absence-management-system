package absence.servlet;

import absence.beans.AbsenceBeans;
import absence.dao.AbsenceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateabsence")
public class UpdateAbsenceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        AbsenceBeans modifyBeans = (AbsenceBeans) session.getAttribute("modifyAbsenceBeans");

        //更新処理
        AbsenceDao absenceDao = new AbsenceDao();
        absenceDao.update(modifyBeans);

        session.removeAttribute("modifyBeans");
        session.removeAttribute("absenceBeans");
        response.sendRedirect("completemodify");
    }
}
