package com.hfut.entity;

public class RemoteTotalView {
    private String teacher;

    private Integer years;

    private Double course;

    private Double design;

    private Double expriment;

    private Double graduate;

    private Double nonLesson;

    private Double total;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public Double getDesign() {
        return design;
    }

    public void setDesign(Double design) {
        this.design = design;
    }

    public Double getExpriment() {
        return expriment;
    }

    public void setExpriment(Double expriment) {
        this.expriment = expriment;
    }

    public Double getGraduate() {
        return graduate;
    }

    public void setGraduate(Double graduate) {
        this.graduate = graduate;
    }

    public Double getNonLesson() {
        return nonLesson;
    }

    public void setNonLesson(Double nonLesson) {
        this.nonLesson = nonLesson;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}