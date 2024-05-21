package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBcontext {

    private final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=BuseData;user=sa;password=reallyStrongPwd1234";

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Properties props = new Properties();
            props.setProperty("encrypt", "false");
            props.setProperty("trustServerCertificate", "true");
            Connection connection = DriverManager.getConnection(connectionUrl, props);
            System.out.println("Die Verbindung zum SQL Server wurde erfolgreich hergestellt.");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createTables() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String createBusseTable = "CREATE TABLE Busse (" +
                                      "ID INT PRIMARY KEY, " +
                                      "Kennzeichen VARCHAR(50), " +
                                      "Zulassung DATE, " +
                                      "TÜV_Termin DATE, " +
                                      "Gefahrene_KM INT, " +
                                      "Kosten_pro_KM DECIMAL(10, 2), " +
                                      "Typ VARCHAR(50))";

            String createFahrerTable = "CREATE TABLE Fahrer (" +
                                       "ID INT PRIMARY KEY, " +
                                       "Name VARCHAR(255), " +
                                       "Führerscheinklasse VARCHAR(10), " +
                                       "Erfahrungsjahre INT, " +
                                       "Kontaktinformationen VARCHAR(255))";

            String createBusreisenTable = "CREATE TABLE Busreisen (" +
                                          "ID INT PRIMARY KEY, " +
                                          "Fahrtbeginn DATETIME, " +
                                          "Fahrtende DATETIME, " +
                                          "Zielort VARCHAR(255), " +
                                          "Kosten_pro_Person DECIMAL(10, 2), " +
                                          "Bus_ID INT FOREIGN KEY REFERENCES Busse(ID), " +
                                          "Fahrer_ID INT FOREIGN KEY REFERENCES Fahrer(ID))";

            String createPassagiereTable = "CREATE TABLE Passagiere (" +
                                           "ID INT PRIMARY KEY, " +
                                           "Name VARCHAR(255), " +
                                           "Adresse VARCHAR(255), " +
                                           "Kontaktinformationen VARCHAR(255))";

            String createBuchungenTable = "CREATE TABLE Buchungen (" +
                                          "ID INT PRIMARY KEY, " +
                                          "Passagier_ID INT FOREIGN KEY REFERENCES Passagiere(ID), " +
                                          "Busreise_ID INT FOREIGN KEY REFERENCES Busreisen(ID), " +
                                          "Sitzplatznummer INT, " +
                                          "Buchungstyp VARCHAR(50), " +
                                          "Präferenz VARCHAR(50))";

            statement.executeUpdate(createBusseTable);
            statement.executeUpdate(createFahrerTable);
            statement.executeUpdate(createBusreisenTable);
            statement.executeUpdate(createPassagiereTable);
            statement.executeUpdate(createBuchungenTable);

            System.out.println("Alle Tabellen wurden erfolgreich erstellt.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
