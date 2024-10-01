package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

    // 쿼리 메소드 패턴은 다음과 같다.
    // [ ] = Optional
    // ( ) = 조건
    // find + [ ] + By + (조건)

    // select * from Category
    School findBySchoolName(String schoolName);
    // select * from Category where type = ? and description = ?
    School findBySchoolNameAndTotalStudents(String schoolName, int totalStudents);

}
