package com.weibin.dao;

import com.weibin.bean.Student;

import java.util.List;
import java.util.Map;

/**
 *  @author Weibin on 2018/8/9.
 *  @version 1.0
 *  
 */
public interface IStudentDao {
    void insertStudent(Student student);

    void insertStudentCacheId(Student student);

    void deleteStudentById(int id);
    void updateStudent(Student student);

    List<Student> selectAllStudents();

    Map<String, Object> selectAllStudentsMap();

    Student selectStudentById(int id);

    List<Student> selectStudentsByName(String name);
}
