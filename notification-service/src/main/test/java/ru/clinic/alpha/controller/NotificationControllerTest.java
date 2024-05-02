package ru.clinic.alpha.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.clinic.alpha.model.Notification;
import ru.clinic.alpha.service.NotificationService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class NotificationControllerTest {
    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createNotification_Success() {
        Notification notification = new Notification();
        notification.setMessage("Reminder");
        notification.setClientId(1L);
        notification.setNotificationTime(LocalDateTime.now());
        notification.setStatus("Scheduled");

        when(notificationService.saveNotification(any(Notification.class))).thenReturn(notification);

        ResponseEntity<?> response = notificationController.createNotification(notification);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notification, response.getBody());
    }

    @Test
    void getNotificationById_Found() {
        Notification notification = new Notification();
        notification.setId(1L);

        when(notificationService.findNotificationById(1L)).thenReturn(Optional.of(notification));

        ResponseEntity<?> response = notificationController.getNotificationById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notification, response.getBody());
    }

    @Test
    void getNotificationById_NotFound() {
        when(notificationService.findNotificationById(1L)).thenReturn(Optional.empty());

        ResponseEntity<?> response = notificationController.getNotificationById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getNotificationsByClientId_Found() {
        Notification notification1 = new Notification();
        Notification notification2 = new Notification();
        List<Notification> notifications = Arrays.asList(notification1, notification2);

        when(notificationService.findNotificationsByClientId(1L)).thenReturn(notifications);

        ResponseEntity<List<Notification>> response = notificationController.getNotificationsByClientId(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }
}

