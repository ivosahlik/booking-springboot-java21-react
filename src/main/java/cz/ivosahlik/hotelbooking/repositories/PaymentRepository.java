package cz.ivosahlik.hotelbooking.repositories;

import cz.ivosahlik.hotelbooking.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
