package doit.jpastudy2.repository;


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
public class PrizeWinner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String item;

    private String name;

    private String email;

    @Builder
    public PrizeWinner(String item, String name, String email) {
        this.item = item;
        this.name = name;
        this.email = email;
    }
}
