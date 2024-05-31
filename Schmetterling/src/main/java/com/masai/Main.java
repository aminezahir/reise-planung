package com.masai;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = DButil.provideConnection();

        int check = 1;

        while (check != 2) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("Welcome To Reise Ticket Reservation System");
            System.out.println("========================================");

            Scanner sc = new Scanner(System.in);
            TicketDao dao = new TicketDaoImpl();

            System.out.println();
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println();

            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println();
                System.out.println("Enter username: ");
                String username = sc.next();

                System.out.println("Enter Password: ");
                String password = sc.next();

                String login = dao.adminLogin(username, password);

                System.out.println(login);

                if (login.equals("Wrong Credentials!")) {
                    check = 1;
                    continue;
                }

                System.out.println("1. Insert Reise Details");
                System.out.println("2. Insert Fahrzeugtyp ");
                System.out.println("3. Go back");
                System.out.println("4. Exit");

                System.out.println();
                System.out.println("Enter your choice:");
                int insertorNot = sc.nextInt();

                if (insertorNot == 1) {
                    try (Connection conn = DButil.provideConnection()) {
                        PreparedStatement ps = conn.prepareStatement("SELECT * FROM fahrzeugtypen");
                        ResultSet rs = ps.executeQuery();
                        System.out.println("---------------------------------------------------------------");
                        System.out.println("fahrzeug_id   fahrzeugtyp   kosten_pro_km   kosten_pro_minute");
                        System.out.println("---------------------------------------------------------------");
                        while (rs.next()) {
                            System.out.printf("%-13d %-14s %-15.1f %-16.1f%n",
                                    rs.getInt("fahrzeug_id"),
                                    rs.getString("fahrzeugtyp"),
                                    rs.getDouble("kosten_pro_km"),
                                    rs.getDouble("kosten_pro_minute"));
                            System.out.println("---------------------------------------------------------------");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Enter fahrzeug_id für die reise : ");
                    Integer fahrzeugId = sc.nextInt();
					
					System.out.println("Enter Fahrer Name: ");
                    String fahrerName = sc.next();

                    System.out.println("Enter Start ort : ");
                    String source = sc.next();

                    System.out.println("Enter Ziel Ort: ");
                    String destination = sc.next();

                    System.out.println("Enter Seats Avilable: ");
                    Integer seats = sc.nextInt();

                    System.out.println("Enter DepartureTime: ");
                    String departureTime = sc.next();

                    System.out.println("Enter ArrivalTime: ");
                    String arrivalTime = sc.next();

                    System.out.println("Enter Entfernung in KM: ");
                    Float entfernung = sc.nextFloat();

                    System.out.println("Enter Fahrdatum (YY-MM-DD): ");
                    String fahrtdatumString = sc.next();                 
                    Date fahrtdatum = null;
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date parsed = format.parse(fahrtdatumString);
                        fahrtdatum = new Date(parsed.getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter Preis: ");
                    Double cost = sc.nextDouble();

                    System.out.println("Enter Intermediate Stations / none): ");
                    String intermediateStations = sc.next();

                    String result = dao.insertBusDetails(fahrzeugId, fahrerName, source, destination, seats, arrivalTime, departureTime, entfernung, cost, intermediateStations, fahrtdatum);

                    System.out.println(result);

                } else if (insertorNot == 2) {
                    System.out.println("Enter Fahrzeugtyp: ");
                    String fahrzeugtyp = sc.next();

                    System.out.println("Enter Kosten pro km: ");
                    Double kostenProKm = sc.nextDouble();

                    System.out.println("Enter Kosten pro Minute: ");
                    Double kostenProMinute = sc.nextDouble();

                    String result = dao.insertVehicleType(fahrzeugtyp, kostenProKm, kostenProMinute);

                    System.out.println(result);
                } else if (insertorNot == 3) {
                    check = 1;
                } else if (insertorNot == 4) {
                    check = 2;
                } else {
                    System.out.println("Please Enter Correction Information Next Time!");
                }
            } else if (choice == 2) {
                System.out.println();
                System.out.println("1. Book Ticket");
                System.out.println("2. Cancel Ticket");
                System.out.println("3. Go back");
                System.out.println("4. Exit");

                System.out.println();
                System.out.println("Enter your choice: ");
                int bookorNot = sc.nextInt();

                if (bookorNot == 1) {
                    System.out.println();

                    try (Connection conn = DButil.provideConnection()) {

                        PreparedStatement ps = conn.prepareStatement("Select * from busdetails");

                        ResultSet rs = ps.executeQuery();
                        System.out.println("------------------------------------------------------------------------------------------------------");
                        System.out.println("F_Name        SEATS         Start_Ort        Ziel_Ort        F_Type         Kosten           Datum");
                        System.out.println("------------------------------------------------------------------------------------------------------");

                        while (rs.next()) {
                        	
                            System.out.printf("%-13s %-13d %-15s %-15s %-15s €%-15s %s%n",
                                    rs.getString("BusName"),
                                    rs.getInt("Seats"),
                                    rs.getString("Source"),
                                    rs.getString("Destination"),
                                    rs.getString("BusType"),
                                    rs.getDouble("Kosten"),
                                    rs.getDate("FahrtDatum"));
                            System.out.println("------------------------------------------------------------------------------------------------------");
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                    System.out.println("Enter Source Location: ");
                    String source = sc.next();

                    System.out.println("Enter Destination Location: ");
                    String destination = sc.next();

                    System.out.println("Enter Your Name: ");
                    String name = sc.next();

                    System.out.println("Enter Your Age: ");
                    int age = sc.nextInt();

                    String res = dao.confirmTicket(source, destination, name, age);

                    System.out.println();
                    System.out.println(res);
                    check = 1;

                } else if (bookorNot == 2) {
                    System.out.println("Enter BusNo: ");
                    int busno = sc.nextInt();

                    System.out.println("Enter Name: ");
                    String name = sc.next();

                    String result = dao.ticketCancel(busno, name);

                    System.out.println();

                    System.out.println(result);

                } else if (bookorNot == 3) {
                    check = 1;
                } else if (bookorNot == 4) {
                    check = 2;
                } else {
                    System.out.println("Please Enter Correction Information Next Time!");
                }

            } else {
                System.out.println("Please Enter Correction Information Next Time!");
            }

        }

        System.out.println("============================");
        System.out.println("Thank you for visiting us !");
        System.out.println("============================");

    }
}
