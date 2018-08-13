package com.weibin.test;

import com.weibin.bean.Student;
import com.weibin.dao.IStudentDao;
import com.weibin.dao.StudentDaoImpl;
import org.junit.Before;

import java.util.List;
import java.util.Map;

/**
 *  @author Weibin on 2018/8/9.
 *  @version 1.0
 *  
 */
public class Test {

    private IStudentDao dao;

    @Before
    public void before(){
         dao = new StudentDaoImpl();
    }


    @org.junit.Test
    public void testInsert(){
        Student student = new Student("张山", 23, 95.5);
        dao.insertStudent(student);
    }

    @org.junit.Test
    public void test01(){
        Student student = new Student("张山", 23, 95.5);
        dao.insertStudentCacheId(student);
        System.out.println(student);
    }

    @org.junit.Test
    public void test02(){
        //Student student = new Student("张山", 23, 95.5);
        dao.deleteStudentById(8);
    }

    @org.junit.Test
    public void test03(){
        Student student = new Student("张山", 28, 95.5);
        student.setId(4);
        dao.updateStudent(student);
    }

    @org.junit.Test
    public void test04(){
        List<Student> students = dao.selectAllStudents();
        if (students != null){
            for (Student student: students) {
                System.out.println(student);
            }
        }else {
            System.out.println("未查询到数据。。。");
        }
    }

    @org.junit.Test
    public void test05(){
        Map<String, Object> map= dao.selectAllStudentsMap();
        System.out.println(map.get(4));
    }

    @org.junit.Test
    public void test06(){
        Student student = dao.selectStudentById(5);
        System.out.println(student);
    }

    @org.junit.Test
    public void test07(){
        List<Student> students = dao.selectStudentsByName("张");
        if (students != null){
            for (Student student: students) {
                System.out.println(student);
            }
        }else {
            System.out.println("未查询到数据。。。");
        }
    }
}
