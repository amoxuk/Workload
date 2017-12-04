package com.hfut.entity;

public class RemoteTeachWorkload extends RemoteTeachWorkloadKey {
    private String grades;

    private Float period;

    private Float credit;

    private Integer people;

    private Float classCoefficient;

    private Float workload;

    private Float money;

    private String note;

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Float getClassCoefficient() {
        return classCoefficient;
    }

    public void setClassCoefficient(Float classCoefficient) {
        this.classCoefficient = classCoefficient;
    }

    public Float getWorkload() {
        return workload;
    }

    public void setWorkload(Float workload) {
        this.workload = workload;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}