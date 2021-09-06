package javacourse.studentorder.validator;

import javacourse.studentorder.domain.CityRegisterCheckerResponse;
import javacourse.studentorder.domain.Person;
import javacourse.studentorder.exeption.CityRegisterExeption;

public interface CityRegisterChecker {
    CityRegisterCheckerResponse checkPerson(Person person) throws CityRegisterExeption;
}
