package javacourse.studentorder.validator;


import javacourse.studentorder.domain.register.CityRegisterResponse;
import javacourse.studentorder.domain.Person;
import javacourse.studentorder.exeption.CityRegisterExeption;
import javacourse.studentorder.exeption.TransportExeption;

public class RealCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterExeption, TransportExeption {
        return null;
    }
}
