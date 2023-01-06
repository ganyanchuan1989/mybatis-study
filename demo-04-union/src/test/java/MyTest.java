import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentMapper;
import org.example.dao.TeacherMapper;
import org.example.entry.Student;
import org.example.entry.Teacher;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void addTeacher() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();

        teacher.setName("gxz" + Math.random());
        int i = mapper.addTeacher(teacher);
        System.out.println("插入老师成功：" + teacher.getId());

    }

    @Test
    public void addStudent() {
        Student student = new Student();
        student.setName("student" + Math.random());

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "student" + Math.random());
        map.put("tid", 1);
        mapper.addStudent(map);
        System.out.println(map.get("id"));


    }

    @Test
    public void fastJson() {
        Student student = new Student();
        student.setName("student" + Math.random());

        Teacher teacher = new Teacher();
        teacher.setName("t");
        student.setTeacher(teacher);

        String str = JSON.toJSONString(student);

        Object obj = JSON.parse(str);
        System.out.println(obj);
    }

    @Test
    public void queryAllStudent() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.queryAllStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void getTeacher() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }
}
