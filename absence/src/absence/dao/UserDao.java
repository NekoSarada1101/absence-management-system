package absence.dao;

import absence.beans.LoginInfoBeans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends DaoBase {
    public LoginInfoBeans getby(String userId, String password) {
        LoginInfoBeans loginInfo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            this.connect();
            stmt = con.prepareStatement("SELECT * FROM students WHERE student_id = ? AND student_password = ?");
            stmt.setString(1, userId);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            rs.next();

            loginInfo = new LoginInfoBeans();
            loginInfo.setUserId(rs.getString("student_id"));
            loginInfo.setUserName(rs.getString("student_name"));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return loginInfo;
    }
}
