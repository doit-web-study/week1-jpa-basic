package doit.jpastudy2.repository;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    @Column(name = "학번")
    private int id;

    @Column(name = "이름")
    private String name;

    @Column(name = "학년")
    private int grade;

    @Column(name = "학과")
    private String major;

    @Column(name = "메일")
    private String email;

    @Builder
    public Student(String name, int grade, String major, String email) {
        this.name = name;
        this.grade = grade;
        this.major = major;
        this.email = email;
    }

}
