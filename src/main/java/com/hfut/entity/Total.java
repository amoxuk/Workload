package com.hfut.entity;

public abstract class Total {
    Integer id;
    String teacher;
    Integer years;

    public Integer getYear() {
        return years;
    }

    public Total setYear(Integer years) {
        this.years = years;
        return this;
    }


    public Integer getId() {
        return id;
    }

    public Total setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTeacher() {
        return teacher;
    }

    public Total setTeacher(String teacher) {
        this.teacher = teacher;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public Total setTotal(Float total) {
        this.total = total;
        return this;
    }

    Float total;

    abstract Float count();

}
