package ru.testingapplication.MainTestingApplication.models;

import javax.persistence.*;

@Entity
@Table(name = "answeroption")
public class AnswerOption {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "option_text")
    private String option_text;
    @Column(name = "is_right")
    private Boolean is_right;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Question question;

    public String getOption_text() {
        return option_text;
    }

    public void setOption_text(String option_text) {
        this.option_text = option_text;
    }

    public Boolean getIs_right() {
        return is_right;
    }

    public void setIs_right(Boolean is_right) {
        this.is_right = is_right;
    }

    public int getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public AnswerOption(){}

    public AnswerOption(String option_text, Boolean is_right, Question question) {
        this.option_text = option_text;
        this.is_right = is_right;
        this.question = question;
    }
}
