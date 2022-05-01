package com.weedoogift.domain.service.user;

import com.weedoogift.domain.model.*;
import com.weedoogift.domain.port.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void distributeGift_Test() {

        // Given
        Endowment endowment = new Gift(500, Company.builder().id(1L).build());
        Endowment endowment2 = new Meal(500, Company.builder().id(1L).build());
        List<Endowment> endowments = List.of(endowment, endowment2);
        User user = User.builder().id(1L).username("foo").endowments(endowments).build();
        when(userRepository.findById(1L)).thenReturn(user);

        // When
        int balanceUser = userService.computeBalance(1L);

        // Test
        Assertions.assertEquals(1000, balanceUser);
    }

}