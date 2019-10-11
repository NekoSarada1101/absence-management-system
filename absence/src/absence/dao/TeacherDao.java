
package absence.dao;

import absence.beans.AbsenceBeans;
import absence.beans.HomeroomBeans;
import absence.beans.TeacherBeans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao extends DaoBase {
    //ログイン処理
    public TeacherBeans getby(String teacherId, String password) {
        TeacherBeans teacherBeans = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            this.connect();
            stmt = con.prepareStatement("SELECT * FROM teachers WHERE teacher_id = ? AND teacher_password = ?");
            stmt.setString(1, teacherId);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            rs.next();

            teacherBeans = new TeacherBeans();
            teacherBeans.setTeacherId(rs.getString("teacher_id"));
            teacherBeans.setTeacherName(rs.getString("teacher_name"));

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
        return teacherBeans;
    }

    //担任クラス取得
    public List<HomeroomBeans> getHomeroom(String teacherId) {
        HomeroomBeans homeroomBeans = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<HomeroomBeans> list = null;

        try {
            this.connect();
            stmt = con.prepareStatement("SELECT cl.class_code, co.course_name, cl.grade, cl.class_name FROM (homerooms h INNER JOIN classes cl ON h.class_code = cl.class_code) INNER JOIN courses co ON cl.course_code = co.course_code WHERE h.teacher_id = ? ORDER BY cl.class_code asc");
            stmt.setString(1, teacherId);
            rs = stmt.executeQuery();

            list = new ArrayList<>();

            while (rs.next()) {
                homeroomBeans = new HomeroomBeans();
                homeroomBeans.setClassCode(rs.getString("class_code"));
                homeroomBeans.setCourseName(rs.getString("course_name"));
                homeroomBeans.setGrade(rs.getString("grade"));
                homeroomBeans.setClassName(rs.getString("class_name"));
                list.add(homeroomBeans);
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

    ///公欠一覧取得
    public List<AbsenceBeans> getList(String classCode) {
        AbsenceBeans absenceBeans = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<AbsenceBeans> list = null;

        try {
            this.connect();
            stmt = con.prepareStatement("SELECT a.student_id, a.absence_date, a.company_name, a.reason FROM absences a INNER JOIN students s ON a.student_id = s.student_id WHERE s.class_code = ?");
            stmt.setString(1, classCode);
            rs = stmt.executeQuery();

            list = new ArrayList<>();

            while (rs.next()) {
                absenceBeans = new AbsenceBeans();
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
}
