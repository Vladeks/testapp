package com.vladeks.testapp.controller;

import com.vladeks.testapp.model.Answer;
import com.vladeks.testapp.model.Question;
import com.vladeks.testapp.repository.AnswerRepository;
import com.vladeks.testapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerRepository answerRepository;

    @PostMapping("/question")
    public Question createQuestion(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PostMapping("/question/")
    public Answer createAnswer(@Valid @RequestBody Answer answer) {
        return answerRepository.save(answer);
    }
}
