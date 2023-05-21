package com.tuleaj.domain;

import org.springframework.web.multipart.MultipartFile;

public class Course {
    private int id;
    private String name;
    private int hours;

    private String picture;
    private MultipartFile file;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hours=" + hours +
                ", file=" + file +
                ", picture='" + picture + '\'' +
                ", college='" + college + '\'' +
                '}';
    }


    public Course(MultipartFile file) {
        this.file = file;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String college;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course() {
    }


    public int getHours() {
        return hours;
    }

    public MultipartFile getFile() {
        return file;
    }



    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
