package com.zed.entity;

public class Bill {
    private int id;
    private String departmentId;
    private String waterBill;
    private String elecBill;
    private String date;

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

    public String getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(String waterBill) {
        this.waterBill = waterBill;
    }

    public String getElecBill() {
        return elecBill;
    }

    public void setElecBill(String elecBill) {
        this.elecBill = elecBill;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", waterBill='" + waterBill + '\'' +
                ", elecBill='" + elecBill + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
