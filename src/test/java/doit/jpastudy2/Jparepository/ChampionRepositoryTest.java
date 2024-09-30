package doit.jpastudy2.Jparepository;

import doit.jpastudy2.JpaRepository.Champion;
import doit.jpastudy2.JpaRepository.ChampionRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class ChampionRepositoryTest {

    @Autowired
    private ChampionRepository championRepository;

    @Test
    void test() {
        Champion champion1 = Champion.builder()
                .name("누누")
                .cost(2)
                .build();

        Champion champion2 = Champion.builder()
                .name("헤카림")
                .cost(3)
                .build();


        championRepository.save(champion1);
        championRepository.save(champion2);

        Champion championTest = championRepository.findByCost(2);
        Champion championTest2 = championRepository.findByName("헤카림");
        Champion championTest3 = championRepository.findByNameAndCost("누누", 2);
        Champion championTest4 = championRepository.findByCost(5);

        Assertions.assertThat(championTest).isNull();
        Assertions.assertThat(championTest2).isNull();
        Assertions.assertThat(championTest3).isNull();
        Assertions.assertThat(championTest4).isNotNull();

        System.out.println("First champion in DB : " + champion1.getName());
        System.out.println("Second champion in DB : " + champion2.getName());
    }
}
