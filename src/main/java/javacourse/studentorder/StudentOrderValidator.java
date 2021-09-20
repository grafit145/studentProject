package javacourse.studentorder;


import javacourse.studentorder.domain.*;
import javacourse.studentorder.mail.MailSender;
import javacourse.studentorder.validator.ChildrenValidator;
import javacourse.studentorder.validator.CityRegisterValidator;
import javacourse.studentorder.validator.StudentValidator;
import javacourse.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

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
        List<StudentOrder> soList = readStudentOrders();
        for(StudentOrder so : soList){
            checkOneOrder(so);
        }
    }
    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }

        return soList;
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
