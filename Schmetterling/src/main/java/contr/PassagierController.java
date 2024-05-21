package contr;

import modell.Passagier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PassagierController {
    private Connection connection;

    public PassagierController(Connection connection) {
        this.connection = connection;
    }

    public void addPassagier(Passagier passagier) {
        String query = "INSERT INTO Passagier (id, name, adresse, kontaktinformationen) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, passagier.getId());
            stmt.setString(2, passagier.getName());
            stmt.setString(3, passagier.getAdresse());
            stmt.setString(4, passagier.getKontaktinformationen());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Passagier getPassagier(int id) {
        String query = "SELECT * FROM Passagier WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Passagier(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("adresse"),
                    rs.getString("kontaktinformationen")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Weitere CRUD-Methoden (update, delete) können hier hinzugefügt werden
}
