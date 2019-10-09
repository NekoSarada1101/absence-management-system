package absence.servlet;

import absence.beans.AbsenceBeans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/confirmdelete")
public class ConfirmDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<AbsenceBeans> list = (ArrayList<AbsenceBeans>) session.getAttribute("list");

        int i = Integer.parseInt(request.getParameter("deleteAbsence"));

        AbsenceBeans absenceBeans = new AbsenceBeans();
        absenceBeans = list.get(i);

        session.setAttribute("absenceBeans", absenceBeans);
        request.getRequestDispatcher("WEB-INF/jsp/confirmdelete.jsp").forward(request, response);
    }
}
