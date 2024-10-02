package doit.jpastudy_hw.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "category_id")
    private Long id;

    private String subject;

    public Category(String subject) {
        this.subject = subject;
    }
}
