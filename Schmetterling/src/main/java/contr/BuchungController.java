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
}

   
