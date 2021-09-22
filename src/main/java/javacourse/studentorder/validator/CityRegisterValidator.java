package javacourse.studentorder.validator;

import javacourse.studentorder.domain.Person;
import javacourse.studentorder.domain.register.AnswerCityRegister;
import javacourse.studentorder.domain.Child;
import javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import javacourse.studentorder.domain.register.CityRegisterResponse;
import javacourse.studentorder.domain.StudentOrder;
import javacourse.studentorder.exeption.CityRegisterExeption;
import javacourse.studentorder.exeption.TransportExeption;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    public String login;
    public String password;
    public static final String IN_CODE = "NO_GRN";

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
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ? AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;

        } catch (CityRegisterExeption ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportExeption ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }

        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(person, error, status);

        return ans;
    }
}
