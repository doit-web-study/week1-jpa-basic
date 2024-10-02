package doit.jpastudy2.JpaRepository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Synergy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_synergy")
    private Long id;

    private String name;

    private Integer max_activate;

    @Builder
    public Synergy(String name, Integer max_activate) {
        this.name = name;
        this.max_activate = max_activate;
    }
}
