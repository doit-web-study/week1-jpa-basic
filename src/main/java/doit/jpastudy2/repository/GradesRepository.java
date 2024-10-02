package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepository extends JpaRepository {

    Grades findAllBySubject(String subject);
}
