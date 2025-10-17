package cz.ivosahlik.hotelbooking.services;

import cz.ivosahlik.hotelbooking.dtos.NotificationDTO;

public interface NotificationService {

    void sendEmail(NotificationDTO notificationDTO);

    void sendSms();

    void sendWhatsapp();
}
