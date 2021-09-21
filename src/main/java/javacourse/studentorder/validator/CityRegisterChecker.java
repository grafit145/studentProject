package javacourse.studentorder.validator;

import javacourse.studentorder.domain.register.CityRegisterResponse;
import javacourse.studentorder.domain.Person;
import javacourse.studentorder.exeption.CityRegisterExeption;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson(Person person) throws CityRegisterExeption;
}
