
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
        HttpSession session = request.getSession();
        AbsenceBeans absenceBeans = (AbsenceBeans) session.getAttribute("absenceBeans");

        //登録処理
        AbsenceDao absenceDao = new AbsenceDao();
        absenceDao.insert(absenceBeans);

        session.removeAttribute("absenceBeans");
        response.sendRedirect("completeabsenceresist");
    }
}
