package doit.jpastudy2.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Professor {

    @Id // PK임을 나타낸다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성되는 값임을 나타낸다.
    @Column(name = "prof_id") // 컬럼명을 지정한다.
    private Long id;

    // @Column(name = "type")이 생략된 경우 필드명이 컬럼명이 된다. snake_case로 변환된다.
    @Column(name = "prof_name")
    private String name;

    // @Column(name = "description")이 생략된 경우 필드명이 컬럼명이 된다.
    @Column(name = "prof_email")
    private String email;

    @Builder // 빌더 패턴을 사용할 수 있게 한다.
    public Professor(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
