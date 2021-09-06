package javacourse.studentorder.validator;

import javacourse.studentorder.domain.AnswerCityRegister;
import javacourse.studentorder.domain.CityRegisterCheckerResponse;
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
        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
            CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChild());
        }catch (CityRegisterExeption ex){
            ex.printStackTrace();
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
