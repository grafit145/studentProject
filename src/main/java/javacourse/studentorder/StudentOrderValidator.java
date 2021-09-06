package javacourse.studentorder;


import javacourse.studentorder.domain.*;
import javacourse.studentorder.mail.MailSender;
import javacourse.studentorder.validator.ChildrenValidator;
import javacourse.studentorder.validator.CityRegisterValidator;
import javacourse.studentorder.validator.StudentValidator;
import javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private WeddingValidator weddingVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        weddingVal = new WeddingValidator();
        mailSender = new MailSender();

    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();

    }

    public void checkAll() {
        StudentOrder[] soArray = readStudentOrders();
        for(int i = 0; i < soArray.length; i++){
            System.out.println();
            checkOneOrder(soArray[i]);
        }
    }
    public StudentOrder[] readStudentOrders() {
        StudentOrder[] soArray = new StudentOrder[3];
        for (int i = 0; i < soArray.length; i++) {
            soArray[i] = SaveStudentOrder.buildStudentOrder(i);
        }

        return soArray;
    }
    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityAnswer = checkCityRegister(so);
      /*  AnswerWedding wedAnswer = checkWedding(so);
        AnswerChildren childAnswer = checkChildren(so);
        AnswerStudent answerStudent = checkStudent(so);
        sendMail(so);*/
    }



    public AnswerCityRegister checkCityRegister(StudentOrder so) {

        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {

        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);

    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);

    }
}
