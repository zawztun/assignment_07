package stu.dto;

public class Student {
    private Integer stuId;
    private String stuName;
    private String stuClass;
    private Integer stuMark;


    public Student(Integer stuId, String stuName, String stuClass, Integer stuMark) {
        super();
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.stuMark = stuMark;
    }

    public Integer getStuNo() {
        return stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public Integer getStuMark() {
        return stuMark;
    }

    @Override
    public String toString() {
        return String.format("ems.dto.Employee [%-3d | %-15s | %-15s |%-3d]", stuId, stuName, stuClass, stuMark);

    }
}
