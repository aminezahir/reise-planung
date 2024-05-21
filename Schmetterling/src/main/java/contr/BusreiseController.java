package contr;

import modell.Busreise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BusreiseController {
    private Connection connection;

    public BusreiseController(Connection connection) {
        this.connection = connection;
    }

    public void addBusreise(Busreise busreise) {
        String query = "INSERT INTO Busreise (id, fahrtbeginn, fahrtende, zielort, kostenProPerson, busId, fahrerId) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, busreise.getId());
            stmt.setString(2, busreise.getFahrtbeginn());
            stmt.setString(3, busreise.getFahrtende());
            stmt.setString(4, busreise.getZielort());
            stmt.setDouble(5, busreise.getKostenProPerson());
            stmt.setInt(6, busreise.getBusId());
            stmt.setInt(7, busreise.getFahrerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Busreise getBusreise(int id) {
        String query = "SELECT * FROM Busreise WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Busreise(
                    rs.getInt("id"),
                    rs.getString("fahrtbeginn"),
                    rs.getString("fahrtende"),
                    rs.getString("zielort"),
                    rs.getDouble("kostenProPerson"),
                    rs.getInt("busId"),
                    rs.getInt("fahrerId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Weitere CRUD-Methoden (update, delete) können hier hinzugefügt werden
}
