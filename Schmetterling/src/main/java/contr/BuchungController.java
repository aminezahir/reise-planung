package contr;

import modell.Buchung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuchungController {
    private Connection connection;

    public BuchungController(Connection connection) {
        this.connection = connection;
    }

    public void addBuchung(Buchung buchung) {
        String query = "INSERT INTO Buchung (id, passagierId, busreiseId, sitzplatznummer, buchungstyp, präferenz) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, buchung.getId());
            stmt.setInt(2, buchung.getPassagierId());
            stmt.setInt(3, buchung.getBusreiseId());
            stmt.setInt(4, buchung.getSitzplatznummer());
            stmt.setString(5, buchung.getBuchungstyp());
            stmt.setString(6, buchung.getPräferenz());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Buchung getBuchung(int id) {
        String query = "SELECT * FROM Buchung WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Buchung(
                    rs.getInt("id"),
                    rs.getInt("passagierId"),
                    rs.getInt("busreiseId"),
                    rs.getInt("sitzplatznummer"),
                    rs.getString("buchungstyp"),
                    rs.getString("präferenz")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Weitere CRUD-Methoden (update, delete) können hier hinzugefügt werden
}
