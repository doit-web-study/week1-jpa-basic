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
class AttendantRepositoryTest {

    @Autowired
    private AttendantRepository attendantRepository;

    @DisplayName("save 테스트")
    @Test
    void test(){
        Attendant atd1 = Attendant.builder()
                .attendance("O")
                .build();

        Attendant atd2 = Attendant.builder()
                .absence("O")
                .build();

        attendantRepository.save(atd1);
        attendantRepository.save(atd2);

        List<Attendant> attendants = attendantRepository.findAll();
        Assertions.assertThat(attendants).hasSize(2);
        Assertions.assertThat(attendants.get(0).getAttendance()).isEqualTo("O");
    }

    @Test
    void findByName() {
        Attendant atd1 = Attendant.builder()
                .name("고희준")
                .build();

        Attendant atd2 = Attendant.builder()
                .name("준희고")
                .build();

        attendantRepository.saveAll(List.of(atd1, atd2));

        Attendant result1 = attendantRepository.findByName("희준고");
        Attendant result2 = attendantRepository.findByName("준희고");
        Attendant result3 = attendantRepository.findByName("준희고");

        Assertions.assertThat(result1).isNull();
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result3.getName()).isEqualTo("준희고");



    }
}