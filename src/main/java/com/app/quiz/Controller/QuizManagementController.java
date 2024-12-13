package com.app.quiz.Controller;

import com.app.quiz.Model.Question;
import com.app.quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz-management")
public class QuizManagementController {

    @Autowired
    private QuizService quizService;

    // Fetch a specific question by ID
    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = quizService.getQuestionById(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }

    // Reset the quiz (clear answers)
//    @PostMapping("/reset")
//    public ResponseEntity<String> resetQuiz() {
//        quizService.resetQuiz();
//        return ResponseEntity.ok("Quiz has been reset successfully");
//    }
}
