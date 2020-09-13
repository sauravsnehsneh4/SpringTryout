package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new ClassPathXmlApplicationContext("config.xml");   	
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        Student student= new Student(001,"Saurav Sneh","Lucknow");
//        int r =studentDao.insert(student);
//        System.out.println(r);
        
        BufferedReader br =new BufferedReader(new InputStreamReader (System.in));
        
        
        Boolean go=true;
        while(go) {
            System.out.println("PRESS 1 to add new Student");           
            System.out.println("PRESS 2 to display all Students");            
            System.out.println("PRESS 3 to get detail of single Student");            
            System.out.println("PRESS 4 to delete students");            
            System.out.println("PRESS 5 to update Student");            
            System.out.println("PRESS 6 to exit");
            
            try {
            	int input = Integer.parseInt(br.readLine());
            	
            	switch (input) {
				case 1:
					System.out.println("Enter User Id : ");
					int uid = Integer.parseInt(br.readLine());
					
					System.out.println("Enter User Name : ");
					String uname = br.readLine();
					
					System.out.println("Enter city : ");
					String ucity = br.readLine();
					
					Student s= new Student(uid,uname,ucity);
					
					int i = studentDao.insert(s);
					System.out.println(i+" student added");
					System.out.println("********************************************");
					System.out.println("");
					break;
					
				case 2:
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student student : allStudents) {
						System.out.println("Id :"+ student.getStudentId());
						System.out.println("Name :"+ student.getStudentName());
						System.out.println("City :"+ student.getStudentCity());
						System.out.println("____________________________________________");
					}
					System.out.println("********************************************");
					
					break;
					
				case 3:
					
					
					System.out.println("Enter User Id : ");
					int uid1 = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(uid1);
					System.out.println("Id :"+ student.getStudentId());
					System.out.println("Name :"+ student.getStudentName());
					System.out.println("City :"+ student.getStudentCity());
					System.out.println("********************************************");
					
					
					break;
					
				case 4:
					System.out.println("Enter User Id : ");
					int studentId = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(studentId);
					System.out.println("Student Deleted");
					System.out.println("********************************************");
					break;
					
				case 5:
					System.out.println("Enter User Id : ");
					int uid2 = Integer.parseInt(br.readLine());
					
					System.out.println("Enter User Name : ");
					String uname2 = br.readLine();
					
					System.out.println("Enter city : ");
					String ucity2 = br.readLine();
					
					Student ss= new Student(uid2,uname2,ucity2);
					
					studentDao.updateStudent(ss);
					System.out.println("student updated");
					System.out.println("********************************************");
					break;
										
				case 6:
					go=false;
					break;

				}
            	
            }
            catch(Exception e){
            	System.out.println("Invalid input try with another one");
            	System.out.println(e.getMessage());
            }
        }
       System.out.println("Thankyou for using my application");

    }
}
