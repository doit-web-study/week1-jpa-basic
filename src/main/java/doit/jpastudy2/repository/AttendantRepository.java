package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepository extends JpaRepository<Attendant, Long> {
    Attendant findByName(String name);
}
