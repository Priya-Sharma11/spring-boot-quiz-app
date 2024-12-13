package com.app.quiz.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResult {

    private int totalQuestions;
    private int correctAnswers;
    private double score;
}
