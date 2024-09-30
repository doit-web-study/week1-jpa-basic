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
class PlayerRepositoryTest {

    @Autowired // 스프링이 관리하는 빈을 주입받는다.
    private PlayerRepository PlayerRepository;

    @DisplayName("save 테스트")
    @Test
    void test() {
        // Given
        Player player1 = Player.builder()
                .name("이상혁")
                .line("미드")
                .teamId(1)
                .teamName("T1")
                .build();

        Player player2 = Player.builder()
                .name("김수환")
                .line("원딜")
                .teamId(2)
                .teamName("젠지")
                .build();

        Player player3 = Player.builder()
                .name("김건부")
                .line("정글")
                .teamId(2)
                .teamName("젠지")
                .build();

        Player player4 = Player.builder()
                .name("허수")
                .line("미드")
                .teamId(4)
                .teamName("DK")
                .build();

        Player player5 = Player.builder()
                .name("한왕호")
                .line("정글")
                .teamId(3)
                .teamName("한화생명")
                .build();

        // When
        PlayerRepository.save(player1);
        PlayerRepository.save(player2);
        PlayerRepository.save(player3);
        PlayerRepository.save(player4);
        PlayerRepository.save(player5);

        // Then
        List<Player> Players = PlayerRepository.findAll();
        Assertions.assertThat(Players).hasSize(5);
        Assertions.assertThat(Players.get(0).getLine()).isEqualTo("미드");
        Assertions.assertThat(Players.get(3).getName()).isEqualTo("허수");
    }

    @DisplayName("Description을 이용한 조회")
    @Test
    void findByRanking() {
        // Given
        Player player1 = Player.builder()
                .name("이상혁")
                .line("미드")
                .teamId(1)
                .teamName("T1")
                .build();

        Player player2 = Player.builder()
                .name("김수환")
                .line("원딜")
                .teamId(2)
                .teamName("젠지")
                .build();

        Player player3 = Player.builder()
                .name("김건부")
                .line("정글")
                .teamId(2)
                .teamName("젠지")
                .build();

        Player player4 = Player.builder()
                .name("허수")
                .line("미드")
                .teamId(4)
                .teamName("DK")
                .build();

        Player player5 = Player.builder()
                .name("한왕호")
                .line("정글")
                .teamId(3)
                .teamName("한화생명")
                .build();

        PlayerRepository.save(player1);
        PlayerRepository.save(player2);
        PlayerRepository.save(player3);
        PlayerRepository.save(player4);
        PlayerRepository.save(player5);

        // When
        Player result1 = PlayerRepository.findByName("이상혁");
        Player result2 = PlayerRepository.findByName("한왕호");

        // Then
        Assertions.assertThat(result1).isNull(); //fail
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result2.getTeamName()).isEqualTo("한화생명");
    }

    @DisplayName("name과 line을 이용한 조회")
    @Test
    void findByNameAndLine() {
        // Given
        Player player1 = Player.builder()
                .name("이상혁")
                .line("미드")
                .teamId(1)
                .teamName("T1")
                .build();

        Player player2 = Player.builder()
                .name("김수환")
                .line("원딜")
                .teamId(2)
                .teamName("젠지")
                .build();

        Player player3 = Player.builder()
                .name("김건부")
                .line("정글")
                .teamId(2)
                .teamName("젠지")
                .build();

        Player player4 = Player.builder()
                .name("허수")
                .line("미드")
                .teamId(4)
                .teamName("DK")
                .build();

        Player player5 = Player.builder()
                .name("한왕호")
                .line("정글")
                .teamId(3)
                .teamName("한화생명")
                .build();

        PlayerRepository.saveAll(List.of(player1, player2, player3, player4, player5));

        // When
        Player result1 = PlayerRepository.findByNameAndLine("김수환","원딜");
        Player result2 = PlayerRepository.findByNameAndLine("노승현", "미드"); // null
        Player result3 = PlayerRepository.findByNameAndLine("허수", "미드");

        // Then
        Assertions.assertThat(result1.getTeamId()).isEqualTo(2);
        Assertions.assertThat(result2).isNull();
        Assertions.assertThat(result3.getTeamName()).isEqualTo("DK");
    }
}