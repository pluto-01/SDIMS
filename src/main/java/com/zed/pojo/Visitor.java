package com.zed.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class Visitor {
    private String visitor;
    private String gender;
    private String reason;
    private String tel;

    @JSONField(format="yyyy-MM-dd")
    private Date date;
    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitor='" + visitor + '\'' +
                ", gender='" + gender + '\'' +
                ", reason='" + reason + '\'' +
                ", tel='" + tel + '\'' +
                ", date=" + date +
                '}';
    }
}
