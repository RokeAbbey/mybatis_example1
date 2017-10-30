package test;

import mappers.UserMapper;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.junit.Test;
import roles.User;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {

    @Test
    public void test(){
        String resource = "mybatis1.xml";
        InputStream inputStream = Test1.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        DefaultSqlSessionFactory
//        DefaultSqlSession
        SqlSession session = sqlSessionFactory.openSession();
//        String statement = "mappers.UserMapper";
//        session.selectList();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = null;
        System.out.println((user = mapper.getUser(2))+"***************");
        User user2 = new User();
        user2.setId((int) ((System.currentTimeMillis() >> 10)));
        System.out.println(user2);
        int result = mapper.insertUser(user2);
        System.out.println(result);

        mapper.getUser(2);
        session.commit();

    }
    @Test
    public void test2() throws CloneNotSupportedException {
        User user = new User();
        System.out.println(user.clone());
//        Plugin
//        BaseExecutor
//        SimpleExecutor
//        SimpleExecutor
    }

    @Test
    public void test3(){
        String resource = "mybatis1.xml";
        InputStream inputStream = Test1.class.getClassLoader().getResourceAsStream(resource);
//        Resources.getResourceA
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("mappers.UserMapper.getUser", 2); //第一个参数主要是相应的Mapper的类全名加上方法名(方法名在xml中对应)
        System.out.println(user);

//        JdbcTransactionFactory
    }

    @Test
    public void test4() throws IOException, InterruptedException {
        String file = "mybatis1.xml";
        InputStream inputStream = Resources.getResourceAsStream(file);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession2 = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(2);
        System.out.println(user);
        Thread.sleep(1 * 1000);


        user = userMapper.getUser(2);
        System.out.println(user);
        sqlSession.close();

        userMapper = sqlSession2.getMapper(UserMapper.class);
        user = userMapper.getUser(2);
        System.out.println(user);
        sqlSession2.close();
    }


}
