package modell;

public class Buchung {
    private int id;
    private int passagierId;
    private int busreiseId;
    private int sitzplatznummer;
    private String buchungstyp;
    private String präferenz;

    // Konstruktoren
    public Buchung() {}

    public Buchung(int id, int passagierId, int busreiseId, int sitzplatznummer, String buchungstyp, String präferenz) {
        this.id = id;
        this.passagierId = passagierId;
        this.busreiseId = busreiseId;
        this.sitzplatznummer = sitzplatznummer;
        this.buchungstyp = buchungstyp;
        this.präferenz = präferenz;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassagierId() {
        return passagierId;
    }

    public void setPassagierId(int passagierId) {
        this.passagierId = passagierId;
    }

    public int getBusreiseId() {
        return busreiseId;
    }

    public void setBusreiseId(int busreiseId) {
        this.busreiseId = busreiseId;
    }

    public int getSitzplatznummer() {
        return sitzplatznummer;
    }

    public void setSitzplatznummer(int sitzplatznummer) {
        this.sitzplatznummer = sitzplatznummer;
    }

    public String getBuchungstyp() {
        return buchungstyp;
    }

    public void setBuchungstyp(String buchungstyp) {
        this.buchungstyp = buchungstyp;
    }

    public String getPräferenz() {
        return präferenz;
    }

    public void setPräferenz(String präferenz) {
        this.präferenz = präferenz;
    }
}
