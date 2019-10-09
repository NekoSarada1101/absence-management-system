package absence.servlet;

import absence.beans.AbsenceBeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/confirmmodify")
public class ConfirmModify extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        int absenceID = ((AbsenceBeans) session.getAttribute("absenceBeans")).getAbsenceId();

        String date = request.getParameter("date");
        String companyName = request.getParameter("name");
        String reason = request.getParameter("reason");

        AbsenceBeans absenceBeans = new AbsenceBeans();
        absenceBeans.setAbsenceId(absenceID);
        absenceBeans.setAbsenceDate(date);
        absenceBeans.setCompanyName(companyName);
        absenceBeans.setReason(reason);

        session.setAttribute("modifyAbsenceBeans", absenceBeans);
        request.getRequestDispatcher("WEB-INF/jsp/confirmmodify.jsp").forward(request, response);
    }
}
