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
class ProfessorRepositoryTest {
    @Autowired
    private ProfessorRepository professorRepository;

    @DisplayName("save test")
    @Test
    void test(){
        Professor professor1 = Professor.builder()
                .name("노병희")
                .email("rbh@ajou.ac.kr")
                .build();
        Professor professor2 = Professor.builder()
                .name("조현석")
                .email("jhs@ajou.ac.kr")
                .build();
        Professor professor3 = Professor.builder()
                .name("이슬")
                .email("cham@ajou.ac.kr")
                .build();
        Professor professor4 = Professor.builder()
                .name("변광준")
                .email("bkj@ajou.ac.kr")
                .build();

        professorRepository.save(professor1);
        professorRepository.save(professor2);
        professorRepository.save(professor3);
        professorRepository.save(professor4);

        List<Professor> professors = professorRepository.findAll();
        Assertions.assertThat(professors).hasSize(4);
        Assertions.assertThat(professors.get(2).getName()).isEqualTo("이슬");
        Assertions.assertThat(professors.get(2).getEmail()).isEqualTo("cham@ajou.ac.kr");

        System.out.println("2번째 교수 이름 : " + professors.get(2).getName());
    }

    @DisplayName("Name을 이용한 조회")
    @Test
    void findByName(){
        Professor professor1 = Professor.builder()
                .name("노병희")
                .email("rbh@ajou.ac.kr")
                .build();
        Professor professor2 = Professor.builder()
                .name("조현석")
                .email("jhs@ajou.ac.kr")
                .build();
        Professor professor3 = Professor.builder()
                .name("이슬")
                .email("cham@ajou.ac.kr")
                .build();
        Professor professor4 = Professor.builder()
                .name("변광준")
                .email("bkj@ajou.ac.kr")
                .build();

        professorRepository.save(professor1);
        professorRepository.save(professor2);
        professorRepository.save(professor3);
        professorRepository.save(professor4);

        Professor result1 = professorRepository.findByName("노병희");
        Professor result2 = professorRepository.findByName("조현석");

        Assertions.assertThat(result1).isNull();
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result2.getName()).isEqualTo("노병희");
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
