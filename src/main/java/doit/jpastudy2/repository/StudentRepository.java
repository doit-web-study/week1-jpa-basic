package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import doit.jpastudy2.repository.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentId(String studentId);
}
