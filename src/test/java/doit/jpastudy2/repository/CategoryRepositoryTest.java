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
class CategoryRepositoryTest {

    @Autowired // 스프링이 관리하는 빈을 주입받는다.
    private ArmyRepository categoryRepository;

    @DisplayName("save 테스트")
    @Test
    void test() {
        // Given
        Army army1 = Army.builder()
                .description("이발병")
                .build();

        Army army2 = Army.builder()
                .description("통신병")
                .build();

        // When
        categoryRepository.save(army1);
        categoryRepository.save(army2);

        // Then
        List<Army> categories = categoryRepository.findAll();
        Assertions.assertThat(categories).hasSize(2);
        Assertions.assertThat(categories.get(0).getDescription()).isEqualTo("통신병");
    }

    @DisplayName("Description을 이용한 조회")
    @Test
    void findByDescription() {
        // Given
        Army army1 = Army.builder()
                .description("행정병")
                .build();

        Army army2 = Army.builder()
                .description("운전병")
                .build();

        categoryRepository.save(army1);
        categoryRepository.save(army2);

        // When
        Army result1 = categoryRepository.findByDescription("행정병");
        Army result2 = categoryRepository.findByDescription("운전병");

        // Then
        Assertions.assertThat(result1).isNull();
        Assertions.assertThat(result2).isNotNull();
    }

    @DisplayName("name을 이용한 조회")
    @Test
    void findByName() {
        // Given
        Army army1 = Army.builder()
                .Name("박준혁")
                .build();

        Army army2 = Army.builder()
                .Name("노승현")
                .build();

        Army army3 = Army.builder()
                .Name("설만수")
                .build();

        Army army4 = Army.builder()
                .Name("현서호")
                .build();


        categoryRepository.saveAll(List.of(army1, army2, army3, army4));

        // When
        Army result1 = categoryRepository.findByName("오단비");
        Army result2 = categoryRepository.findByName("박준혁");
        Army result3 = categoryRepository.findByName("노승현");

        // Then
        Assertions.assertThat(result2).isNull();
        Assertions.assertThat(result3.getDescription()).isEqualTo("노승현");
    }
}