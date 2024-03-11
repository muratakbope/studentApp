package kz.singularity.studentapp.Repository;

import kz.singularity.studentapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByFirstName(String firstName);

    List<Student> findAllByAge(long age);
}
