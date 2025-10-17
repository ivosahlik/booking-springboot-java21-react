package cz.ivosahlik.hotelbooking.dtos;

import cz.ivosahlik.hotelbooking.enums.PaymentGateway;
import cz.ivosahlik.hotelbooking.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDTO {

    private Long id;
    private BookingDTO booking;

    private String transactionId;

    private BigDecimal amount;

    private PaymentGateway paymentMethod; //e,g Paypal. Stripe, flutterwave, paystack

    private LocalDateTime paymentDate;

    private PaymentStatus status; //failed, e.t.c

    private String bookingReference;
    private String failureReason;

    private String approvalLink; //paypal payment approval UEL

}
