package stu.services;

import stu.dao.StudentDAO_impl;
import stu.dao.Student_DAO;
import stu.dto.Student;

import java.sql.SQLException;

import java.util.List;

public class StudentService_impl implements StudentService {
    private Student_DAO dao;

    public StudentService_impl() throws Exception {
        dao = new StudentDAO_impl();
    }

    @Override
    public void createStudent(Student stu) throws Exception {
        int n = dao.createStudent(stu);
        if (n > 0) {
            System.out.println("Student account Created ");
        } else {
            System.out.println("Student can not be save");
        }
    }

    @Override
    public void updateStudent(int stuId, Student stu) throws Exception {
        int n = dao.updateStudent(stuId, stu);
        if (n > 0) {
            System.out.println("Student account Updated");
        } else {
            System.out.println("Student  account can not Update");
        }
    }

    @Override
    public void deleteStudent(int stuId) throws Exception {
        int n = dao.deleteStudent(stuId);
        if (n > 0) {
            System.out.println("Student account Deleted ");
        } else {
            System.out.println("Student Account can not Delete");
        }
    }

    @Override
    public void getAllStudent() throws Exception {
        List<Student> stus = dao.StudentTable();
        for (Student stu : stus) {
            System.out.println(stu);
            Thread.sleep(1000);
        }
    }

    @Override
    public void createTable() throws SQLException {
     dao.createTable();

    }
}
