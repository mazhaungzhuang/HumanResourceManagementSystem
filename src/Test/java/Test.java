/**
 * @author mzz
 * @create 2020/10/6 0006 14:44
 */

import com.mzz.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *@Auther mzz
 *@Date 2020/10/6 000614:44
 *@Version 1.0
 */
public class Test {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private EmpDao ed;

    @org.junit.Test
    public void testSelect() throws IOException {
        is= Resources.getResourceAsStream("MyBatis_config.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        ed=sqlSession.getMapper(EmpDao.class);
        ed.selectAll().forEach(System.out::println);
    }
}
