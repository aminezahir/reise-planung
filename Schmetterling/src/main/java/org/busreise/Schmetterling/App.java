package org.busreise.Schmetterling;

import java.sql.Connection;
import java.sql.SQLException;

import database.DBcontext;




public class App {
    public static void main(String[] args) {
        // Verbindung zur Datenbank herstellen und Tabellen erstellen
        DBcontext dbContext = new DBcontext();
        dbContext.createTables();

        // Weitere Logik hier, z.B. Hinzufügen von Daten
    }
}
