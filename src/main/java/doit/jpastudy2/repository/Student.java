package doit.jpastudy2.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private Date DateOfBirth;

    public Student(int studentId, String studentName, Date dateOfBirth) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.DateOfBirth = dateOfBirth;
    }
}
