package doit.jpastudy2.repository;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class PrizeWinnerRepositoryTest {

    @Autowired
    private PrizeWinnerRepository prizeWinnerRepository;

    @Test
    void saveTest(){
        PrizeWinner prizeWinner1 = PrizeWinner.builder()
                .item("100만원")
                .name("홍길동")
                .email("asdf@gmail.com")
                .build();

        PrizeWinner prizeWinner2 = PrizeWinner.builder()
                .item("50만원")
                .name("김머머")
                .email("qwer@ajou.ac.kr")
                .build();

        PrizeWinner prizeWinner3 = PrizeWinner.builder()
                .item("30만원")
                .name("박사무엘")
                .email("zxcv@gmail.com")
                .build();

        PrizeWinner prizeWinner4 = PrizeWinner.builder()
                .item("10만원")
                .name("고길동")
                .email("jkl00@naver.com")
                .build();

        prizeWinnerRepository.save(prizeWinner1);
        prizeWinnerRepository.save(prizeWinner2);
        prizeWinnerRepository.save(prizeWinner3);
        prizeWinnerRepository.save(prizeWinner4);

        List<PrizeWinner> all = prizeWinnerRepository.findAll();
        Assertions.assertThat(all.get(0).getItem()).isEqualTo("100만원");
        Assertions.assertThat(all.get(2).getName()).isEqualTo("박사무엘");
    }

    @Test
    void findByNameAndItem(){

        PrizeWinner prizeWinner1 = PrizeWinner.builder()
                .item("100만원")
                .name("홍길동")
                .email("asdf@gmail.com")
                .build();

        PrizeWinner prizeWinner2 = PrizeWinner.builder()
                .item("50만원")
                .name("김머머")
                .email("qwer@ajou.ac.kr")
                .build();

        PrizeWinner prizeWinner3 = PrizeWinner.builder()
                .item("30만원")
                .name("박사무엘")
                .email("zxcv@gmail.com")
                .build();

        PrizeWinner prizeWinner4 = PrizeWinner.builder()
                .item("10만원")
                .name("고길동")
                .email("jkl00@naver.com")
                .build();

        prizeWinnerRepository.saveAll(List.of(prizeWinner1, prizeWinner2, prizeWinner3, prizeWinner4));

        PrizeWinner findWinner1 = prizeWinnerRepository.findByNameAndItem("고길동","10만원");
        PrizeWinner findWinner2 = prizeWinnerRepository.findByNameAndItem("김머머","50만원");

        Assertions.assertThat(findWinner1.getName()).isEqualTo("고길동");
        Assertions.assertThat(findWinner2.getEmail()).isEqualTo("qwer@ajou.ac.kr");
    }
}