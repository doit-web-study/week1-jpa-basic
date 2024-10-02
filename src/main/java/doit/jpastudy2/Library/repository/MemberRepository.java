package doit.jpastudy2.Library.repository;

import doit.jpastudy2.Library.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public Member findByName(String name);
    public Member findByEmail(String email);
    public Member findByPhone(String phone);
}
