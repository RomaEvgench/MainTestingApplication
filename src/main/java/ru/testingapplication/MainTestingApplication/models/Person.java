package ru.testingapplication.MainTestingApplication.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "role")
    private String role;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @OneToMany(mappedBy = "person")
    private List<Result> results;
    @ManyToOne
    @JoinColumn(name = "coursegroup_id", referencedColumnName = "id")
    private Coursegroup coursegroup;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Coursegroup getCoursegroup() {
        return coursegroup;
    }

    public void setCoursegroup(Coursegroup coursegroup) {
        this.coursegroup = coursegroup;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getId() {
        return id;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Person(String first_name, String last_name, String patronymic,
                  String role, String password, String username, Department department,
                  Course course, Coursegroup coursegroup) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.role = role;
        this.password = password;
        this.username = username;
        this.department = department;
        this.course = course;
        this.coursegroup = coursegroup;
    }

    public String getFullName(){
        return this.last_name+this.first_name+this.patronymic;
    }
    public Person(){

    }
}
