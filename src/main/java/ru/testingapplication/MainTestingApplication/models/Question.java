package ru.testingapplication.MainTestingApplication.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_name")
    private String question_name;

    @Column(name = "question_text")
    private String question_text;

    @Column(name = "question_cost")
    private Integer question_cost;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test test;

    @OneToMany(mappedBy = "question")
    private List<AnswerOption> options;

    @ManyToOne
    @JoinColumn(name = "question_type_id", referencedColumnName = "id")
    private QuestionType questionType;

    public void setOptions(List<AnswerOption> options) {
        this.options = options;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public String getQuestionName() {
        return question_name;
    }

    public void setQuestionName(String question_name) {
        this.question_name = question_name;
    }

    public String getQuestionText() {
        return question_text;
    }

    public int getId() {
        return id;
    }

    public void setQuestionText(String question_text) {
        this.question_text = question_text;
    }

    public Integer getQuestionCost() {
        return question_cost;
    }

    public void setQuestionCost(Integer question_cost) {
        this.question_cost = question_cost;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Question() {

    }

    public Question(String question_name, String question_text,
                    Integer question_cost, Test test, QuestionType questionType) {
        this.question_name = question_name;
        this.question_text = question_text;
        this.question_cost = question_cost;
        this.test = test;
        this.questionType = questionType;
    }
}
