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
public class Army {

    @Id // PK임을 나타낸다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성되는 값임을 나타낸다.

    @Column(name = "군번") // 컬럼명을 지정한다.
    private int id;

    @Column(name = "이름")
    private String name;

    @Column(name="부대")
    private String militaryUnit;

    @Column(name = "보직")
    private String description;

    @Builder // 빌더 패턴을 사용할 수 있게 한다.
    public Army(String name, String militaryUnit, String description) {
        this.name = name;
        this.militaryUnit = militaryUnit;
        this.description = description;
    }
}
