package doit.jpastudy2.repository;

import static org.junit.jupiter.api.Assertions.*;

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
    private CategoryRepository categoryRepository;

    @DisplayName("save 테스트")
    @Test
    void test() {
        // Given
        Category category1 = Category.builder()
                .exercise("수영")
                .time("30분")
                .cORw("유산소")
                .place("수영장")
                .build();

        Category category2 = Category.builder()
                .exercise("탁구")
                .time("30분")
                .cORw("유산소")
                .place("탁구장")
                .build();

        Category category3 = Category.builder()
                .exercise("볼링")
                .time("20분")
                .cORw("근력")
                .place("볼링장")
                .build();

        Category category4 = Category.builder()
                .exercise("클라이밍")
                .time("60분")
                .cORw("근력")
                .place("클라이밍장")
                .build();

        // When
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);

        // Then
        List<Category> categories = categoryRepository.findAll();
        Assertions.assertThat(categories).hasSize(2);
        Assertions.assertThat(categories.get(0).getPlace()).isEqualTo("탁구장");
        Assertions.assertThat(categories.get(0).getCORw()).isEqualTo("근력");
    }

    @DisplayName("유산소/근력을 이용한 조회")
    @Test
    void findByCORw() {
        // Given
        Category category1 = Category.builder()
                .exercise("수영")
                .time("30분")
                .cORw("유산소")
                .place("수영장")
                .build();

        Category category2 = Category.builder()
                .exercise("탁구")
                .time("30분")
                .cORw("유산소")
                .place("탁구장")
                .build();

        Category category3 = Category.builder()
                .exercise("볼링")
                .time("20분")
                .cORw("근력")
                .place("볼링장")
                .build();

        Category category4 = Category.builder()
                .exercise("클라이밍")
                .time("1시간")
                .cORw("근력")
                .place("클라이밍장")
                .build();

        // When
        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);

        // When
        Category result1 = categoryRepository.findByCORw("근력");
        Category result2 = categoryRepository.findByCORw("유산소");

        // Then
        Assertions.assertThat(result1).isNull();
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result1.getPlace()).isEqualTo("수영장");
    }
}