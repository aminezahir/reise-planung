package contr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modell.Bus;

public class BusController {
    private Connection connection;

    public BusController(Connection connection) {
        this.connection = connection;
    }

    public void addBus(Bus bus) {
        String sql = "INSERT INTO Busse (ID, Kennzeichen, Zulassung, TÜV_Termin, Gefahrene_KM, Kosten_pro_KM, Typ) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, bus.getId());
            pstmt.setString(2, bus.getKennzeichen());
            pstmt.setString(3, bus.getZulassung());
            pstmt.setString(4, bus.getTüvTermin());
            pstmt.setInt(5, bus.getGefahreneKM());
            pstmt.setDouble(6, bus.getKostenProKM());
            pstmt.setString(7, bus.getTyp());
            pstmt.executeUpdate();
            System.out.println("Bus erfolgreich hinzugefügt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Weitere CRUD-Operationen (lesen, aktualisieren, löschen) können hier hinzugefügt werden.
}
