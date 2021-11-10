package javacourse.studentorder;


import javacourse.studentorder.dao.DictionaryDaoImpl;
import javacourse.studentorder.domain.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SaveStudentOrder {
    final static int MANSERIA = 1000;
    final static int WOMANSERIA = 2000;
    public static void main(String[] args) throws Exception {
        List<Street> d = new DictionaryDaoImpl().findStreet("не");
        for(Street s : d){
            System.out.println(s);
        }

        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        for (PassportOffice p : po){
            System.out.println(p.getOfficeName());
        }

        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        for (RegisterOffice r : ro){
            System.out.println(r.getOfficeName());
        }

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
        RegisterOffice ro = new RegisterOffice(1L,"","");
        so.setMarriageOffice(ro);
        Street street = new Street(1L,"First street");
        Adress adress = new Adress("195000", street, "12", "", "142");

        Adult husband = new Adult("Перепедько", "Тарас","Игнатьевич",
                LocalDate.of(1997, 8,24));
        husband.setPassportSeria("" + (MANSERIA + id));
        husband.setPassportNumber("" + 10000 + id);
        husband.setIssueDate(LocalDate.of(2017, 9, 23));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (10000 + id));
        husband.setAdress(adress);

        Adult wife = new Adult("Перепедько", "Галина", "Михайловна",
                LocalDate.of(1995, 6,16));
        wife.setPassportSeria("" +  (WOMANSERIA + id));
        wife.setPassportNumber("" + 20000 + id);
        wife.setIssueDate(LocalDate.of(2018, 7, 15));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        husband.setIssueDepartment(po2);
        wife.setStudentId("" + (20000 + id));
        wife.setAdress(adress);

        Child child1 = new Child("Перепедько", "Мария", "Тарасовна",
                LocalDate.of(2020, 8,21));
        child1.setCertificateNumber("" + (30000 + id));
        child1.setIssueDate(LocalDate.of(2020,9,3));
        RegisterOffice ro2 = new RegisterOffice(2L,"","");
        so.setMarriageOffice(ro2);
        child1.setAdress(adress);

        Child child2 = new Child("Перепедько", "Геннадий", "Тарасович",
                LocalDate.of(2020, 8,21));
        child2.setCertificateNumber("" + (40000 + id));
        child2.setIssueDate(LocalDate.of(2020,9,3));
        RegisterOffice ro3 = new RegisterOffice(3L,"","");
        so.setMarriageOffice(ro3);
        child2.setAdress(adress);


        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);


        return so;
    }

}
