package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner{
	private final StudentRespository studentrepo;

	public Application(StudentRespository studentrepo) {
		this.studentrepo = studentrepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		//Create

		Student stu = new Student();
		stu.setFname("Lavanya");
		stu.setLname("Ravichandran");
		stu.setAge(23);
		stu.setEmail("rlavan0927@gmail.com");

		Student stu2 = new Student();
		stu2.setFname("John");
		stu2.setLname("Doe");
		stu2.setAge(21);
		stu2.setEmail("john.doe@example.com");

		Student stu3 = new Student();
		stu3.setFname("Jane");
		stu3.setLname("Smith");
		stu3.setAge(22);
		stu3.setEmail("jane.smith@example.com");

		List<Student> listOfStudents= Arrays.asList(stu,stu2,stu3);

		studentrepo.saveAll(listOfStudents);
		//studentrepo.save(stu);

		//Retrieve

		Optional<Student> student = studentrepo.findById(1);
		if (student.isPresent()) {
			System.out.println(student.get());
		} else {
			System.out.println("Student not found with this ID ");
		}

		//Update

		Student student1 = studentrepo.findById(2).get();
		student1.setFname("Ramakrishnan");
		student1.setLname("Ravichandran");

		studentrepo.save(student1);
		System.out.println("Updated");

		//Delete

		Student student3 = studentrepo.findById(1).get();
		studentrepo.delete(student3);

//		studentrepo.deleteById(3);
		System.out.println("Deleted");


	}
}
