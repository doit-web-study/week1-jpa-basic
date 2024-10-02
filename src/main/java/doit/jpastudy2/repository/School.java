package doit.jpastudy2.repository;

import jakarta.persistence.Column;
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
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "School_id")
    private Long id;

    @Column(name = "School_name")
    private String schoolName;

    @Column(name = "Total_students")
    private int totalStudents;

    @Column(name = "Average_grade")
    private double averageGrade;

    @Builder
    public School(String schoolName, int totalStudents, double averageGrade) {
        this.schoolName = schoolName;
        this.totalStudents = totalStudents;
        this.averageGrade = averageGrade;
    }
}