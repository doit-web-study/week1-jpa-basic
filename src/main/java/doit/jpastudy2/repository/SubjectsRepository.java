package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subjects, Long> {
    Subjects findByUnit(String unit);
    Subjects findByName(String name);

    Subjects findByNameAndUnit(String name, String unit);
}
