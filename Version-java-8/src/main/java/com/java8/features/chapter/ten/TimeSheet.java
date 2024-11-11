package com.java8.features.chapter.ten;

public class TimeSheet {
    int empId;
    int days;

    public TimeSheet(int empId, int days) {
        this.empId = empId;
        this.days = days;
    }

    @Override
    public String toString() {
        return "TimeSheet{" +
                "empId=" + empId +
                ", days=" + days +
                '}';
    }
}
