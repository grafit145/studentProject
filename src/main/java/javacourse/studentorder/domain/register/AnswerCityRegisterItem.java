package javacourse.studentorder.domain.register;

import javacourse.studentorder.domain.Person;

public class AnswerCityRegisterItem {

    public enum CityStatus {
        YES, NO, ERROR;
    }

    public static class CityError {
        private String code;
        private String text;

        public CityError(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private Person person;
    private CityError error;
    private CityStatus status;

    public Person getPerson() {
        return person;
    }

    public CityError getError() {
        return error;
    }

    public CityStatus getStatus() {
        return status;
    }

    public AnswerCityRegisterItem(Person person, CityStatus status) {
        this.person = person;
        this.status = status;
    }

    public AnswerCityRegisterItem(Person person, CityError error, CityStatus status) {
        this.person = person;
        this.error = error;
        this.status = status;
    }


}
