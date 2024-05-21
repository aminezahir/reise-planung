package modell;

public class Fahrer {
    private int id;
    private String name;
    private String führerscheinklasse;
    private int erfahrungsjahre;
    private String kontaktinformationen;

    // Konstruktoren
    public Fahrer() {}

    public Fahrer(int id, String name, String führerscheinklasse, int erfahrungsjahre, String kontaktinformationen) {
        this.id = id;
        this.name = name;
        this.führerscheinklasse = führerscheinklasse;
        this.erfahrungsjahre = erfahrungsjahre;
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

    public String getFührerscheinklasse() {
        return führerscheinklasse;
    }

    public void setFührerscheinklasse(String führerscheinklasse) {
        this.führerscheinklasse = führerscheinklasse;
    }

    public int getErfahrungsjahre() {
        return erfahrungsjahre;
    }

    public void setErfahrungsjahre(int erfahrungsjahre) {
        this.erfahrungsjahre = erfahrungsjahre;
    }

    public String getKontaktinformationen() {
        return kontaktinformationen;
    }

    public void setKontaktinformationen(String kontaktinformationen) {
        this.kontaktinformationen = kontaktinformationen;
    }
}
