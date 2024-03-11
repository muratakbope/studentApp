package kz.singularity.studentapp.repository;

import kz.singularity.studentapp.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    School findSchoolBySchoolName(String schoolName);

    @Query("select s.studentNumber from School s where s.id = :id")
    int getAmountOfStudents(int id);
}
