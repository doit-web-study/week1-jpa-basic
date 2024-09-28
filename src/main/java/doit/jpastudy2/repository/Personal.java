package doit.jpastudy2.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "employee_id")
    private Long id;

    @Column(name = "salary")
    private int salary;
}
