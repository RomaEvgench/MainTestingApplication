package ru.testingapplication.MainTestingApplication.models;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "Coursegroup")
public class Coursegroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "coursegroup")
    private List<Person> people;
    public Coursegroup(){

    }
    public Coursegroup(String name){
        this.name = name;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
