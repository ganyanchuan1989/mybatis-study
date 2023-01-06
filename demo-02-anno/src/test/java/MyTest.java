import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.entry.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
    }

    @Test
    public void insertUser() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("xxx");
        user.setPassword("ooo");

        mapper.insertUser(user);

        System.out.println("插入用户成功：" + user.getId());
    }
}
