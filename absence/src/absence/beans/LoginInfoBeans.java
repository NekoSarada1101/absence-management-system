package absence.beans;

import java.io.Serializable;

public class LoginInfoBeans implements Serializable {
    private String userId = null;
    private String userName = null;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
