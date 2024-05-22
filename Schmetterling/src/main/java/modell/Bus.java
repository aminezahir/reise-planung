package modell;

public class Bus {
    private int id;
    private String kennzeichen;
    private String zulassung;
    private String TÜV_Termin; 
    private int Gefahrene_KM ;
    private double Kosten_pro_KM;
    private String typ;

    // Konstruktoren
    public Bus() {}

    public Bus(int id, String kennzeichen, String zulassung, String TÜV_Termin, int Gefahrene_KM , double Kosten_pro_KM, String typ) {
        this.id = id;
        this.kennzeichen = kennzeichen;
        this.zulassung = zulassung;
        this.TÜV_Termin = TÜV_Termin;
        this.Gefahrene_KM  = Gefahrene_KM ;
        this.Kosten_pro_KM = Kosten_pro_KM;
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

    public String getTÜV_Termin() {
        return TÜV_Termin;
    }

    public void setTÜV_Termin(String TÜV_Termin) {
        this.TÜV_Termin = TÜV_Termin;
    }


    public int getGefahrene_KM () {
        return Gefahrene_KM ;
    }

    public void setGefahrene_KM(int Gefahrene_KM) {
        this.Gefahrene_KM = Gefahrene_KM;
    }

    public double getKosten_pro_KM() {
        return Kosten_pro_KM;
    }

    public void setKosten_pro_KM(double Kosten_pro_KM) {
        this.Kosten_pro_KM = Kosten_pro_KM;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
