package com.tuleaj.dao;

import com.tuleaj.pojo.School;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface SchoolMapper {
    @Select("select id,schoolname from s_school where id = #{id}")
    @Results({@Result(column = "id",property = "id"),
            @Result(column = "schoolname",property = "schoolName")})
    School selectSchool(int id);

    @Select("select * from s_school where schoolname = #{name}")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "schoolname",property = "schoolName"),
            @Result(column = "id",property = "courseList",
            many = @Many(select =
            "com.tuleaj.dao.CourseMapper.selectCourse"))})
    School selectSchoolByName(String name);
}
