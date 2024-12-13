package com.app.quiz.Service;


import com.app.quiz.Model.QuestionDTO;
import com.app.quiz.Model.QuizResult;
import com.app.quiz.Model.Question;
import com.app.quiz.Model.AnswerRequest;
import com.app.quiz.Repository.AnswerRequestRepository;
import com.app.quiz.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRequestRepository answerRequestRepository;

    // Get all questions from the database
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findQuestions();
    }

    // Get a specific question by ID
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    // Save the answers submitted by the user
    public void saveUserAnswers(List<AnswerRequest> answers) {
        answerRequestRepository.saveAll(answers);
    }


    public QuizResult evaluateQuiz() {
        List<AnswerRequest> submittedAnswers = answerRequestRepository.findAll();
        int correctCount = 0;

        // Iterate over each answer and compare it with the correct option
        for (AnswerRequest answer : submittedAnswers) {
            Question question = questionRepository.findById(answer.getQuestionId()).orElse(null);
            if (question != null && question.getCorrect_Option().equals(answer.getSelectedOption())) {
                correctCount++;
            }
        }

        // Calculate the total number of questions and the score
        int totalQuestions = questionRepository.findAll().size();
        double score = ((double) correctCount / totalQuestions) * 100;

        // Return the quiz result
        QuizResult result = new QuizResult();
        result.setTotalQuestions(totalQuestions);
        result.setCorrectAnswers(correctCount);
        result.setScore(score);
        return result;
    }
}
