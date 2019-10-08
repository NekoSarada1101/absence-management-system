package absence.servlet;

import absence.beans.LoginInfoBeans;
import absence.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String studentId = request.getParameter("id");
        String password = request.getParameter("password");

        //ログイン処理
        UserDao userDao = new UserDao();
        LoginInfoBeans loginInfo = userDao.getby(studentId, password);

        HttpSession session = request.getSession();
        if (loginInfo != null) {    //ログイン成功→メニュー画面
            session.setAttribute("loginInfo", loginInfo);
            response.sendRedirect("menu");
        } else {                    //失敗→ログイン画面
            session.setAttribute("error", "学籍番号またはパスワードが間違っています");
            response.sendRedirect("login");
        }
    }
}
