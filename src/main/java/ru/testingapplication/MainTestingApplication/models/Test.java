package ru.testingapplication.MainTestingApplication.models;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "test_name")
    private String test_name;

    @Column(name = "test_duration")
    private Time test_duration;

    @OneToMany(mappedBy = "test")
    private List<Question> questions;

    @OneToMany(mappedBy = "test")
    private List<Result> results;
    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public String getTestName() {
        return test_name;
    }

    public void setTestName(String test_name) {
        this.test_name = test_name;
    }

    public Time getTestDuration() {
        return test_duration;
    }

    public void setTestDuration(Time test_duration) {
        this.test_duration = test_duration;
    }

    public int getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Test(String test_name, Time test_duration,
                List<Question> questions, Course course, Department department) {
        this.test_name = test_name;
        this.test_duration = test_duration;
        this.questions = questions;
        this.course = course;
        this.department = department;
    }

    public Test() {

    }
}
