package com.hfut.entity;

public class Expriment extends ExprimentKey {
    private String grades;

    private String type;

    private Float peroid;

    private Integer people;

    private Float credit;

    private Float coefficient;

    private Float workload;

    private String note;

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades == null ? null : grades.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Float getPeroid() {
        return peroid;
    }

    public void setPeroid(Float peroid) {
        this.peroid = peroid;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public Float getWorkload() {
        return workload;
    }

    public void setWorkload(Float workload) {
        this.workload = workload;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        return "Expriment{" +
                "grades='" + grades + '\'' +
                ", type='" + type + '\'' +
                ", peroid=" + peroid +
                ", people=" + people +
                ", credit=" + credit +
                ", coefficient=" + coefficient +
                ", workload=" + workload +
                ", note='" + note + '\'' +
                "id=" + super.getId() +
                ", teacher='" + super.getTeacher() + '\'' +
                ", lesson='" + super.getLesson() + '\'' +
                ", years=" + super.getYears() +
                ", teachClass=" + super.getTeachClass() +
                '}';

    }
}