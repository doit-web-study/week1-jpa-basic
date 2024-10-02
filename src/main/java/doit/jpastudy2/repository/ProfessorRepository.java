package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByEmail(String email);
    Professor findByName(String name);

    Professor findByNameAndEmail(String name, String email);
}
