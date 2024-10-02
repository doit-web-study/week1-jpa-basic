package doit.jpastudy2.repository;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Attendant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "n주차")
    private int id;

    @Column(name = "이름")
    private String name;

    @Column(name = "출석")
    private String attendance;

    @Column(name = "지각")
    private String late;

    @Column(name = "결석")
    private String absence;

    @Builder
    public Attendant(String name, String attendance, String late, String absence) {
        this.name = name;
        this.attendance = attendance;
        this.late = late;
        this.absence = absence;
    }


}
