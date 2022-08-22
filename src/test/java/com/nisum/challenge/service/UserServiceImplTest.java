package com.nisum.challenge.service;

import com.nisum.challenge.entity.User;
import com.nisum.challenge.exception.custom.UserInvalidEmailException;
import com.nisum.challenge.repository.UserRepository;
import com.nisum.challenge.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserServiceImpl service;

    @Test
    void createUser_OK() {
        User userRequestMock = createUserMock();
        User userResponseMock = createUserMock();
        userRequestMock.setId(1L);

        when(repository.findByEmail(userRequestMock.getEmail()))
                .thenReturn(Optional.empty());

        when(repository.save(userRequestMock))
                .thenReturn(userResponseMock);

        User user = service.create(userRequestMock);

        assertEquals(user, userResponseMock);
    }

    @Test
    void createUser_invalid_email_ERROR() {
        User userRequestMock = createUserMock();

        when(repository.findByEmail(userRequestMock.getEmail()))
                .thenReturn(Optional.of(createUserMock()));

        assertThatThrownBy(
                () -> service.create(userRequestMock)
        ).isInstanceOf(UserInvalidEmailException.class);
    }

    private User createUserMock() {
        return User.builder()
                .name("dummy")
                .email("dummy@dummy.com")
                .build();
    }

}
