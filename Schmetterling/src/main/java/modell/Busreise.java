package modell;

public class Busreise {
    private String fahrtbeginn;
    private String fahrtende;
    private String Ort_Fahrtbeginn; 
    private String zielort;
    private double Kosten_pro_Person;
    private int Bus_ID;
    private int Fahrer_ID;


        public Busreise(String fahrtbeginn, String fahrtende, String zielort, double kosten_pro_Person, int bus_ID, int fahrer_ID,String ort_Fahrtbeginn) {
            this.fahrtbeginn = fahrtbeginn;
            this.fahrtende = fahrtende;
            this.Ort_Fahrtbeginn = ort_Fahrtbeginn;
            this.zielort = zielort;
            this.Kosten_pro_Person = kosten_pro_Person;
            this.Bus_ID = bus_ID;
            this.Fahrer_ID = fahrer_ID;
        }
    
        // Getter und Setter
    

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
    public String getOrt_Fahrtbeginn() {
        return Ort_Fahrtbeginn;
    }

    public void setOrt_Fahrtbeginn(String Ort_Fahrtbeginn) {
        this.Ort_Fahrtbeginn = Ort_Fahrtbeginn;
    }

    public String getZielort() {
        return zielort;
    }

    public void setZielort(String zielort) {
        this.zielort = zielort;
    }

    public double getKosten_pro_Person() {
        return Kosten_pro_Person;
    }

    public void setKosten_pro_Person(double Kosten_pro_Person) {
        this.Kosten_pro_Person = Kosten_pro_Person;
    }

    public int getBusId() {
        return Bus_ID;
    }

    public void setBusId(int Bus_ID) {
        this.Bus_ID = Bus_ID;
    }

    public int getFahrerId() {
        return Fahrer_ID;
    }

    public void setFahrer_ID(int fahrer_ID) {
        this.Fahrer_ID = fahrer_ID;
    }
}
