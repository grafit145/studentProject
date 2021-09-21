package javacourse.studentorder.domain.register;

public class CityRegisterResponse {
    private boolean existing;
    private boolean temporal;

    public boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    @Override
    public String toString() {
        return "CityRegisterCheckerResponse{" +
                "existing=" + existing +
                ", temporal=" + temporal +
                '}';
    }
}
