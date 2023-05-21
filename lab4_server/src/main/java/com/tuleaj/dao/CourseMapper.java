package com.tuleaj.dao;

import com.tuleaj.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    List<Course> selectCourse();

    Course selectCourseById(int id);

//    @Delete("delete from demo2 where id=#{id}")
    int deleteCourse(int id);
//
//    @Update("update demo2 set name=#{pname},hours=#{phours},college=#{pcollege} where id=#{pid}")
//    int updateCourse(@Param("pid") int id,@Param("pname") String name,@Param("phours") int hours,@Param("pcollege") String college);
    int updateCourse(Course course);
//
//    @Update("alter table demo2 auto_increment=1;")
//    @Insert("insert into demo2 (name, hours, college) values(#{pname},#{phours},#{pcollege})")
//    int insertCourse(@Param("pname") String name,@Param("phours") int hours,@Param("pcollege") String college);
    int insertCourse(Course course);

    int auto();
}
