package com.tuleaj.service;

import com.tuleaj.domain.Course;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public interface CourseService {
    public List<Course> selectCourse();

    public int deleteCourse(int id);

    int updateCourse(Course course);

    int insertCourse(Course course);

    Course getCourse(MultipartHttpServletRequest request);

    void responseFile(HttpServletResponse response, File imgFile);

    int auto();
}
