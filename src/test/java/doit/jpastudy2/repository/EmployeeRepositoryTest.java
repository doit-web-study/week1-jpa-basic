package doit.jpastudy2.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional // 테스트 케이스에 이 어노테이션이 있으면, 테스트가 끝나면 롤백을 해준다. ( 데이터베이스 초기화 )
@SpringBootTest // 스프링 컨테이너를 이용한 테스트
class EmployeeRepositoryTest {

    @Autowired // 스프링이 관리하는 빈을 주입받는다.
    private EmployeeRepository employeeRepository;

    @DisplayName("save 테스트")
    @Test
    void test() {
        // Given
        Employee employee1 = Employee.builder()
                .firstName("민")
                .lastName("경준")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("김")
                .lastName("주성")
                .build();

        // When
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        // Then
        List<Employee> categories = employeeRepository.findAll();
        Assertions.assertThat(categories).hasSize(2);
        Assertions.assertThat(categories.get(0).getFirstName()).isEqualTo("김");
        Assertions.assertThat(categories.get(0).getLastName()).isEqualTo("주성");
    }

    @DisplayName("firstName을 이용한 조회")
    @Test
    void findByDescription() {
        // Given
        Employee employee1 = Employee.builder()
                .firstName("민")
                .lastName("경준")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("김")
                .lastName("주성")
                .build();

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        // When
        Employee result1 = employeeRepository.findByFirstName("민");
        Employee result2 = employeeRepository.findByFirstName("김");

        // Then
        Assertions.assertThat(result1).isNull();
        Assertions.assertThat(result2).isNotNull();
        Assertions.assertThat(result2.getFirstName()).isEqualTo("김");
    }

    @DisplayName("firstName과 lastName을 이용한 조회")
    @Test
    void findByTypeAndDescription() {
        // Given
        Employee employee1 = Employee.builder()
                .firstName("민")
                .lastName("경준")
                .build();

        Employee employee2 = Employee.builder()
                .firstName("김")
                .lastName("주성")
                .build();

        Employee employee3 = Employee.builder()
                .firstName("강")
                .lastName("범서")
                .build();

        Employee employee4 = Employee.builder()
                .firstName("조")
                .lastName("상래")
                .build();

        employeeRepository.saveAll(List.of(employee1, employee2, employee3, employee4));

        // When
        Employee result1 = employeeRepository.findAllByFirstNameAndLastName("민", "경준");
        Employee result2 = employeeRepository.findAllByFirstNameAndLastName("강", "범서"); // null
        Employee result3 = employeeRepository.findAllByFirstNameAndLastName("조", "상래");

        // Then
        Assertions.assertThat(result1.getFirstName()).isEqualTo("민");
        Assertions.assertThat(result2).isNull();
        Assertions.assertThat(result3.getLastName()).isEqualTo("범서");
    }
}