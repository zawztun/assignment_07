package stu;

import stu.config.ServiceFactory;
import stu.dto.Student;
import stu.services.StudentService;

import java.util.Scanner;

public class StuInfoApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        StudentService service = ServiceFactory.getStuServices();
        Student stu;
        boolean run = true;

        while(run){
            System.out.println("1 . Create Student ");
            System.out.println("2 . Update Student ");
            System.out.println("3 . Delete Student ");
            System.out.println("4 . All Students Data");
            System.out.println("5. Create Table ");
            System.out.println("6 . Exit");

            System.out.println("\n Enter an Option: ");
            int opt = sc.nextInt();

            switch (opt){
                case 1:
                    stu = getStudent();
                    service.createStudent(stu);
                    break;
                case 2:
                    System.out.println("Enter student id you want to edit:  ");
                    int eid = sc.nextInt();
                    stu = getStudent();
                    service.updateStudent(eid, stu);
                    break;
                case 3:
                    System.out.println("Enter Delete Student id :");
                    int did = sc.nextInt();
                    service.deleteStudent(did);
                    break;
                case 4:
                   service.getAllStudent();
                   break;

                case 5 :
                    service.createTable();
                default:
                    run = false;
                   break;
            }
        }
    }
    private static Student getStudent(){
        System.out.println("Enter student id: ");
        int stuNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Student name: ");
         String stuName = sc.nextLine();

        System.out.println("Enter Student Class : ");
        String cName = sc.nextLine();

        System.out.println("Enter student Mark : ");
        int stuMark = sc.nextInt();
        return  new Student(stuNo, stuName,cName,stuMark );
    }
}
