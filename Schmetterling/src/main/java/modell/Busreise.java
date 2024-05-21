package modell;

public class Busreise {
    private int id;
    private String fahrtbeginn;
    private String fahrtende;
    private String zielort;
    private double kostenProPerson;
    private int busId;
    private int fahrerId;

    // Konstruktoren
    public Busreise() {}

    public Busreise(int id, String fahrtbeginn, String fahrtende, String zielort, double kostenProPerson, int busId, int fahrerId) {
        this.id = id;
        this.fahrtbeginn = fahrtbeginn;
        this.fahrtende = fahrtende;
        this.zielort = zielort;
        this.kostenProPerson = kostenProPerson;
        this.busId = busId;
        this.fahrerId = fahrerId;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFahrtbeginn() {
        return fahrtbeginn;
    }

    public void setFahrtbeginn(String fahrtbeginn) {
        this.fahrtbeginn = fahrtbeginn;
    }

    public String getFahrtende() {
        return fahrtende;
    }

    public void setFahrtende(String fahrtende) {
        this.fahrtende = fahrtende;
    }

    public String getZielort() {
        return zielort;
    }

    public void setZielort(String zielort) {
        this.zielort = zielort;
    }

    public double getKostenProPerson() {
        return kostenProPerson;
    }

    public void setKostenProPerson(double kostenProPerson) {
        this.kostenProPerson = kostenProPerson;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public int getFahrerId() {
        return fahrerId;
    }

    public void setFahrerId(int fahrerId) {
        this.fahrerId = fahrerId;
    }
}
