package com.masai;

import java.util.Scanner;

public class IntsertBusDetails {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter BusName: ");
		String busname = sc.next();
		
		System.out.println("Enter Source: ");
		String source = sc.next();
		
		System.out.println("Enter Destination: ");
		String destination = sc.next();
		
		System.out.println("Enter BusType: ");
		String bustype = sc.next();
		
		System.out.println("Enter Seats Avilable: ");
		Integer seats = sc.nextInt();
		
		System.out.println("Enter ArrivalTime: ");
		String arrivalTime = sc.next();
		
		System.out.println("Enter DepartureTime: ");
		String departureTime = sc.next();
		
		System.out.println("Enter Entfernung (in kilometers): ");
	    Float entferung = sc.nextFloat();

	  
	    System.out.println("Enter Duration: ");
	    Integer fahrdauer = sc.nextInt();

	    System.out.println("Enter kosten: ");
	    Double cost = sc.nextDouble();

         System.out.println("Enter Intermediate Stations (comma-separated, leave empty if none): ");
	     String intermediateStations = sc.nextLine();

		
		TicketDao dao = new TicketDaoImpl();
		
	    String result = dao.insertBusDetails(busname, source, destination, bustype, seats, arrivalTime, departureTime, entferung, fahrdauer, cost, intermediateStations);
		
		System.out.println(result);
		
		
		
	}
	

}
