package com.tuleaj.dao;

import com.tuleaj.pojo.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    @Select("select * from c_course where id = #{id}")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "hours",property = "hours"),
            @Result(column = "sid",property = "schools",
            one = @One(select =
            "com.tuleaj.dao.SchoolMapper.selectSchool"))})
    Course selectCourse(int id);

    @Update("update c_course set hours = #{hours} where id = #{id}")
    int updateCourseHour(Course course);
}
