
package absence.dao;

import absence.beans.AbsenceBeans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbsenceDao extends DaoBase {
    public List<AbsenceBeans> getList(String userId) {
        AbsenceBeans absenceBeans = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AbsenceBeans> list = new ArrayList<>();

        try {
            this.connect();
            stmt = con.prepareStatement("SELECT student_id, absence_date, company_name, reason FROM absences WHERE student_id = ?");
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                absenceBeans = new AbsenceBeans();
                absenceBeans.setUserId(rs.getString("student_id"));
                absenceBeans.setCompanyName(rs.getString("company_name"));
                absenceBeans.setAbsenceDate(rs.getString("absence_date"));
                absenceBeans.setReason(rs.getString("reason"));
                list.add(absenceBeans);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
