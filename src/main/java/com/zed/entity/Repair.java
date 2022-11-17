package com.zed.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;


public class Repair {
    private int id;
    private String departmentId;
    private String propertyNum;

    @JSONField(format="yyyy-MM-dd")
    private Date startDate;

    private String reason;

    @JSONField(format="yyyy-MM-dd")
    private Date finishDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(String propertyNum) {
        this.propertyNum = propertyNum;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", propertyNum='" + propertyNum + '\'' +
                ", startDate='" + startDate + '\'' +
                ", reason='" + reason + '\'' +
                ", finishDate='" + finishDate + '\'' +
                '}';
    }
}
