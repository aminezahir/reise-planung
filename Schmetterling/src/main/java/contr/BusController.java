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

   
}
