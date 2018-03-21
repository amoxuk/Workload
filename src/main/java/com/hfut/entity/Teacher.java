package com.hfut.entity;

public class Teacher {
    private Integer id;

    private Integer tid;

    private String name;

    private Integer location;

    private String college;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tid=" + tid +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", college='" + college + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}