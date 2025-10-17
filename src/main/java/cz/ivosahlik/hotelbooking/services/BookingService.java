package cz.ivosahlik.hotelbooking.services;

import cz.ivosahlik.hotelbooking.dtos.BookingDTO;
import cz.ivosahlik.hotelbooking.dtos.Response;

public interface BookingService {

    Response getAllBookings();
    Response createBooking(BookingDTO bookingDTO);
    Response findBookingByReferenceNo(String  bookingReference);
    Response updateBooking(BookingDTO bookingDTO);
}
