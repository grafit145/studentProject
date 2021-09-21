package javacourse.studentorder.validator;


import javacourse.studentorder.domain.register.CityRegisterResponse;
import javacourse.studentorder.domain.Person;
import javacourse.studentorder.exeption.CityRegisterExeption;

public class RealCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterExeption {
        return null;
    }
}
