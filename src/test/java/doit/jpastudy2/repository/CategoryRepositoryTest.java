package doit.jpastudy_hw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CategoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void test(){
        Category category = new Category("축구");
        categoryRepository.save(category);

        List<Category> categories = categoryRepository.findAll();
        System.out.println("categories = " + categories.get(0));
        System.out.println("categories = " + categories.get(0).getSubject());
    }
}