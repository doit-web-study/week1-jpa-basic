package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 쿼리 메소드 패턴은 다음과 같다.
    // [ ] = Optional
    // ( ) = 조건
    // find + [ ] + By + (조건)

    // select * from Category
    Employee findByFirstName(String firstName);

    // select * from Category where type = ? and description = ?
    Employee findAllByFirstNameAndLastName(String firstName, String lastName);
}

