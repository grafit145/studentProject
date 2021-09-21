package javacourse.studentorder.validator;

import javacourse.studentorder.domain.Person;
import javacourse.studentorder.domain.register.AnswerCityRegister;
import javacourse.studentorder.domain.Child;
import javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import javacourse.studentorder.domain.register.CityRegisterResponse;
import javacourse.studentorder.domain.StudentOrder;
import javacourse.studentorder.exeption.CityRegisterExeption;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    public String login;
    public String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.addItem(checkPerson(so.getHusband()));
        ans.addItem(checkPerson(so.getWife()));

        for (Child child : so.getChildren()) {
            ans.addItem(checkPerson(child));
        }

        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person) {
        try {
            CityRegisterResponse cans = personChecker.checkPerson(person);

        } catch (CityRegisterExeption ex) {
            ex.printStackTrace(System.out);
        }
        return null;
    }
}
