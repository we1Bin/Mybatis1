package com.weibin.dao;

import com.weibin.bean.Student;
import com.weibin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author Weibin on 2018/8/9.
 *  @version 1.0
 *  
 */
public class StudentDaoImpl implements IStudentDao {
    private SqlSession sqlSession;
    @Override
    public void insertStudent(Student student) {
        try {
            //1.加载主配置文件
            //InputStream stream = Resources.getResourceAsStream("mybatis.xml");
            //2.创建SqlSessionFactory
            //SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
            //3.创建SqlSession
             //sqlSession = sqlSessionFactory.openSession();
            //4.相关操作，insert、delete、update等

            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.insert("insertStudent", student);
            sqlSession.commit();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }


    }

    @Override
    public void insertStudentCacheId(Student student) {
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.insert("insertStudentCacheId", student);
            sqlSession.commit();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public void deleteStudentById(int id) {
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.delete("deleteStudentById", id);
            sqlSession.commit();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            sqlSession.update("updateStudent", student);
            sqlSession.commit();
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }

    @Override
    public List<Student> selectAllStudents() {
        List<Student> students = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            students = sqlSession.selectList("selectAllStudents");
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
        return students;
    }

    @Override
    public Map<String, Object> selectAllStudentsMap() {

        Map<String, Object> map = new HashMap<>();
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            map = sqlSession.selectMap("selectAllStudents", "id");
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }

        return map;
    }

    @Override
    public Student selectStudentById(int id) {
        Student student = new Student();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            student = sqlSession.selectOne("selectStudentById", id);
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }

        return student;
    }

    @Override
    public List<Student> selectStudentsByName(String name) {
        List<Student> students = null;
        try {
            sqlSession = MyBatisUtils.getSqlSession();
            students = sqlSession.selectList("selectStudentsByName", name);
        } finally {
            if (sqlSession != null){
                sqlSession.close();
            }
        }
        return students;
    }
}
