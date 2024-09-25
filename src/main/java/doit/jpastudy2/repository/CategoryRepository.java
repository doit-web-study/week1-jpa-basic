package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // 쿼리 메소드 패턴은 다음과 같다.
    // [ ] = Optional
    // ( ) = 조건
    // find + [ ] + By + (조건)

    // select * from Category
    Category findByDescription(String description);

    // select * from Category where type = ? and description = ?
    Category findByTypeAndDescription(String type, String description);
}
