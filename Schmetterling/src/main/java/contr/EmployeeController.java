package contr;

import modell.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeController {
    private Connection connection;

    public EmployeeController(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO Employees (ID, Name, Age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setInt(3, employee.getAge());
            pstmt.executeUpdate();
            System.out.println("Mitarbeiter erfolgreich hinzugefügt.");
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
