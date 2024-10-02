package doit.jpastudy2.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_id")
    private Long id;

    private String name;

    @Min(1)
    @Max(5)
    private int rate;

    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Builder
    private Food(String content, int rate, String name, Category category) {
        this.content = content;
        this.rate = rate;
        this.name = name;
        if (category != null) {
            this.category = category;
            category.getFoods().add(this);
        }
    }

    public static Food create(String name, int rate, String content, Category category) {
        return Food.builder()
                .name(name)
                .rate(rate)
                .content(content)
                .category(category)
                .build();
    }

    public void changeCategory(Category category) {
        if (this.category != null) {
            this.category.getFoods().remove(this);
        }

        this.category = category;

        if (category != null) {
            category.getFoods().add(this);
        }
    }
}
