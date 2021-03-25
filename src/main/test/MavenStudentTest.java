import com.dao.MavenStudentDao;
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
import java.util.Scanner;

public class MavenStudentTest {
    //创建时间
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
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
            System.out.println(student.getDate());
        }
        /*添加信息*/
        student.setName("222222");
        student.setAge(24);
        /*获取当前时间*/
       String format = dateFormat.format(date);
        System.out.println(format);
        student.setDate(Timestamp.valueOf(format));
       /* session.insert("insterStudent",student);*/
        MavenStudentDao mapper = session.getMapper(MavenStudentDao.class);
        mapper.insterStudent(student);
        session.commit();
        /*关闭session会话*/
        session.close();
    }
    //99乘法表
    @Test
    public  void  TestStudent(){
       for (int i=1;i<10;i++){
            for (int j=1;j<=i;j++){
                System.out.println(j+"*"+i+"="+(i*j)+'\n');
            }

       }
    }
    @Test
    //10以内偶数之和
    public  void  Tset2(){
        int  sum=0;
        for (int i=1;i<=10;i++){
            if (i%2 == 1){
                continue;
            }
            sum=sum+i;

        }
        System.out.println("==="+sum);

    }
    //直角三角形
    @Test
    public void Test3(){
        for (int i=1;i<=3;i++){
            for (int j=1;j<=i;j++){
                System.out.println("*");
            }
            System.out.print("\t");
        }

    }
    @Test
    public void Test4(){
        int num = 1000;
        int count = 0;

        if (num >= 0  && num<=999999999){
            while(num != 0){
                count++;
                num/=10;
            }
            System.out.println("它是个"+ count+"位的数！");
        } else{
            System.out.println("输入有误！");
        }

    }
    //循环练习
    @Test
    public void Test5(){

        int score=new Scanner(System.in).nextInt();
        int count = 0;
        System.out.println("加分钱的成绩为"+score);
        while (score<60){
            score++;
            count++;
        }
        System.out.println("加分后的成绩为"+score);
        System.out.println("加分的次数为"+count);
    }




}

