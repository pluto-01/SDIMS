package com.zed.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Item {
    private String stuName;
    private String itemName;
    @JSONField(format = "yyyy-MM-dd")
    private Date date;
    private String notes;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Item{" +
                "stuName='" + stuName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                '}';
    }
}
