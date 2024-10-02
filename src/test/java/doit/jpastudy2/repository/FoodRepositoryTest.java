package doit.jpastudy2.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class FoodRepositoryTest {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @DisplayName("Food save 테스트")
    @Test
    void foodSave() {
        // Given
        Food food1 = Food.create("피자", 5, "피자엔 맥주", null);
        Food food2 = Food.create("치킨", 4, "치킨에도 맥주", null);

        // When
        foodRepository.saveAll(List.of(food1, food2));

        // Then
        List<Food> foods = foodRepository.findAll();
        Assertions.assertThat(foods).hasSize(2);
        Assertions.assertThat(foods)
                .extracting("name", "rate")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("피자", 5),
                        Tuple.tuple("치킨", 4)
                );
    }

    @DisplayName("Food, Category 연관관계 테스트")
    @Test
    void foodSaveWithCategory() {
        // Given
        Category category = Category.create("데이트", "양식");
        Food food1 = Food.create("피자", 5, "양식", category);
        Food food2 = Food.create("치킨", 4, "치킨", category);

        // When
        categoryRepository.save(category); // Category만 저장해도 CascadeType.ALL로 인해 Food도 저장된다.

        // Then
        List<Food> foods = foodRepository.findAll();
        Category dateCategory = categoryRepository.findByDescription("데이트");

        Assertions.assertThat(foods).hasSize(2);
        Assertions.assertThat(foods)
                .extracting("name", "rate", "category")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("피자", 5, dateCategory),
                        Tuple.tuple("치킨", 4, dateCategory)
                );
    }

    @DisplayName("findFoodsByCategory 테스트")
    @Test
    void findFoodsByCategory() {
        // Given
        Category category1 = Category.create("철가방", "중식");
        Category category2 = Category.create("데이트", "양식");
        Food food1 = Food.create("짜장면", 3, "짜장엔 볶음밥", category1);
        Food food2 = Food.create("짬뽕", 4, "짬뽕은 해장", category1);
        Food food3 = Food.create("파스타", 5, "파스타엔 와인", category2);

        categoryRepository.saveAll(List.of(category1, category2));

        // When
        List<Food> foods = foodRepository.findFoodsByCategory(category1);

        // Then
        Assertions.assertThat(foods).hasSize(2);
        Assertions.assertThat(foods)
                .extracting("name", "rate", "category")
                .containsExactlyInAnyOrder(
                        Tuple.tuple("짜장면", 3, category1),
                        Tuple.tuple("짬뽕", 4, category1)
                );
    }
}