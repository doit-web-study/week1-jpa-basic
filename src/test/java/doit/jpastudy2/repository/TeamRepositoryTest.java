package doit.jpastudy2.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional // 테스트 케이스에 이 어노테이션이 있으면, 테스트가 끝나면 롤백을 해준다. ( 데이터베이스 초기화 )
@SpringBootTest // 스프링 컨테이너를 이용한 테스트
class TeamRepositoryTest {

    @Autowired // 스프링이 관리하는 빈을 주입받는다.
    private TeamRepository TeamRepository;

    @DisplayName("save 테스트")
    @Test
    void test() {
        // Given
        Team Team1 = Team.builder()
                .ranking(4)
                .teamName("T1")
                .winningRate(0.61)
                .wins(11)
                .build();

        Team Team2 = Team.builder()
                .ranking(1)
                .teamName("젠지")
                .winningRate(0.94)
                .wins(17)
                .build();
        
        Team Team3 = Team.builder()
                .ranking(2)
                .teamName("한화생명")
                .winningRate(0.78)
                .wins(14)
                .build();
        
        Team Team4 = Team.builder()
                .ranking(3)
                .teamName("DK")
                .winningRate(0.72)
                .wins(13)
                .build();

        // When
        TeamRepository.save(Team1);
        TeamRepository.save(Team2);
        TeamRepository.save(Team3);
        TeamRepository.save(Team4);

        // Then
        List<Team> teams = TeamRepository.findAll();
        Assertions.assertThat(teams).hasSize(4);
        Assertions.assertThat(teams.get(0).getRanking()).isEqualTo(4);
        Assertions.assertThat(teams.get(1).getTeamName()).isEqualTo("젠지");
    }

    @DisplayName("Description을 이용한 조회")
    @Test
    void findByRanking() {
        // Given
        Team Team1 = Team.builder()
                .ranking(4)
                .teamName("T1")
                .winningRate(0.61)
                .wins(11)
                .build();

        Team Team2 = Team.builder()
                .ranking(1)
                .teamName("젠지")
                .winningRate(0.94)
                .wins(17)
                .build();

        Team Team3 = Team.builder()
                .ranking(2)
                .teamName("한화생명")
                .winningRate(0.78)
                .wins(14)
                .build();

        Team Team4 = Team.builder()
                .ranking(3)
                .teamName("DK")
                .winningRate(0.72)
                .wins(13)
                .build();

        TeamRepository.save(Team1);
        TeamRepository.save(Team2);
        TeamRepository.save(Team3);
        TeamRepository.save(Team4);

        // When
        Team result1 = TeamRepository.findByRanking(1);
        Team result2 = TeamRepository.findByRanking(4);

        // Then
        Assertions.assertThat(result1).isNull(); //fail
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result2.getTeamName()).isEqualTo("T1");
    }

    @DisplayName("description과 type을 이용한 조회")
    @Test
    void findByTeamNameAndRanking() {
        // Given
        Team Team1 = Team.builder()
                .ranking(4)
                .teamName("T1")
                .winningRate(0.61)
                .wins(11)
                .build();

        Team Team2 = Team.builder()
                .ranking(1)
                .teamName("젠지")
                .winningRate(0.94)
                .wins(17)
                .build();

        Team Team3 = Team.builder()
                .ranking(2)
                .teamName("한화생명")
                .winningRate(0.78)
                .wins(14)
                .build();

        Team Team4 = Team.builder()
                .ranking(3)
                .teamName("DK")
                .winningRate(0.72)
                .wins(13)
                .build();

        TeamRepository.saveAll(List.of(Team1, Team2, Team3, Team4));

        // When
        Team result1 = TeamRepository.findByTeamNameAndRanking("한화생명",2);
        Team result2 = TeamRepository.findByTeamNameAndRanking("KT", 5); // null
        Team result3 = TeamRepository.findByTeamNameAndRanking("DK", 3);

        // Then
        Assertions.assertThat(result1.getWins()).isEqualTo(14);
        Assertions.assertThat(result2).isNull();
        Assertions.assertThat(result3.getRanking()).isEqualTo(3);
    }
}