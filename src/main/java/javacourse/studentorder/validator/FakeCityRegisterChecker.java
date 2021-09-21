package javacourse.studentorder.validator;


import javacourse.studentorder.domain.Adult;
import javacourse.studentorder.domain.Child;
import javacourse.studentorder.domain.register.CityRegisterResponse;
import javacourse.studentorder.domain.Person;
import javacourse.studentorder.exeption.CityRegisterExeption;

public class FakeCityRegisterChecker implements CityRegisterChecker{
    public static final String GOOD1 = "1000";
    public static final String GOOD2 = "2000";
    public static final String BAD1 = "1001";
    public static final String BAD2 = "2001";
    public static final String ERROR1 = "1002";
    public static final String ERROR2 = "2002";
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterExeption {
        CityRegisterResponse res = new CityRegisterResponse();

        if (person instanceof Adult){
            System.out.println("ADULT");
            Adult t = (Adult) person;
            String ps = t.getPassportSeria();
            if(ps.equals(GOOD1) || ps.equals(GOOD2)){

                res.setExisting(true);
                res.setTemporal(false);

            }
            if(ps.equals(BAD1) || ps.equals(BAD2)){
                res.setExisting(false);

            }
            if(ps.equals(ERROR1) || ps.equals(ERROR2)){
                CityRegisterExeption e = new CityRegisterExeption("Fake ERROR" + ps);
                throw e;

            }

        }
        if (person instanceof Child){
            System.out.println("CHILD");
            res.setExisting(true);
            res.setTemporal(true);
        }
        System.out.println(res);
        return res;

    }
}
