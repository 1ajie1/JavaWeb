package com.tuleaj.pojo;

import java.util.List;

public class Course {
    private Integer id;
    private String name;
    private Integer hours;
    private School schools;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public School getSchools() {
        return schools;
    }

    public void setSchools(School schools) {
        this.schools = schools;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", schools=" + schools +
                '}';
    }
}
