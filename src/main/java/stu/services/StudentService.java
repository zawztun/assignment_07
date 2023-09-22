package stu.services;

import stu.dto.Student;

import java.sql.SQLException;

public interface StudentService {
    void createStudent(Student stu)throws Exception;
    void updateStudent(int stuId, Student stu) throws  Exception;
    void deleteStudent (int stuId) throws  Exception;
    void getAllStudent() throws  Exception;
    public  void createTable() throws SQLException;
}
