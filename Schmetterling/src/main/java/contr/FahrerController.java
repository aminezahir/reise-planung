package contr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modell.Fahrer;

public class FahrerController {
    private Connection connection;

    public FahrerController(Connection connection) {
        this.connection = connection;
    }
    public void addSampleFahrers() {
        addFahrer(new Fahrer(1, "Hans Müller", "D", 10, "+4917635237688"));
        addFahrer(new Fahrer(2, "Peter Schmidt", "DE", 5, "+4917644256799"));
    }

    private void addFahrer(Fahrer fahrer) {
        String sql = "INSERT INTO Fahrer (id, name, führerscheinklasse, erfahrungsjahre, kontaktinformationen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, fahrer.getId());
            pstmt.setString(2, fahrer.getName());
            pstmt.setString(3, fahrer.getFührerscheinklasse());
            pstmt.setInt(4, fahrer.getErfahrungsjahre());
            pstmt.setString(5, fahrer.getKontaktinformationen());
            pstmt.executeUpdate();
            System.out.println("Fahrer erfolgreich hinzugefügt: " + fahrer.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}