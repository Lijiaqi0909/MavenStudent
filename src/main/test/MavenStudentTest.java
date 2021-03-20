import com.student.MavenStudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MavenStudentTest {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MavenStudent student = new MavenStudent();
    @Test
    public  void getAllTest() throws IOException {

        //获取文件 然后通过流的方式来获取信息
        String resource="mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        //创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //创建session
        SqlSession session = factory.openSession();
        List<MavenStudent> getAll = session.selectList("getAll");
        /*查询所有信息*/
        for (MavenStudent student: getAll){
            System.out.println(student.getDate() );
        }
        /*添加信息*/
        student.setName("222222");
        student.setAge(24);
        /*获取当前时间*/
        String format = dateFormat.format(date);
        System.out.println(format);
        student.setDate(Timestamp.valueOf(format));
        session.insert("insterStudent",student);
        session.commit();
        /*关闭session会话*/
        session.close();
    }

}
