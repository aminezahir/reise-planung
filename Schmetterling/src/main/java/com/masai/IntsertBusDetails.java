package com.masai;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class IntsertBusDetails {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
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

        System.out.println("Enter Fahrdatum (in minutes): ");
        String fahrtdatumString = sc.next();
        
        Date fahrtdatum = null;
        try {
            fahrtdatum = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(fahrtdatumString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Preis: ");
        Double cost = sc.nextDouble();

        System.out.println("Enter Intermediate Stations (comma-separated, leave empty if none): ");
        String intermediateStations = sc.next();
		
		TicketDao dao = new TicketDaoImpl();
		
        String result = dao.insertBusDetails(fahrzeugId, fahrerName, source, destination, seats, arrivalTime, departureTime, entfernung, cost, intermediateStations, fahrtdatum);
		
		System.out.println(result);
		
		
		
	}
	

}
