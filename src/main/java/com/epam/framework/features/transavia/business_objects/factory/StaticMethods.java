package com.epam.framework.features.transavia.business_objects.factory;

import com.epam.framework.features.transavia.business_objects.Booking;
import com.epam.framework.features.transavia.business_objects.MultiTrip;
import com.epam.framework.features.transavia.business_objects.Trip;

import java.util.ArrayList;

public class StaticMethods {
    public static Booking createBooking(String flightNumber, String lastName, String flightDate){
        Booking booking = new Booking();
        booking.setFlightNumber(flightNumber);
        booking.setFlightDate(lastName);
        booking.setLastName(flightDate);
        return booking;
    }

    public static Trip createTrip(String depatureAirport, String arrivalAirport){
        Trip trip = new Trip();
        trip.setDepatureAirport(depatureAirport);
        trip.setArrivalAirport(arrivalAirport);
        return trip;
    }

    public static MultiTrip createMultiTrip(ArrayList<String> arrayList){
        MultiTrip multiTrip = new MultiTrip();
        multiTrip.setDepatureAirportFirst(arrayList.get(0));
        multiTrip.setArrivalAirportFirst(arrayList.get(1));
        multiTrip.setDateFlightFirst(arrayList.get(2));
        multiTrip.setDepatureAirportSecond(arrayList.get(3));
        multiTrip.setArrivalAirportSecond(arrayList.get(4));
        multiTrip.setDateFlightSecond(arrayList.get(5));
        return multiTrip;
    }
}
