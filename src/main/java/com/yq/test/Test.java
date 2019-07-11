package com.yq.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.entity.Student;
import com.yq.mapper.StudentMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void testInsert(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从Ioc中获取 xXXMapper对象
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        //student：  ww  25
//        Student student = new Student("ww",25) ;
//        int count = studentMapper.insert( student) ;//增加数据，还会将 db中自增的主键  回写回原对象
//        System.out.println(count);
//        //student:
//        System.out.println(student);
        Student student = new Student() ;
        student.setStuAge(33);// stu_no:自动      age:33      name :没写    other:没写
        studentMapper.insert(student);

    }

    public static void testDelete(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
//        int count = studentMapper.deleteById(5);
//        studentMapper.delete(null);
//        studentMapper.deleteAllStudents();
        studentMapper.delete(null);
//        System.out.println(count);
    }

    public static void testBachDelete(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        List<Integer> stuNos = new ArrayList<Integer>();
        stuNos.add(2);
        stuNos.add(3);
        stuNos.add(4);

        int count = studentMapper.deleteBatchIds(stuNos) ;
        System.out.println(count);

    }


    public static void testDeleteMap(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
      Map<String,Object> map = new HashMap<String,Object>();
        map.put("stu_no",6) ;
        map.put("stu_name","ls") ;//and

        int count = studentMapper.deleteByMap(map);
        System.out.println(count);
    }
    public static void testAR(){
//      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//      StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        //必须在Ioc容器中进行AR
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = new Student("张思33",33);
//        student.insert() ;//增加->数据库
        Student student = new Student();
//        student.setStuNo(12);
//        student.deleteById(  );
//        student.deleteById(11) ; //主键： 序列化类型
     //  student.deleteById(T ) ;  //int/Integer   long/Long  String  ->序列化类型

    //   student.updateById();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        //方法引用：lambda
        wrapper.lambda().like(Student::getStuName, "a");//like stu_name like '%a%'
//        wrapper.like(   "stu_name" ,"a"  ); //like '%a%'
        // where....  -->wrapper
        List<Student> students = student.selectList(wrapper);
        System.out.println(students);


    }



    public static void testQuery(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        Student student = studentMapper.selectById(7) ;



//        System.out.println(student);
//        List<Integer> stuNos = new ArrayList<>();
//        stuNos.add(2);
//        stuNos.add(3);
//        stuNos.add(7);
//        List<Student>  students = studentMapper.selectBatchIds( stuNos);
//        System.out.println(students);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("stu_no",7) ;
//        map.put("stu_name","赵六") ;//and

        //select xxx from ..where  stuno =?  and  stuname = ?
//        List<Student> students = studentMapper.selectByMap(map);
//        System.out.println(students);




    }

    public static void testQuery2(){


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        // 2.x  EntityWrapper   Condition
        // 3.  xxx


        //select ...from  ... where ..stu_no beteween  3 and 5  or stu_age > 20
        // and stu_name like '&s&'   limit 3,2  ;

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.between("stu_no",3,5)  //jdk1.8新特性：labmda
                .or(   i->i.ge("stu_age",25).le(   "stu_age",28)   )
                .like("stu_name","s")
                .last(" limit 3,2")
                ;
        //great equals



        List<Student> students = studentMapper.selectList(wrapper);
        System.out.println(students);


    }



    public static void testUpdate(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
//        Student stu = new Student(7,"赵六",12);
    //  stu.setStuNo(7);
//

//
//
//        Student stu = new Student(100,"zzz",99);
//
//
//        stu.setVersion(2);
//
//        int count = studentMapper.updateById(stu);
//        if(count >0){
//            System.out.println("修改成功");
////        if(userService.updateById(stu
//        }{
//            System.out.println("修改！并发冲突！已被别人修改了！");
//        }
////            System.out.println("Update successfully");
////        }else{
////            System.out.println("Update failed due to modified by others");
////        }
////        int count = studentMapper.updateById(stu);
////        System.out.println(count);

    }

    public static void testPage(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        //select * from student ;
        IPage<Student> page = studentMapper.selectPage(new Page<>(2,2), null);
        System.out.println( "当前页的数据："+ page.getRecords());  ;
        System.out.println( "当前页页码："+ page.getCurrent());  ;
        System.out.println( "总数据量："+ page.getTotal());  ;
        System.out.println( "每页数据量："+ page.getSize());  ;


    }  public static void testDeleteAll(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
//        studentMapper.delete(null) ;
        Student stu = new Student("zs",23);
        studentMapper.update(stu,null);
    }


    public static void testUpdate2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;

//        Student stu = new Student("孙琦",77);
        //  stu.setStuNo(7);

        //wrapper:where...
        ///update ....where id = xxx ;
        //update  xxx.. wehre stu_name = ?
//        UpdateWrapper<Student> wrapper  = new UpdateWrapper<>() ;
//        wrapper.eq("stu_no",3) ;
//        wrapper.eq("stu_no",3) ;
//        int count = studentMapper.update( stu  , wrapper) ;
//        System.out.println(count);
    }

    //lambda  Stream
    //  List<Student> list = new ArrayList<Student>();
    public static void main(String[] args)  throws Exception{
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ComboPooledDataSource ds =(ComboPooledDataSource) context.getBean("dataSource");
//        System.out.println("ds:-----------" +ds);
//        Connection connection = ds.getConnection();
//        System.out.println("connection:-----------" +connection);
//        testInsert();
//        testDelete();
//        testBachDelete();
//        testDeleteMap();
//        testUpdate();
//        testUpdate2();
//        testQuery2();
//        testAR();
//        testPage();
//        testDeleteAll();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper =context.getBean("studentMapper",StudentMapper.class) ;
        System.out.println("-------------------------");
        System.out.println(studentMapper.queryStudents());
        System.out.println("-------------------------");
        System.out.println(studentMapper.selectList(new QueryWrapper<>()));
        // studentMapper.queryStudents();

    }

}
