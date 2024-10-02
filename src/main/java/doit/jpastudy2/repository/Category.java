package doit.jpastudy2.repository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Category {

    @Id // PK임을 나타낸다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성되는 값임을 나타낸다.
    @Column(name = "category_id") // 컬럼명을 지정한다.
    private Long id;

    // @Column(name = "type")이 생략된 경우 필드명이 컬럼명이 된다. snake_case로 변환된다.
    private String type;

    // @Column(name = "description")이 생략된 경우 필드명이 컬럼명이 된다.
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Food> foods = new ArrayList<>();

    @Builder // 빌더 패턴을 사용할 수 있게 한다.
    private Category(String description, String type) {
        this.description = description;
        this.type = type;
    }

    public static Category create(String description, String type) {
        return Category.builder()
                .description(description)
                .type(type)
                .build();
    }
}
