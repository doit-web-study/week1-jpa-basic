package doit.jpastudy2.JpaRepository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Champion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_champion")
    private Long id;

    private String name;

    private Integer cost;

    @Builder
    public Champion(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

}
