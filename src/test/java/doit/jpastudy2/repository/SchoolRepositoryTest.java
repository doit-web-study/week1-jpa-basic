package doit.jpastudy2.repository;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@SpringBootTest
class SchoolRepositoryTest {

    @Autowired
    private SchoolRepository schoolRepository;

    @DisplayName("save 테스트")
    @Test
    void test() {
        // Given
        School school = School.builder()
                .schoolName("아주대학교")
                .totalStudents(13884)
                .averageGrade(4.3)
                .build();

        // When
        schoolRepository.save(school);

        // Then
        Assertions.assertThat(school).isNotNull();
        Assertions.assertThat(school.getSchoolName()).isEqualTo("아주대학교");
        Assertions.assertThat(school.getTotalStudents()).isEqualTo(13884);
    }

    @DisplayName("SchoolName을 이용한 찾기")
    @Test
    void testFindBySchoolName() {
        // Given
        School school = School.builder()
                .schoolName("아주대학교")
                .totalStudents(13884)
                .averageGrade(4.3)
                .build();

        schoolRepository.save(school);

        // When
        School result = schoolRepository.findBySchoolName("아주대학교");

        // Then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getSchoolName()).isEqualTo("아주대학교");
        Assertions.assertThat(result.getTotalStudents()).isEqualTo(13884);
    }

    @DisplayName("SchoolName과 TotalStudent를 이용한 찾기")
    @Test
    void testFindBySchoolNameAndTotalStudents() {
        // Given
        School school1 = School.builder()
                .schoolName("아주대학교")
                .totalStudents(13884)
                .averageGrade(4.3)
                .build();
        School school2 = School.builder()
                .schoolName("서울대학교")
                .totalStudents(35000)
                .averageGrade(4.0)
                .build();
        schoolRepository.saveAll(List.of(school1, school2));

        // When
        School result1 = schoolRepository.findBySchoolNameAndTotalStudents("아주대학교", 13884);
        School result2 = schoolRepository.findBySchoolNameAndTotalStudents("서울대학교", 35000);

        // Then.
        Assertions.assertThat(result1).isNotNull();
        Assertions.assertThat(result2.getSchoolName()).isEqualTo("서울대학교");
        Assertions.assertThat(result2.getTotalStudents()).isEqualTo(35000);
    }
}