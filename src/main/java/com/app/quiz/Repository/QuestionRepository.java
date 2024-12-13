package com.app.quiz.Repository;

import com.app.quiz.Model.Question;
import com.app.quiz.Model.QuestionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT new com.app.quiz.Model.QuestionDTO(q.id, q.question, q.option_A, q.option_B, q.option_C, q.option_D) FROM Question q")
    List<QuestionDTO> findQuestions();
}
