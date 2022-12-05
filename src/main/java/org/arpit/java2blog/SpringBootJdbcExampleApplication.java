package org.arpit.java2blog;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.arpit.java2blog.model.Student;
import org.arpit.java2blog.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJdbcExampleApplication implements CommandLineRunner{

	public static Logger LOGGER = LoggerFactory.getLogger(SpringBootJdbcExampleApplication.class);
	
	@PostConstruct
	public void init()
	{
		LOGGER.info("Application started in INIT...");
	}
	@Autowired
	StudentService studentService;
	
	public static void main(String[] args) {
		LOGGER.info("Main application started");
		SpringApplication.run(SpringBootJdbcExampleApplication.class, args);
	}

	@Override
    public void run(String... args) {
		LOGGER.info("StartApplication...");
        testStudentData();
    }

    void testStudentData() {

        List<Student> students = Arrays.asList(
                new Student(1,"John", 16),
                new Student(2,"Martin", 18),
                new Student(3,"Mary",  20),
                new Student(4,"Ricky", 15)
        );

        System.out.println("[SAVE]");
        students.forEach(student -> {
        	LOGGER.info("Saving student with name: "+student.getStudentName() );
            studentService.save(student);
        });

        // find all
        LOGGER.info("get All students: "+studentService.findAll());

        // find by id
        LOGGER.info("Find Student with id 2");
        Student student = studentService.findById(2L).orElseThrow(IllegalArgumentException::new);
        LOGGER.info("Student with id 2: "+student);

        // update
        LOGGER.info("Update age of Martin to 19");
        student.setAge(19);
        student.setStudentId(2);
        LOGGER.info("Rows affected: "+studentService.update(student));

        // delete
        LOGGER.info("Delete Student with id 4");
        LOGGER.info("Rows affected: "+ studentService.deleteById(4));

        // find all
        LOGGER.info("get updated list of Students: "+studentService.findAll());

    }
}
