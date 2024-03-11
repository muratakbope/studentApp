package kz.singularity.studentapp;

import kz.singularity.studentapp.entity.School;
import kz.singularity.studentapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import kz.singularity.studentapp.repository.StudentRepository;
import kz.singularity.studentapp.repository.SchoolRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentAppApplication(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student(1L, "Adam", "Smith", "adam@gmail.com", 20, 95);
        Student student1 = new Student(2L, "John", "Doe", "john@gmail.com", 25, 80);
        Student student2 = new Student(3L, "Malika", "Tilek", "malika@gmail.com", 20, 79);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentRepository.saveAll(studentList);
        System.out.println("the first method: " + studentRepository.findAllByAge(20).toString());
        System.out.println("the second method: " + studentRepository.findByFirstName("Adam").toString());

        School school = new School(1L, "KTL", 800);
        School school1 = new School(2L, "NISH", 900);
        School school2 = new School(3L, "RfMsh", 500);
        schoolRepository.save(school);
        schoolRepository.save(school1);
        schoolRepository.save(school2);
        System.out.println("the third method: " + schoolRepository.findSchoolBySchoolName("NISH"));
        System.out.println("the fourth method: " + schoolRepository.getAmountOfStudents(2L));

    }
}
