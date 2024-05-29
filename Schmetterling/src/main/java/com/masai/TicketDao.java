// Source code is decompiled from a .class file using FernFlower decompiler.
package com.masai;
import com.masai.TicketDaoImpl;

public interface TicketDao {
   String insertBusDetails(String busname, String source, String destination, String bustype, Integer seats, String arrivalTime, String departureTime, Float entfernung, Integer fahrdauer, Double cost, String intermediateStations);

   String confirmTicket(String var1, String var2, String var3, int var4);

   String ticketCancel(int var1, String var2);

   String adminLogin(String var1, String var2);
    
}