package doit.jpastudy2.Jparepository;

import doit.jpastudy2.JpaRepository.Synergy;
import doit.jpastudy2.JpaRepository.SynergyRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

@Transactional
@SpringBootTest
public class SynergyRepositoryTest {
    private SynergyRepository synergyRepository;

    void test() {
        Synergy synergy1 = Synergy.builder()
                .name("벌꿀술사")
                .max_activate(7)
                .build();

        Synergy synergy2 = Synergy.builder()
                .name("요새")
                .max_activate(6)
                .build();

        Synergy synergy3 = Synergy.builder()
                .name("쇄도자")
                .max_activate(9)
                .build();

        synergyRepository.save(synergy1);
        synergyRepository.save(synergy2);
        synergyRepository.save(synergy3);

        Synergy synergyTest = synergyRepository.findByName("벌꿀술사");
        Synergy synergyTest2 = synergyRepository.findByMaxActivate(9);
        Synergy synergyTest3 = synergyRepository.findByNameAndMaxActivate("쇄도자", 9);
        Synergy synergyTest4 = synergyRepository.findByName("서리");

        Assertions.assertThat(synergyTest).isNull();
        Assertions.assertThat(synergyTest2).isNull();
        Assertions.assertThat(synergyTest3).isNull();
        Assertions.assertThat(synergyTest4).isNotNull();

        System.out.println("First synergy in DB : " + synergy1.getName());
        System.out.println("Second synergy in DB : " + synergy2.getName());
        System.out.println("Third synergy in DB : " + synergy3.getName());
    }
}
