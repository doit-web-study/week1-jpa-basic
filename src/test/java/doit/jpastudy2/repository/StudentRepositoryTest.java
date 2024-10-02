package doit.jpastudy2.repository;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Transactional
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void test(){
        Student student1 = Student.builder()
                .grade(4)
                .major("사이버보안학과")
                .build();

        studentRepository.save(student1);

        List<Student> students = studentRepository.findAll();
        Assertions.assertThat(students).hasSize(1);
        Assertions.assertThat(students.get(0).getGrade()).isEqualTo(4);
    }
    @Test
    void findByEmail() {
        Student student1 = Student.builder()
                .grade(4)
                .email("gmlwns904@ajou.ac.kr")
                .build();

        Student student2 = Student.builder()
                .grade(3)
                .email("wnsgml409@ajou.ac.kr")
                .build();

        studentRepository.save(student1);
        studentRepository.save(student2);

        Student result1 = studentRepository.findByEmail("gmlwns904@ajou.ac.kr");
        Student result2 = studentRepository.findByEmail("gmlwns904@ajou.ac.kr");

        Assertions.assertThat(result1).isNotNull();
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result2).isNotEqualTo("gmlwns904@ajou.ac.kr");

    }
}