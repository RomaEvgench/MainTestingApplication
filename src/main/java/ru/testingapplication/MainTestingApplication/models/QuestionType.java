package ru.testingapplication.MainTestingApplication.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "QuestionType")
public class QuestionType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_type_name")
    private String question_type_name;

    @OneToMany(mappedBy = "questionType")
    private List<Question> questions;
    public String getQuestionTypeName() {
        return question_type_name;
    }

    public void setQuestionTypeName(String question_type_name) {
        this.question_type_name = question_type_name;
    }

    public QuestionType(String question_type_name) {
        this.question_type_name = question_type_name;
    }

    public QuestionType(){

    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
