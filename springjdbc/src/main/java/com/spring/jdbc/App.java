package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program started......." );
         //spring jdbc=> jdbcTemplate
        
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
       
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        //INSERT
       // Student student = new Student();
        //student.setId(673);
        //student.setName("John");
        //student.setCity("America");
        
        //int result = studentDao.insert(student);
        
        //System.out.println("student added" +result);
        // UPDATE
        //Student student = new Student();
       // student.setId(456);
       // student.setName("Faijan");
       // student.setCity("italy");
       // int result = studentDao.change(student);
       // System.out.println("data changed "+result);
        
        //DELETE
        //int result = studentDao.delete(222);
        //System.out.println("deleted "+result);
        
        //Student student = studentDao.getStudent(521);
        //System.out.println(student);
        
        List<Student> students = studentDao.getAllStudents();
        for(Student s:students) {
        	System.out.println(s);
        }
    }
}
