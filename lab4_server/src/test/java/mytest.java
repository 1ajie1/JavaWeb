import com.tuleaj.domain.Course;
import com.tuleaj.domain.User;
import com.tuleaj.service.CourseService;
import com.tuleaj.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class mytest {
    @Test
    public void selectCourse(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = (CourseService) applicationContext.getBean("CourseServiceImpl");
        List<Course> courseList = courseServiceImpl.selectCourse();
        for(Course c : courseList){
            System.out.println(c);
        }
    }

    @Test
    public void deleteCourse(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = (CourseService) applicationContext.getBean("CourseServiceImpl");
        int delete = courseServiceImpl.deleteCourse(13);
        System.out.println(delete);
    }

    @Test
    public void updateCourse(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = (CourseService) applicationContext.getBean("CourseServiceImpl");
        Course course = new Course();
        course.setId(10);
        course.setName("timer");
        course.setHours(11111);
        course.setCollege("wdnmd");
        int update = courseServiceImpl.updateCourse(course);
        System.out.println(update);
    }

    @Test
    public void insertCourse(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseServiceImpl = (CourseService) applicationContext.getBean("CourseServiceImpl");
        Course course = new Course();
        course.setId(13);
        course.setName("timer");
        course.setHours(11111);
        course.setCollege("wdnmd");
        courseServiceImpl.auto();
        int insert = courseServiceImpl.insertCourse(course);
        System.out.println(insert);
    }

    @Test
    public void selectUser(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) applicationContext.getBean("UserServiceImpl");
        User user = new User();
        user.setUsername("test");
        user.setPassword("1234");
        int result = userServiceImpl.selectUser(user);
        System.out.println(result);
    }
}
