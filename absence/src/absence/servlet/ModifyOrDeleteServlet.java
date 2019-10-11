package absence.servlet;

import absence.beans.AbsenceBeans;
import absence.beans.LoginInfoBeans;
import absence.dao.AbsenceDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/modifyordelete")
public class ModifyOrDeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String userId = ((LoginInfoBeans) session.getAttribute("loginInfo")).getUserId();

        AbsenceDao absenceDao = new AbsenceDao();

        //公欠リストを取得
        List<AbsenceBeans> list = absenceDao.getList(userId);

        session.setAttribute("list", list);
        request.getRequestDispatcher("WEB-INF/jsp/modifyordeletelist.jsp").forward(request, response);
    }
}
