import org.apache.ibatis.session.SqlSession;
import org.example.dao.UserMapper;
import org.example.entry.User;
import org.example.utils.MyBatisUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MyTest {

    @Test
    public void test01() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            // 方式1:
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.queryAllUser();
            for (User user : users) {
                System.out.println(user.getId());
            }

            // 方式2
            List<User> users1 = sqlSession.selectList("org.example.dao.UserDao.queryAllUser");
            for (User user : users1) {
                System.out.println(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryUserById() {

    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("wcp");
        user.setPassword("123");

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insertUser(user);
        sqlSession.commit(); // 增删改都需要提交事务
        sqlSession.close();
        System.out.println("插入用户成功：" + user.getId());
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("gxz11");
        user.setPassword("xxx");

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
        System.out.println("修改用户成功：" + user.getId());
    }

    @Test
    public void deleteUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUserById(3);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Hello");
    }
}
