package doit.jpastudy2.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    // select * from food where category_id = ?
    List<Food> findFoodsByCategory(Category category);
}
