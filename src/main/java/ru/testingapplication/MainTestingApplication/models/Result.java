package ru.testingapplication.MainTestingApplication.models;

import javax.persistence.*;

@Entity
@Table(name = "Result")
public class Result {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "score")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Result(Integer score, Person person, Test test) {
        this.score = score;
        this.person = person;
        this.test = test;
    }

    public Result() {

    }
}
