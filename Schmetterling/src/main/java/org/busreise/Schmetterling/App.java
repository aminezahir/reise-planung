package org.busreise.Schmetterling;

import java.sql.Connection;
import java.sql.SQLException;

import contr.FahrerController;
import database.DBcontext;




public class App {
    public static void main(String[] args) {
        // Verbindung zur Datenbank herstellen und Tabellen erstellen
        DBcontext dbContext = new DBcontext();
        try {
            Connection connection = dbContext.getConnection();
            
            FahrerController fahrercontroller = new FahrerController(connection);
            fahrercontroller.addSampleFahrers();
            connection.close(); // Verbindung schließen, wenn sie nicht mehr benötigt wird
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}