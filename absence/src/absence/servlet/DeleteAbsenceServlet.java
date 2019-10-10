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

@WebServlet("/deleteabsence")
public class DeleteAbsenceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        AbsenceBeans deleteBeans = (AbsenceBeans) session.getAttribute("absenceBeans");

        //削除処理
        AbsenceDao absenceDao = new AbsenceDao();
        absenceDao.delete(deleteBeans);

        session.removeAttribute("deleteBeans");
        session.removeAttribute("absenceBeans");
        response.sendRedirect("completedelete");
    }
}
