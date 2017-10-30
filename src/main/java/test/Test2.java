package test;

import mappers.SpitterMapper;
import mappers.SpittleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import roles.Spitter;
import roles.Spittle;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis1.xml"),
                "spittr");

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SpitterMapper spitterMapper = sqlSession.getMapper(SpitterMapper.class);
        Spitter spitter = spitterMapper.getOne("roke");
        System.out.println(spitter);


        List<Spitter> spitterList = spitterMapper.getListsByName("roke", "abbey");
        System.out.println(spitterList.size());
        System.out.println(spitterList);

    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis1.xml"),
                "spittr"
        );
        SqlSession session = sqlSessionFactory.openSession();
        SpittleMapper spittleMapper = session.getMapper(SpittleMapper.class);
        Spitter spitter = new Spitter().setUsername("roke");
        List<Spittle> spittleList = spittleMapper.getSpittleByOwner(spitter);
        System.out.println(spittleList);
        session.close();
    }

    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis1.xml"),
                "spittr"
        );
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SpittleMapper spittleMapper = sqlSession.getMapper(SpittleMapper.class);
        Spittle spittle = new Spittle().setOwner( new Spitter().setUsername("roke"))
                .setDate(new Timestamp(System.currentTimeMillis()))
                .setContext("hello") ;

        spittleMapper.addSpittleToSpitter(spittle);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis1.xml"),
                "spittr"
        );
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SpittleMapper spittleMapper = sqlSession.getMapper(SpittleMapper.class);
        ArrayList<Spittle> list = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            list.add(new Spittle().setContext("hello"+i)
                        .setDate(new Timestamp(System.currentTimeMillis()))
                        .setOwner(new Spitter().setUsername("roke2")));
        spittleMapper.addSpittlesToSpitter(list);
        sqlSession.commit();
        sqlSession.close();
    }
}
