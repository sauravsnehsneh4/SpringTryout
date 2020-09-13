package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
    	
//      ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        INSERT
//        Student student=new Student();
//        student.setId(001);
//        student.setName("Raj");
//        student.setCity("Kahalgaon");
//        
//        int result=studentdao.insert(student);
//        
//        System.out.println("Student added "+result);
        
        
//        UPDATE
//        	Student student=new Student();
//        	student.setId(222);
//        	student.setName("Niraj");
//        	student.setCity("Siwan");
//        	
//        	int result=studentdao.change(student);
//        	
//        	System.out.println("data changed "+result);
        
        // DELETE
//        int result=studentdao.delete(223);
//        System.out.println("Deleted  "+result);
        
//        Student student = studentdao.getStudent(222);
//        System.out.println(student);
        
        List<Student> students = studentDao.getAllStudent();
        for(Student s:students) {
        	System.out.println(s);
        }
    }
}
