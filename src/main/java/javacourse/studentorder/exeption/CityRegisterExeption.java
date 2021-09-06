package javacourse.studentorder.exeption;

public class CityRegisterExeption extends Exception{
    public CityRegisterExeption() {
    }

    public CityRegisterExeption(String message) {
        super(message);
    }

    public CityRegisterExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
