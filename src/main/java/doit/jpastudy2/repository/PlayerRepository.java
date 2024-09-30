package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    // 쿼리 메소드 패턴은 다음과 같다.
    // [ ] = Optional
    // ( ) = 조건
    // find + [ ] + By + (조건)

    // select * from Category
    Player findByName(String name);

    // select * from Category where type = ? and description = ?
    Player findByNameAndLine(String name, String line);
}
