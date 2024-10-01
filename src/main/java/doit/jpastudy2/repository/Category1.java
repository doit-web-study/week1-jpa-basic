package doit.jpastudy2.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Category1 {

    @Id // PK임을 나타낸다.
    //@GeneratedValue(strategy = GenerationType.AUTO) // 자동 생성되는 값임을 나타낸다.
    @Column(name = "exercise") // 컬럼명을 지정한다.
    private String exercise;

    // @Column(name = "type")이 생략된 경우 필드명이 컬럼명이 된다. snake_case로 변환된다.
    private String gold;

    // @Column(name = "description")이 생략된 경우 필드명이 컬럼명이 된다.
    private String silver;


    private String bronze;

    @Builder

    public Category1(String exercise, String gold, String silver, String bronze) {
        this.exercise = exercise;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}
