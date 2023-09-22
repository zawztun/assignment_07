package stu.config;

import stu.services.StudentService;
import stu.services.StudentService_impl;

public class ServiceFactory {
    private static StudentService stuService;
    public static StudentService getStuServices()throws Exception{
        if(stuService == null){
            stuService = new StudentService_impl();
        }
        return stuService;
    }

}
