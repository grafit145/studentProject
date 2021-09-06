package javacourse.studentorder.validator;


import javacourse.studentorder.domain.Adult;
import javacourse.studentorder.domain.CityRegisterCheckerResponse;
import javacourse.studentorder.domain.Person;
import javacourse.studentorder.exeption.CityRegisterExeption;

public class FakeCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterExeption {
        if (person instanceof Adult){
            System.out.println("ADULT");
        }
        return null;

    }
}
