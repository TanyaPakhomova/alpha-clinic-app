package ru.clinic.alpha.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.clinic.alpha.model.User;
import ru.clinic.alpha.service.UserService;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_Success() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPass");
        when(userService.registerUser(any(User.class))).thenReturn(user);

        ResponseEntity<?> response = userController.registerUser(user);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }
    @Test
    void registerUser_Failure() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPass");
        when(userService.registerUser(any(User.class))).thenReturn(null);

        ResponseEntity<?> response = userController.registerUser(user);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Registration failed", response.getBody());
    }

    @Test
    void loginUser_Success() {
        User user = new User();
        user.setUsername("testUser");
        when(userService.authenticateUser("testUser", "testPass")).thenReturn(Optional.of(user));

        ResponseEntity<?> response = userController.loginUser("testUser", "testPass");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("User authenticated successfully", response.getBody());
    }

    @Test
    void loginUser_Failure() {
        when(userService.authenticateUser("testUser", "wrongPass")).thenReturn(Optional.empty());

        ResponseEntity<?> response = userController.loginUser("testUser", "wrongPass");
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid username or password", response.getBody());
    }

    @Test
    void getUserDetails_Found() {
        // Arrange
        User expectedUser = new User();
        expectedUser.setId(1L);
        expectedUser.setUsername("testUser");
        when(userService.findUserById(1L)).thenReturn(Optional.of(expectedUser));

        ResponseEntity<?> response = userController.getUserDetails(1L);

        assertTrue(response.getBody() instanceof User);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        User actualUser = (User) response.getBody();
        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getUsername(), actualUser.getUsername());
    }


    @Test
    void getUserDetails_NotFound() {
        when(userService.findUserById(1L)).thenReturn(Optional.empty());

        ResponseEntity<?> response = userController.getUserDetails(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }
}