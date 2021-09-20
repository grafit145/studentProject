package javacourse.studentorder.validator;

import javacourse.studentorder.domain.AnswerCityRegister;
import javacourse.studentorder.domain.Child;
import javacourse.studentorder.domain.CityRegisterCheckerResponse;
import javacourse.studentorder.domain.StudentOrder;
import javacourse.studentorder.exeption.CityRegisterExeption;

import java.util.Iterator;

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

            for(int i = 0; i < so.getChildren().size(); i++){
                CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChildren().get(i));
            }

            for(Iterator<Child> it = so.getChildren().iterator(); it.hasNext();){
                Child child = it.next();
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }

            for(Child child : so.getChildren()) {
                CityRegisterCheckerResponse cans = personChecker.checkPerson(child);
            }
        }catch (CityRegisterExeption ex){
            ex.printStackTrace(System.out);
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
