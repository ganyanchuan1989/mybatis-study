package org.example.dao;

import org.example.entry.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    int addStudent(Map<String, Object> map);

    List<Student> queryAllStudent();
}
