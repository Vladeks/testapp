package com.vladeks.testapp.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(columnDefinition = "text")
    private String text;

//    @NotBlank
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToMany(
            cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Set<Answer> answers = new HashSet<>();

    public Question() {
    }

    public Question(@NotBlank String text, @NotBlank QuestionType type) {
        this.text = text;
        this.type = type;
    }

    public Question(@NotBlank String text, @NotBlank QuestionType type, Set<Answer> answers) {
        this.text = text;
        this.type = type;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    @JsonCreator
    public void setType(String type) {
        this.type = QuestionType.valueOf(type);
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
