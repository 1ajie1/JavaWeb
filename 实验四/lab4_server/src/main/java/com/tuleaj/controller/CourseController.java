package com.tuleaj.controller;

import com.tuleaj.domain.Course;
import com.tuleaj.service.CourseService;
import com.tuleaj.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    @Qualifier("CourseServiceImpl")
    private CourseService courseService;

    @RequestMapping("/select")
    @ResponseBody
    public List<Course> selectCourseList() {
        List<Course> courseList = courseService.selectCourse();
        return courseList;
    }

    //
    @DeleteMapping("/delete/{id}")
    public boolean deleteCourse(@PathVariable int id) {
        int result = courseService.deleteCourse(id);
//        try {
//            Course course = courseService.se
//        }catch (Exception e){
//
//        }
        return result > 0 ? true : false;
    }

    //
    @PostMapping(value = "/update")
    public boolean updateCourse(MultipartHttpServletRequest request){
        Course course = courseService.getCourse(request);
        int result = courseService.updateCourse(course);
        return result > 0;
    }

    //
    @PostMapping("/insert")
    public boolean insertCourse(MultipartHttpServletRequest request) {
        courseService.auto();
        Course course = courseService.getCourse(request);
        int result = courseService.insertCourse(course);
        return result > 0;
    }

    @RequestMapping("/getpicture/{filename}.{suffix}")
    public void showPicture(@PathVariable("filename") String fileName,
                            @PathVariable("suffix") String suffix,
                            HttpServletResponse response) {
        File imgFile = new File(Constants.IMG_PATH + fileName + "." + suffix);
        courseService.responseFile(response, imgFile);
    }

}
