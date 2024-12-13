package com.app.quiz.Controller;

import com.app.quiz.Model.AnswerRequest;
import com.app.quiz.Model.QuestionDTO;
import com.app.quiz.Model.QuizResult;
import com.app.quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService; // Field injection with @Autowired

    // Fetch all questions
    @GetMapping("/questions")
    public ResponseEntity<List<QuestionDTO>> getQuestions() {
        List<QuestionDTO> allQuestions = quizService.getAllQuestions();
        return ResponseEntity.ok(allQuestions);
    }

    // Submit answers for evaluation
    @PostMapping("/submit")
    public ResponseEntity<String> submitAnswers(@RequestBody List<AnswerRequest> answers) {
        quizService.saveUserAnswers(answers);
        return ResponseEntity.ok("Answers submitted successfully");
    }

    // Fetch the result of the quiz
    @GetMapping("/results")
    public ResponseEntity<QuizResult> getQuizResults() {
        QuizResult result = quizService.evaluateQuiz();
        return ResponseEntity.ok(result);
    }
}
