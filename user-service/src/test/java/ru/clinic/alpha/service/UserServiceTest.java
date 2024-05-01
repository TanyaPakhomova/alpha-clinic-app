package ru.clinic.alpha.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.clinic.alpha.model.User;
import ru.clinic.alpha.repository.UserRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerUser_ShouldSaveUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.registerUser(user);

        assertNotNull(savedUser);
        assertEquals("password", savedUser.getPassword());
        verify(userRepository).save(user);
    }

    @Test
    void authenticateUser_ValidCredentials_ShouldReturnUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password");

        when(userRepository.findByUsername("testUser")).thenReturn(Optional.of(user));

        Optional<User> result = userService.authenticateUser("testUser", "password");

        assertTrue(result.isPresent());
        assertEquals("testUser", result.get().getUsername());
    }

    @Test
    void authenticateUser_InvalidCredentials_ShouldReturnEmpty() {
        when(userRepository.findByUsername("testUser")).thenReturn(Optional.empty());

        Optional<User> result = userService.authenticateUser("testUser", "password");

        assertFalse(result.isPresent());
    }

    @Test
    void findUserById_Found_ShouldReturnUser() {
        User user = new User();
        user.setId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findUserById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals(1L, foundUser.get().getId());
    }

    @Test
    void findUserById_NotFound_ShouldReturnEmpty() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<User> foundUser = userService.findUserById(1L);

        assertFalse(foundUser.isPresent());
    }
}