package com.app.quiz.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDTO {

    private Long id;
    private String question;
    private String option_A;
    private String option_B;
    private String option_C;
    private String option_D;
}
