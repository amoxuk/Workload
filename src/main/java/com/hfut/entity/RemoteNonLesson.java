package com.hfut.entity;

public class RemoteNonLesson extends RemoteNonLessonKey {
    @Override
    public String toString() {
        return "RemoteNonLesson{" +
                "colleage='" + colleage + '\'' +
                ", days=" + days +
                ", weeks=" + weeks +
                ", alldays=" + alldays +
                ", allownce=" + allownce +
                ", note='" + note + '\'' +
                ", id='" + super.getId() + '\'' +
                ", teacher='" + super.getTeacher() + '\'' +
                ", years='" + super.getYears() + '\'' +
                '}';
    }

    private String colleage;

    private Integer days;

    private Integer weeks;

    private Integer alldays;

    private Float allownce;

    private String note;

    public String getColleage() {
        return colleage;
    }

    public void setColleage(String colleage) {
        this.colleage = colleage == null ? null : colleage.trim();
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    public Integer getAlldays() {
        return alldays;
    }

    public void setAlldays(Integer alldays) {
        this.alldays = alldays;
    }

    public Float getAllownce() {
        return allownce;
    }

    public void setAllownce(Float allownce) {
        this.allownce = allownce;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}