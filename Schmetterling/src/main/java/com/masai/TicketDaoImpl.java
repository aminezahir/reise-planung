package com.masai;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDaoImpl implements TicketDao {
	@Override
    public String insertBusDetails(Integer fahrzeugId, String fahrerName, String source, String destination, Integer seats, String arrivalTime, String departureTime, Float entfernung, Double cost, String intermediateStations, Date fahrtdatum) {
        String message = "Not inserted!";
        try (Connection conn = DButil.provideConnection()) {
            PreparedStatement psBusType = conn.prepareStatement("SELECT fahrzeugtyp, fahrzeug_id FROM fahrzeugtypen WHERE fahrzeug_id = ?");
            psBusType.setInt(1, fahrzeugId);
            ResultSet rsBusType = psBusType.executeQuery();
            String busType = null;
            int fahrzeugid = 0;
            if (rsBusType.next()) {
                busType = rsBusType.getString("fahrzeugtyp");
                fahrzeugid = rsBusType.getInt("fahrzeug_id");
            }

            if (busType != null) {
                // Inserting data into busdetails table
                PreparedStatement ps = conn.prepareStatement("INSERT INTO busdetails (BusName, Source, Destination, BusType, Seats, ArrivalTime, DepartureTime, Entfernung, Kosten, Zwischenstationen, fahrzeugid , Fahrtdatum) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, fahrerName); // Set fahrerName as BusName
                ps.setString(2, source);
                ps.setString(3, destination);
                ps.setString(4, busType); // Set busType fetched from fahrzeugtypen table as BusType
                ps.setInt(5, seats);
                ps.setString(6, arrivalTime);
                ps.setString(7, departureTime);
                ps.setFloat(8, entfernung);
                ps.setDouble(9, cost);
                ps.setString(10, intermediateStations);
                ps.setInt(11, fahrzeugid);
                ps.setDate(12, fahrtdatum);
                int x = ps.executeUpdate();
                if (x > 0) {
                    message = "Reise Details Inserted Successfully!";
                }
            } else {
                message = "Invalid fahrzeugId!";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String confirmTicket(String source, String destination, String name, int age) {
        String message = "Seat Not Available !";

        try (Connection conn = DButil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select seats,busno from busdetails where source = ? and destination = ?");

            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int x = rs.getInt("Seats");

                if (x > 0) {
                    PreparedStatement ps2 = conn.prepareStatement("Update busdetails set Seats = Seats-1 where source = ?");

                    ps2.setString(1, source);

                    ps2.executeUpdate();

                    PreparedStatement ps3 = conn.prepareStatement("insert into customerdetails (busno, Name, Age) values (?, ?, ?)");

                    ps3.setInt(1, rs.getInt("busno"));
                    ps3.setString(2, name);
                    ps3.setInt(3, age);

                    ps3.executeUpdate();

                    PreparedStatement ps4 = conn.prepareStatement("select * from customerdetails where name = ?");

                    ps4.setString(1, name);

                    ResultSet rs2 = ps4.executeQuery();

                    if (rs2.next()) {
                        System.out.println();
                        System.out.println("BusNo: " + rs2.getInt("busno"));
                        System.out.println("Passenger Name: " + rs2.getString("Name"));
                        System.out.println("Passenger Age: " + rs2.getInt("Age"));
                    }
                    message = "Ticked confirmed !";
                }

            } else {
                message = "Please Enter Valid Location !";
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String ticketCancel(int busno, String name) {
        String message = "Ticket Canellation Unsuccessful !";

        try (Connection conn = DButil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("delete from customerdetails where name = ? and busno = ?");

            ps.setString(1, name);
            ps.setInt(2, busno);

            int x = ps.executeUpdate();

            PreparedStatement ps2 = conn.prepareStatement("Update busdetails set seats = seats+1 where busno = ?");

            ps2.setInt(1, busno);

            ps2.executeUpdate();

            if (x > 0) {
                message = "Ticket Cancellation Successful !";
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String adminLogin(String username, String password) {
        String message = "Wrong Credentials!";

        try (Connection conn = DButil.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("Select * from adminlogin where username = ? and password = ?");

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println();
                System.out.println("Welcome " + rs.getString("username") + "!");
                message = "";
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public String insertVehicleType(String fahrzeugtyp, Double kostenProKm, Double kostenProMinute) {
        String message = "Not inserted!";
        try (Connection conn = DButil.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO fahrzeugtypen (fahrzeugtyp, kosten_pro_km, kosten_pro_minute) VALUES (?, ?, ?)");
            ps.setString(1, fahrzeugtyp);
            ps.setDouble(2, kostenProKm);
            ps.setDouble(3, kostenProMinute);
            int x = ps.executeUpdate();
            if (x > 0) {
                message = "Vehicle Type Inserted Successfully!";
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }
}
