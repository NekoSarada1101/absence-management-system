package absence.servlet;

import absence.beans.AbsenceBeans;
import absence.beans.LoginInfoBeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/confirmabsenceresist")
public class ConfirmAbsenceResistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AbsenceBeans absenceBeans = new AbsenceBeans();
        String date = request.getParameter("date");
        String companyName = request.getParameter("name");
        String reason = request.getParameter("reason");

        Date absenceDate = Date.valueOf(date);

        HttpSession session = request.getSession();
        String userId = ((LoginInfoBeans) session.getAttribute("loginInfo")).getUserId();

        absenceBeans.setUserId(userId);
        absenceBeans.setAbsenceDate(absenceDate);
        absenceBeans.setCompanyName(companyName);
        absenceBeans.setReason(reason);

        session.setAttribute("absenceBeans", absenceBeans);
        request.getRequestDispatcher("WEB-INF/jsp/confirmabsenceresist.jsp").forward(request, response);
    }
}
