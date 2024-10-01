package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrizeWinnerRepository extends JpaRepository<PrizeWinner, Long> {

    PrizeWinner findByNameAndItem(String name, String item);
}
