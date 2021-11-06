package javacourse.studentorder.validator;

import javacourse.studentorder.domain.wedding.AnswerWedding;
import javacourse.studentorder.domain.StudentOrder;

public class WeddingValidator {
     public static AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding is running");
        AnswerWedding wed = new AnswerWedding();
        return wed;
    }
}
