package cz.ivosahlik.hotelbooking.controllers;

import cz.ivosahlik.hotelbooking.dtos.BookingDTO;
import cz.ivosahlik.hotelbooking.dtos.Response;
import cz.ivosahlik.hotelbooking.security.RoleAdmin;
import cz.ivosahlik.hotelbooking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/all")
    @RoleAdmin
    @PreAuthorize("hasAuthority('ADMIN') && @authz.decide(#root)")
    public ResponseEntity<Response> getAllBookings() {
        return ok(bookingService.getAllBookings());
    }


    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('CUSTOMER') ")
    public ResponseEntity<Response> createBooking(@RequestBody BookingDTO bookingDTO) {
        return ok(bookingService.createBooking(bookingDTO));
    }


    @GetMapping("/{reference}")
    public ResponseEntity<Response> findBookingByReferenceNo(@PathVariable String reference) {
        return ok(bookingService.findBookingByReferenceNo(reference));
    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> updateBooking(@RequestBody BookingDTO bookingDTO) {
        return ok(bookingService.updateBooking(bookingDTO));
    }

}

