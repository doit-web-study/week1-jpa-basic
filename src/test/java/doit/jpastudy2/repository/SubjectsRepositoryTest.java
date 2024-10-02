package doit.jpastudy2.repository;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Transactional
@SpringBootTest
class SubjectsRepositoryTest {
    @Autowired
    private SubjectsRepository subjectsRepository;

    @DisplayName("save test")
    @Test
    void test(){
        Subjects subjects1 = Subjects.builder()
                .name("컴퓨터 네트워크")
                .unit("3")
                .build();
        Subjects subjects2 = Subjects.builder()
                .name("데이터베이스")
                .unit("3")
                .build();
        Subjects subjects3 = Subjects.builder()
                .name("네트워크 소프트웨어")
                .unit("3")
                .build();
        Subjects subjects4 = Subjects.builder()
                .name("컴퓨터프로그래밍및실습")
                .unit("4")
                .build();

        subjectsRepository.save(subjects1);
        subjectsRepository.save(subjects2);
        subjectsRepository.save(subjects3);
        subjectsRepository.save(subjects4);

        List<Subjects> subjects = subjectsRepository.findAll();
        Assertions.assertThat(subjects).hasSize(4);
        Assertions.assertThat(subjects.get(2).getName()).isEqualTo("네트워크 소프트웨어");
        Assertions.assertThat(subjects.get(2).getUnit()).isEqualTo("3");

        System.out.println("2번째 과목 이름 : " + subjects.get(2).getName());
    }

    @DisplayName("Name을 이용한 조회")
    @Test
    void findByName(){
        Subjects subjects1 = Subjects.builder()
                .name("컴퓨터 네트워크")
                .unit("3")
                .build();
        Subjects subjects2 = Subjects.builder()
                .name("데이터베이스")
                .unit("3")
                .build();
        Subjects subjects3 = Subjects.builder()
                .name("네트워크 소프트웨어")
                .unit("3")
                .build();
        Subjects subjects4 = Subjects.builder()
                .name("컴퓨터프로그래밍및실습")
                .unit("4")
                .build();

        subjectsRepository.save(subjects1);
        subjectsRepository.save(subjects2);
        subjectsRepository.save(subjects3);
        subjectsRepository.save(subjects4);

        Subjects result1 = subjectsRepository.findByName("데이터베이");
        Subjects result2 = subjectsRepository.findByName("컴퓨터프로그래밍및실습");

        Assertions.assertThat(result1).isNull();
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result2.getName()).isEqualTo("컴퓨터프로그래밍및실습");
    }

//    @DisplayName("description과 type을 이용한 조회")
//    @Test
//    void findByTypeAndDescription() {
//        // Given
//        Category category1 = Category.builder()
//                .type("양식")
//                .description("데이트")
//                .build();
//
//        Category category2 = Category.builder()
//                .type("한식")
//                .description("한국인의 정")
//                .build();
//
//        Category category3 = Category.builder()
//                .type("중식")
//                .description("철가방")
//                .build();
//
//        Category category4 = Category.builder()
//                .type("미식")
//                .description("축구ㅋㅋ")
//                .build();
//
//        categoryRepository.saveAll(List.of(category1, category2, category3, category4));
//
//        // When
//        Category result1 = categoryRepository.findByTypeAndDescription("양식", "데이트");
//        Category result2 = categoryRepository.findByTypeAndDescription("중식", "데이트"); // null
//        Category result3 = categoryRepository.findByTypeAndDescription("미식", "축구ㅋㅋ");
//
//        // Then
//        Assertions.assertThat(result1.getType()).isEqualTo("양식");
//        Assertions.assertThat(result2).isNull();
//        Assertions.assertThat(result3.getDescription()).isEqualTo("축구ㅋㅋ");
//    }

}
