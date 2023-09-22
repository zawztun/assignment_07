package stu.dao;
import stu.config.ConnectionFactory;
import stu.dto.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO_impl implements Student_DAO {
    Connection con = null;
    public StudentDAO_impl() throws Exception {

      this.con = ConnectionFactory.getDBConnection();
    }
    @Override
    public Integer createStudent(Student stu) throws SQLException {

        String sql = "insert into student values(?,?,?,?)";
        //String sql = "insert into student values( " + stu.getStuNo() + ", '" + stu.getStuName() + "','"  + stu.getStuClass() + "'," + stu.getStuMark() + ");";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1,stu.getStuNo());
        stm.setString(2,stu.getStuName());
        stm.setString(3,stu.getStuClass());
        stm.setInt(4,stu.getStuMark());
        Integer n = stm.executeUpdate();
        return n;
    }
    @Override

    public Integer updateStudent(int stuId, Student stu) throws SQLException {
        String sql = "UPDATE student SET stuID = ?, stuName = ?, stuClass = ?, stuMark = ? WHERE stuID = ?;";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, stu.getStuNo());
        stm.setString(2, stu.getStuName());
        stm.setString(3, stu.getStuClass());
        stm.setFloat(4, stu.getStuMark());
        stm.setInt(5, stuId);
        int n = stm.executeUpdate(); // Remove the sql parameter
        stm.close();
        return n;
    }
    @Override
    public Integer deleteStudent(int stuId) throws SQLException {
        String sql = "delete from student where stuID= ?;";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1,stuId);
        int n = stm.executeUpdate();
        stm.close();
        return  n;
    }
    @Override
    public List<Student> StudentTable() throws SQLException {
        List<Student> stus = new ArrayList<>();
        String sql = "select * from student";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            int stuId = rs.getInt(1);
            String stuName = rs.getString(2);
            String stuClass = rs.getString(3);
            int stuMark = rs.getInt(4);

            Student stu = new Student(stuId, stuName, stuClass, stuMark);
            stus.add(stu);
        }
        st.close();
        return stus;
    }

    @Override
    public void createTable() throws SQLException {
        Statement stm= con.createStatement();
        String sql = "create table db_student01 (stuID varchar(255), stuName varchar(255) , stuClass int , stuMark int)";
        boolean success = stm.execute(sql);
        if (success) {
            System.out.println("Table Created ");
        }
    }
}
