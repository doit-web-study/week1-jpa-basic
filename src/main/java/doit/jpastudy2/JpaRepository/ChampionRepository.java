package doit.jpastudy2.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionRepository  extends JpaRepository<Champion, Long> {

    Champion findByName(String name);

    Champion findByCost(Integer cost);

    Champion findByNameAndCost(String name, Integer cost);
}
