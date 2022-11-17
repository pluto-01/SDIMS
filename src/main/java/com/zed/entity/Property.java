package com.zed.entity;

public class Property {
    private String propertyNum;
    private String propertyName;
    private String propertyCount;

    public String getPropertyNum() {
        return propertyNum;
    }

    public void setPropertyNum(String propertyNum) {
        this.propertyNum = propertyNum;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyCount() {
        return propertyCount;
    }

    public void setPropertyCount(String propertyCount) {
        this.propertyCount = propertyCount;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyNum='" + propertyNum + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", propertyCount='" + propertyCount + '\'' +
                '}';
    }
}
