package com.hfut.entity;

public class Total {

    public String getTeacher() {
        return teacher;
    }

    public Total setTeacher(String teacher) {
        this.teacher = teacher;
        return this;
    }


    String teacher;

    public boolean isLocal() {
        return local;
    }

    public Total setLocal(boolean local) {
        this.local = local;
        return this;
    }

    @Override
    public String toString() {
        return "Total{" +
                "teacher='" + teacher + '\'' +
                ", local=" + local +
                ", totals=" + totals +
                '}';
    }

    boolean local;

    public Double getTotals() {
        return totals;
    }

    public Total setTotals(Double totals) {
        this.totals = totals;
        return this;
    }

    Double totals;
}
