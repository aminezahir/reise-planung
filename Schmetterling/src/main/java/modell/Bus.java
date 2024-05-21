package modell;

public class Bus {
    private int id;
    private String kennzeichen;
    private String zulassung;
    private String tüvTermin;
    private int gefahreneKM;
    private double kostenProKM;
    private String typ;

    // Konstruktoren
    public Bus() {}

    public Bus(int id, String kennzeichen, String zulassung, String tüvTermin, int gefahreneKM, double kostenProKM, String typ) {
        this.id = id;
        this.kennzeichen = kennzeichen;
        this.zulassung = zulassung;
        this.tüvTermin = tüvTermin;
        this.gefahreneKM = gefahreneKM;
        this.kostenProKM = kostenProKM;
        this.typ = typ;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public String getZulassung() {
        return zulassung;
    }

    public void setZulassung(String zulassung) {
        this.zulassung = zulassung;
    }

    public String getTüvTermin() {
        return tüvTermin;
    }

    public void setTüvTermin(String tüvTermin) {
        this.tüvTermin = tüvTermin;
    }

    public int getGefahreneKM() {
        return gefahreneKM;
    }

    public void setGefahreneKM(int gefahreneKM) {
        this.gefahreneKM = gefahreneKM;
    }

    public double getKostenProKM() {
        return kostenProKM;
    }

    public void setKostenProKM(double kostenProKM) {
        this.kostenProKM = kostenProKM;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
