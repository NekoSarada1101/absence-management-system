
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

@WebServlet("/insertabsenceresist")
public class InsertAbsenceResistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AbsenceBeans absenceBeans = new AbsenceBeans();

        HttpSession session = request.getSession();
        absenceBeans.setUserId(((AbsenceBeans) session.getAttribute("absenceBeans")).getUserId());
        absenceBeans.setAbsenceDate(((AbsenceBeans) session.getAttribute("absenceBeans")).getAbsenceDate());
        absenceBeans.setCompanyName(((AbsenceBeans) session.getAttribute("absenceBeans")).getCompanyName());
        absenceBeans.setReason(((AbsenceBeans) session.getAttribute("absenceBeans")).getReason());

        AbsenceDao absenceDao = new AbsenceDao();
        boolean success = absenceDao.insert(absenceBeans);



        session.removeAttribute("absenceBeans");
        response.sendRedirect("completeabsenceresist");

    }
}
