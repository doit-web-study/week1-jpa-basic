package doit.jpastudy2.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SynergyRepository extends JpaRepository<Synergy,Long> {

    Synergy findByName(String name);

    Synergy findByMaxActivate(Integer maxActivate);

    Synergy findByNameAndMaxActivate(String name, Integer maxActivate);
}
