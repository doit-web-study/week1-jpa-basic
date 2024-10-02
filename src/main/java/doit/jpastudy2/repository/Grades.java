package doit.jpastudy2.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import doit.jpastudy2.repository.Student;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Grades {
    @Id
    @GeneratedValue
    private int gradeId;

    private String subject;

    @OneToMany(mappedBy="studentId")
    private List<Student> students;

    private String grade;
}
