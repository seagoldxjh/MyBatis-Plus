package com.yq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.entity.Student;

import java.util.List;

public interface StudentMapper   extends BaseMapper<Student> {
    //BaseMapper默认17个方法 ->默认被注入在MP中
    //自己编写了一个新的：  ->也注入进去
    /*
        1.写:deleteAllStudents();//sql语句  。模仿 自带的Delete

        2.注入器

        3.告知MP：停止使用默认的注入器，而改为使用自己的注入器
     */
//    public void deleteAllStudents();//sql语句

    List<Student> queryStudents();

    void add(Student stu) ;
}





