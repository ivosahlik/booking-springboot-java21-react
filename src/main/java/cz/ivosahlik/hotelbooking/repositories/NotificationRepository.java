package cz.ivosahlik.hotelbooking.repositories;

import cz.ivosahlik.hotelbooking.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
