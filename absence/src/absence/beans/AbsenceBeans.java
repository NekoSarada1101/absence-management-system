package absence.beans;

import java.io.Serializable;
import java.sql.Date;

public class AbsenceBeans implements Serializable {
    private String userId = null;
    private Date absenceDate = null;
    private String companyName = null;
    private String reason = null;

    public AbsenceBeans() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAbsenceDate() {
        return absenceDate;
    }

    public void setAbsenceDate(Date absenceDate) {
        this.absenceDate = absenceDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
