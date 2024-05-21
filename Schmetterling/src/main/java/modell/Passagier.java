package modell;

public class Passagier {
    private int id;
    private String name;
    private String adresse;
    private String kontaktinformationen;

    // Konstruktoren
    public Passagier() {}

    public Passagier(int id, String name, String adresse, String kontaktinformationen) {
        this.id = id;
        this.name = name;
        this.adresse = adresse;
        this.kontaktinformationen = kontaktinformationen;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getKontaktinformationen() {
        return kontaktinformationen;
    }

    public void setKontaktinformationen(String kontaktinformationen) {
        this.kontaktinformationen = kontaktinformationen;
    }
}
