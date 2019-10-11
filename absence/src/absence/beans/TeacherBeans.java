
package absence.beans;

import java.io.Serializable;

public class TeacherBeans implements Serializable {
    private String teacherId = null;
    private String teacherName = null;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
