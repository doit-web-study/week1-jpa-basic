package doit.jpastudy2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByNicknameAndPassword(String nickname, String password);

    User findUserByEmail(String email);

    User findAllByNickname(String nickname);
}
