package com.company;

public class Main {

    public static void main(String[] args) {
        BookingPool bookingPool = new BookingPool();
	    Booking booking = bookingPool.getBooking();
	    bookingPool.releaseBooking(booking);

    }
}
