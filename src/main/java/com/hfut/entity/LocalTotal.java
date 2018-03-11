package com.hfut.entity;

public class LocalTotal extends Total {

    private Float course;

    private Float expriment;

    private Float project;

    private Float matchs;

    private Float courseDesign;

    private Float practice;


    public Float getGraduateDesign() {
        return graduateDesign;
    }

    public LocalTotal setGraduateDesign(Float graduateDesign) {
        this.graduateDesign = graduateDesign;
        return this;
    }

    private Float graduateDesign;

    @Override
    Float count() {
        if (total == 0) {
            total = course + expriment + project + matchs + courseDesign + practice;
        }
        return total;
    }

    public Float getCourse() {
        return course;
    }

    public void setCourse(Float course) {
        this.course = course;
    }

    public Float getExpriment() {
        return expriment;
    }

    public void setExpriment(Float expriment) {
        this.expriment = expriment;
    }

    public Float getProject() {
        return project;
    }

    public void setProject(Float project) {
        this.project = project;
    }

    public Float getMatchs() {
        return matchs;
    }

    public void setMatchs(Float match) {
        this.matchs = match;
    }

    public Float getCourseDesign() {
        return courseDesign;
    }

    public void setCourseDesign(Float courseDesign) {
        this.courseDesign = courseDesign;
    }

    public Float getPractice() {
        return practice;
    }

    public void setPractice(Float practice) {
        this.practice = practice;
    }

    @Override
    public String toString() {
        return "LocalTotal{" +
                "course=" + course +
                ", expriment=" + expriment +
                ", project=" + project +
                ", matchs=" + matchs +
                ", courseDesign=" + courseDesign +
                ", practice=" + practice +
                ", graduateDesign=" + graduateDesign +
                ", id=" + id +
                ", teacher='" + teacher + '\'' +
                ", years=" + years +
                ", total=" + total +
                '}';
    }
}