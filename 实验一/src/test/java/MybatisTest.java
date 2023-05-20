import com.tuleaj.dao.CourseMapper;
import com.tuleaj.dao.SchoolMapper;
import com.tuleaj.pojo.Course;
import com.tuleaj.pojo.School;
import com.tuleaj.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

public class MybatisTest {
    @Test
    public void findCourseById(){
        SqlSession session = MybatisUtil.getSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        Course course = mapper.selectCourse(2);
        System.out.println(course.toString());
        session.close();
    }

    @Test
    public void findSchoolByName(){
        SqlSession session = MybatisUtil.getSession();
        SchoolMapper mapper = session.getMapper(SchoolMapper.class);
        School school = mapper.selectSchoolByName("计算机学院");
        System.out.println(school);
        session.close();
    }

    @Test
    public void updateCourseHour(){
        SqlSession session = MybatisUtil.getSession();
        CourseMapper mapper = session.getMapper(CourseMapper.class);
        Course course = new Course();
        course.setHours(40);
        course.setId(4);
        int result = mapper.updateCourseHour(course);
        if(result > 0){
            System.out.println("更新成功"+result+"条数据");
        }else {
            System.out.println("更新失败");
        }
        System.out.println(course.toString());
        session.commit();
        session.close();
    }
}
