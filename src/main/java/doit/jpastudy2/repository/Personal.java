package doit.jpastudy2.repository;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="군번")
    private int id;

    @Column(name = "출생년도")
    private int birthYear;

    @Column(name = "생일")
    private int birthDay;

    @Column(name="전화번호")
    private String phoneNumber;

}
