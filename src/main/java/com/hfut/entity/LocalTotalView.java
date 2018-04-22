package com.hfut.entity;

public class LocalTotalView  {
    private String teacher;

    private Integer years;

    private String college;

    private Double course;

    private Double design;

    private Double expriment;

    private Double graduateDesign;

    private Double graduatePractice;

    private Double project;

    private Double practice;

    private Double matchs;

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
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

    public Double getGraduateDesign() {
        return graduateDesign;
    }

    public void setGraduateDesign(Double graduateDesign) {
        this.graduateDesign = graduateDesign;
    }

    public Double getGraduatePractice() {
        return graduatePractice;
    }

    public void setGraduatePractice(Double graduatePractice) {
        this.graduatePractice = graduatePractice;
    }

    public Double getProject() {
        return project;
    }

    public void setProject(Double project) {
        this.project = project;
    }

    public Double getPractice() {
        return practice;
    }

    public void setPractice(Double practice) {
        this.practice = practice;
    }

    public Double getMatchs() {
        return matchs;
    }

    public void setMatchs(Double matchs) {
        this.matchs = matchs;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LocalTotalView{" +
                "teacher='" + teacher + '\'' +
                ", years=" + years +
                ", college='" + college + '\'' +
                ", course=" + course +
                ", design=" + design +
                ", expriment=" + expriment +
                ", graduateDesign=" + graduateDesign +
                ", graduatePractice=" + graduatePractice +
                ", project=" + project +
                ", practice=" + practice +
                ", matchs=" + matchs +
                ", total=" + total +
                '}';
    }
}