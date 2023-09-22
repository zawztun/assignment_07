package stu.dao;

import stu.dto.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface Student_DAO {
   Integer createStudent(Student stu) throws SQLException;
    Integer updateStudent(int stuId, Student stu) throws SQLException;
    Integer deleteStudent(int stuId) throws  SQLException;
    List<Student> StudentTable() throws SQLException;
    public void createTable() throws SQLException;



}
