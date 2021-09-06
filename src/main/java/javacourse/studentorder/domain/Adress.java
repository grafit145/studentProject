package javacourse.studentorder.domain;

public class Adress {
    private String street;
    private String building;
    private String extension;
    private String apartment;
    private String postCode;
    public Adress(String postCode, String street, String building, String extension, String apartment){
        this.apartment = apartment;
        this.building = building;
        this.extension = extension;
        this.postCode = postCode;
        this.street = street;
    }
    public Adress(){

    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }
}
