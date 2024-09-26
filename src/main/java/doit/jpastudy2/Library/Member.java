package doit.jpastudy2.Library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;
    private String name;
    @Email
    private String email;
    private String phone;
    private LocalDate joinDate;

    @Builder
    public Member(String name, String email, String phone, LocalDate joinDate) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.joinDate = joinDate;
    }
}
