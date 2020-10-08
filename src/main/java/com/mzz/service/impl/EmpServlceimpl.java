package com.mzz.service.impl;

import com.mzz.dao.EmpDao;
import com.mzz.po.Emp;
import com.mzz.service.EmpServlce;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author mzz
 * @Date 2020-10-06-15:45
 * @Version 1.0
 */
public class EmpServlceimpl implements EmpServlce {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private EmpDao ed;
    @SneakyThrows
    @Override
    public List<Emp> selectdeptOne() {
        is= Resources.getResourceAsStream("MyBatis_config.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        ed=sqlSession.getMapper(EmpDao.class);
        List<Emp> emps = ed.selectAll();

        return emps;
    }
}
