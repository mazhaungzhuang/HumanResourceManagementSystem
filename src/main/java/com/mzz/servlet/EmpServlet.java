package com.mzz.servlet;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mzz.dao.EmpDao;
import com.mzz.po.Emp;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author mzz
 * @Date 2020-10-06-16:20
 * @Version 1.0
 */
@WebServlet("/select")
public class EmpServlet extends HttpServlet {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private EmpDao ed;
    @SneakyThrows
    @Override
    public  void init(){
        is= Resources.getResourceAsStream("MyBatis_config.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        ed=sqlSession.getMapper(EmpDao.class);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Emp> emps = ed.selectAll();
        String json= JSONObject.toJSONString(emps, SerializerFeature.DisableCircularReferenceDetect);
        response.getWriter().print(json);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
