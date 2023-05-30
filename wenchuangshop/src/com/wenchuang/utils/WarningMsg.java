package com.wenchuang.utils;

import com.wenchuang.po.User;

public class WarningMsg {
    private String warningMsg;
    private User user;
    public WarningMsg() {
        super();
    }
    public WarningMsg(User user) {
        super();
        this.user = user;
    }
    public WarningMsg(String warningMsg) {
        super();
        this.warningMsg = warningMsg;
    }
    public WarningMsg(String warningMsg, User user) {
        super();
        this.warningMsg = warningMsg;
        this.user = user;
    }
    public String getMsg() {
        return warningMsg;
    }
    public void setMsg(String warningMsg) {
        this.warningMsg = warningMsg;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
