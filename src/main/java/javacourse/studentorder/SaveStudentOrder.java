package javacourse.studentorder;


import javacourse.studentorder.domain.Adress;
import javacourse.studentorder.domain.Adult;
import javacourse.studentorder.domain.Child;
import javacourse.studentorder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {
    public static void main(String[] args) {
//        StudentOrder so = new StudentOrder();
       /* long ans = saveStudentOrder(so);
        System.out.println(ans);
*/
    }
    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("SaveStudentOrder");

        return answer;
    }

    static void sheduleStudentorder() {
        System.out.println("Shedule is running");
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificate("" + (12345600 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        Adress adress = new Adress("195000", "Заневский пр.", "12", "",
                "142");

        Adult husband = new Adult("Перепедько", "Тарас","Игнатьевич",
                LocalDate.of(1997, 8,24));
        husband.setPassportSeria("" + 1000 + id);
        husband.setPassportNumber("" + 10000 + id);
        husband.setIssueDate(LocalDate.of(2017, 9, 23));
        husband.setIssueDepartment("Районный отдел полиции №" + id);
        husband.setStudentId("" + (10000 + id));
        husband.setAdress(adress);

        Adult wife = new Adult("Перепедько", "Галина", "Михайловна",
                LocalDate.of(1995, 6,16));
        wife.setPassportSeria("" + 2000 + id);
        wife.setPassportNumber("" + 20000 + id);
        wife.setIssueDate(LocalDate.of(2018, 7, 15));
        wife.setIssueDepartment("Районный отдел полиции №" + id);
        wife.setStudentId("" + (20000 + id));
        wife.setAdress(adress);

        Child child = new Child("Перепедько", "Мария", "Тарасовна",
                LocalDate.of(2020, 8,21));
        child.setCertificateNumber("" + (30000 + id));
        child.setIssueDate(LocalDate.of(2020,9,3));
        child.setIssueDepartment("Отдел ЗАГС №" + id);
        child.setAdress(adress);


        return so;
    }

}
