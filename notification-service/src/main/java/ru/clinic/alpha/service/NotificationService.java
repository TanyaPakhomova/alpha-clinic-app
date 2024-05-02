package ru.clinic.alpha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clinic.alpha.model.Notification;
import ru.clinic.alpha.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Method for creating or updating a notification
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // Method for searching for a notification by ID
    public Optional<Notification> findNotificationById(Long id) {
        return notificationRepository.findById(id);
    }

    // Method to search for all client notifications
    public List<Notification> findNotificationsByClientId(Long clientId) {
        return notificationRepository.findByClientId(clientId);
    }
}
