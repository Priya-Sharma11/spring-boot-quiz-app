package com.app.quiz.Repository;

import com.app.quiz.Model.AnswerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRequestRepository extends JpaRepository<AnswerRequest, Long> {
}
