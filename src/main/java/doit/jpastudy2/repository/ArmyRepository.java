package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmyRepository extends JpaRepository<Army, Long> {

    // 쿼리 메소드 패턴은 다음과 같다.
    // [ ] = Optional
    // ( ) = 조건
    // find + [ ] + By + (조건)

    Army findByDescription(String description);
    Army findByName(String name);
}
