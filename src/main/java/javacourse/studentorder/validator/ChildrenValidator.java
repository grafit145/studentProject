package javacourse.studentorder.validator;

import javacourse.studentorder.domain.children.AnswerChildren;
import javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    public static AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("ChildrenCheck is running");
        AnswerChildren children = new AnswerChildren();
        return children;
    }
}
