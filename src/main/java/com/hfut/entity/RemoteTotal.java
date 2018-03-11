package com.hfut.entity;

public class RemoteTotal extends Total {

    private Float course;

    private Float expriment;

    private Float graduationDesign;

    private Float nonLesson;

    private Float courseDesign;

    @Override
    Float count() {
        if (total == 0) {
            total = course + expriment + graduationDesign + nonLesson + courseDesign;
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

    public Float getGraduationDesign() {
        return graduationDesign;
    }

    public void setGraduationDesign(Float graduationDesign) {
        this.graduationDesign = graduationDesign;
    }

    public Float getNonLesson() {
        return nonLesson;
    }

    public void setNonLesson(Float nonLesson) {
        this.nonLesson = nonLesson;
    }

    public Float getCourseDesign() {
        return courseDesign;
    }

    public void setCourseDesign(Float courseDesign) {
        this.courseDesign = courseDesign;
    }

    @Override
    public String toString() {
        return "RemoteTotal{" +
                "teacher=" + teacher +
                "id=" + id +
                "years=" + years +
                "course=" + course +
                ", expriment=" + expriment +
                ", graduationDesign=" + graduationDesign +
                ", nonLesson=" + nonLesson +
                ", courseDesign=" + courseDesign +
                '}';
    }
}