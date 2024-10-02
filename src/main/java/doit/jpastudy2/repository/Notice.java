package doit.jpastudy_hw.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String writer;

    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id")  // 외래 키 설정
    private Category category;

    public Notice(String writer, String title, Category category) {
        this.writer = writer;
        this.title = title;
        this.category = category;
    }
}
