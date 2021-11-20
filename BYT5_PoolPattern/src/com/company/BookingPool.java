package com.company;

import java.util.LinkedList;
import java.util.List;

public class BookingPool {
    List<Booking> free = new LinkedList<>();
    List<Booking> used = new LinkedList<>();

    public  Booking getBooking() {
        if (free.isEmpty()) {
            Booking booking = new Booking("booking" + (int)(Math.random()*(100 - 0)));
            free.add(booking);
            System.out.println("Booking: "+ booking.name + " is taken");

            return booking;
        } else {
            Booking booking = free.get(0);
            used.add(booking);
            free.remove(booking);
            System.out.println("Booking: "+ booking.name + " is taken");

            return booking;
        }
    }
    public void releaseBooking(Booking booking){
        used.remove(booking);
        free.add(booking);
        System.out.println("Booking: "+ booking.name + " is released");
    }
}
