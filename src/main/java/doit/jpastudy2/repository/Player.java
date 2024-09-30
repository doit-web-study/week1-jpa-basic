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
public class Player {

    @Id // PK임을 나타낸다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성되는 값임을 나타낸다.
    @Column(name = "player_id") // 컬럼명을 지정한다.
    private Long id;

    private String name;

    private int teamId;

    private String teamName;

    private String line;

    @Builder // 빌더 패턴을 사용할 수 있게 한다.
    public Player(String teamName, String name, String line, int teamId) {
        this.teamName = teamName;
        this.name = name;
        this.line = line;
        this.teamId = teamId;
    }
}
