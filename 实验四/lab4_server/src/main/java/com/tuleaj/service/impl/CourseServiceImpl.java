package com.tuleaj.service.impl;

import com.tuleaj.dao.CourseMapper;
import com.tuleaj.domain.Course;
import com.tuleaj.service.CourseService;
import com.tuleaj.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectCourse() {
        return courseMapper.selectCourse();
    }

    @Override
    public int deleteCourse(int id) {
        return courseMapper.deleteCourse(id);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public int auto() {
        return courseMapper.auto();
    }

    @Override
    public Course getCourse(MultipartHttpServletRequest request) {
        Course course = new Course();
        String name = request.getParameter("name");
        if (request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            course.setId(id);
        }
        String college = request.getParameter("college");
        int hours = Integer.parseInt(request.getParameter("hours"));

        //map集合
        Map<String, MultipartFile> fileMap = request.getFileMap();

        for (Map.Entry<String, MultipartFile> entry : fileMap.entrySet()) {
            course.setFile(entry.getValue());
        }
        course.setName(name);
        course.setHours(hours);
        course.setCollege(college);

        if (course.getFile() != null) {
            String originalFileName = course.getFile().getOriginalFilename();
            String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;
            String filePath = Constants.IMG_PATH + fileName;
            File saveFile = new File(filePath);
            course.setPicture(fileName);
            try {
                // 将上传的文件保存到服务器文件系统
                course.getFile().transferTo(saveFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return course;
    }

    @Override
    public void responseFile(HttpServletResponse response, File imgFile) {
        try (InputStream is = new FileInputStream(imgFile);
             OutputStream os = response.getOutputStream();) {
            byte[] buffer = new byte[1024];
            while (is.read(buffer) != -1) {
                os.write(buffer);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
