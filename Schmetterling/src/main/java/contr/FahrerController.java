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

    public void addFahrer(Fahrer fahrer) {
        String sql = "INSERT INTO Fahrer (ID, Name, Führerscheinklasse, Erfahrungsjahre, Kontaktinformationen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, fahrer.getId());
            pstmt.setString(2, fahrer.getName());
            pstmt.setString(3, fahrer.getFührerscheinklasse());
            pstmt.setInt(4, fahrer.getErfahrungsjahre());
            pstmt.setString(5, fahrer.getKontaktinformationen());
            pstmt.executeUpdate();
            System.out.println("Fahrer erfolgreich hinzugefügt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Weitere CRUD-Operationen (lesen, aktualisieren, löschen) können hier hinzugefügt werden.
}
