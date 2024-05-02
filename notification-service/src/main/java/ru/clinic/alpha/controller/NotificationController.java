package ru.clinic.alpha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clinic.alpha.model.Notification;
import ru.clinic.alpha.service.NotificationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Create a new notification
    @PostMapping("/create")
    public ResponseEntity<?> createNotification(@RequestBody Notification notification) {
        Notification savedNotification = notificationService.saveNotification(notification);
        return ResponseEntity.ok(savedNotification);
    }

    // Get a notification by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getNotificationById(@PathVariable Long id) {
        Optional<Notification> notification = notificationService.findNotificationById(id);
        return notification.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all notifications for a client
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Notification>> getNotificationsByClientId(@PathVariable Long clientId) {
        List<Notification> notifications = notificationService.findNotificationsByClientId(clientId);
        return ResponseEntity.ok(notifications);
    }
}

