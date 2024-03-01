package com.javaman.webprojectlearn.myenum;

import org.junit.Test;

public enum  Day {
    MONDAY(1,"星期一","Monday"),
    TUESDAY(2,"星期二","Tuesday"),
    WEDNESDAY(3,"星期三","Wednesday"),
    THURSDAY(4,"星期四","Thursday"),
    FRIDAY(5,"星期五","Friday"),
    SATURDAY(6,"星期六","Saturday"),
    SUNDAY(7,"星期天","Sunday");
    private int index;
    private String CNname;
    private String ENname;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCNname() {
        return CNname;
    }

    public void setCNname(String CNname) {
        this.CNname = CNname;
    }

    public String getENname() {
        return ENname;
    }

    public void setENname(String ENname) {
        this.ENname = ENname;
    }

    Day(int index, String CNname, String ENname) {
        this.index = index;
        this.CNname = CNname;
        this.ENname = ENname;
    }
}
