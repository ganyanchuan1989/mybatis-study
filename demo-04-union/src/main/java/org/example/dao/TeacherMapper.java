package org.example.dao;

import org.example.entry.Teacher;

public interface TeacherMapper {

    int addTeacher(Teacher teacher);
    
    Teacher getTeacher(int id);
}
