package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    // 쿼리 메소드 패턴은 다음과 같다.
    // [ ] = Optional
    // ( ) = 조건
    // find + [ ] + By + (조건)

    // select * from Category
    Team findByRanking(int ranking);

    // select * from Category where type = ? and description = ?
    Team findByTeamNameAndRanking(String teamName, int ranking);
}
