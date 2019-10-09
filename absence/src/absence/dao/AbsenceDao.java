
package absence.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import absence.beans.AbsenceBeans;

public class AbsenceDao extends DaoBase {
    //履歴取得
    public List<AbsenceBeans> getList(String userId) {
        AbsenceBeans absenceBeans = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AbsenceBeans> list = null;

        try {
            this.connect();
            stmt = con.prepareStatement("SELECT absence_id, student_id, absence_date, company_name, reason FROM absences WHERE student_id = ?");
            stmt.setString(1, userId);
            rs = stmt.executeQuery();

            list = new ArrayList<>();

            while (rs.next()) {
                absenceBeans = new AbsenceBeans();
                absenceBeans.setAbsenceId(rs.getInt("absence_id"));
                absenceBeans.setUserId(rs.getString("student_id"));
                absenceBeans.setCompanyName(rs.getString("company_name"));
                absenceBeans.setAbsenceDate((rs.getString("absence_date")));
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

    //データベース登録
    public void insert(AbsenceBeans absenceBeans) {
        PreparedStatement stmt = null;

        try {
            this.connect();
            stmt = con.prepareStatement("INSERT INTO absences (student_id, absence_date, company_name, reason) VALUES (?, ?, ?, ?)");
            stmt.setString(1, absenceBeans.getUserId());
            stmt.setString(2, absenceBeans.getAbsenceDate());
            stmt.setString(3, absenceBeans.getCompanyName());
            stmt.setString(4, absenceBeans.getReason());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //データベース更新
    public void update(AbsenceBeans modifyBeans) {
        PreparedStatement stmt = null;

        try {
            this.connect();
            stmt = con.prepareStatement("UPDATE absences SET absence_date = ?, company_name = ?, reason = ? WHERE absence_id = ?");
            stmt.setString(1, modifyBeans.getAbsenceDate());
            stmt.setString(2, modifyBeans.getCompanyName());
            stmt.setString(3, modifyBeans.getReason());
            stmt.setInt(4, modifyBeans.getAbsenceId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
