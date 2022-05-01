package com.weedoogift.domain.service.endowment;

import com.weedoogift.domain.exception.UnsufficientBalanceCompanyException;
import com.weedoogift.domain.model.*;
import com.weedoogift.domain.port.CompanyRepository;
import com.weedoogift.domain.port.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EndowmentServiceImplTest {

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private EndowmentServiceImpl endowmentService;

    @Test
    void distributeGift_Test() {

        // Given
        Company company = Company.builder().id(1L).balance(100).build();
        User user = User.builder().id(1L).username("foo").endowments(new ArrayList<>()).build();
        when(companyRepository.findById(1L)).thenReturn(company);
        when(userRepository.findById(1L)).thenReturn(user);
        Endowment endowment = new Gift(50, company);
        doNothing().when(companyRepository).save(company);
        doNothing().when(userRepository).save(user);

        // When
        User userReturned = endowmentService.distributeGift(1L, 1L, 50);

        // Test
        Assertions.assertNotNull(userReturned);
        Assertions.assertEquals(1, userReturned.getEndowments().size());
        Assertions.assertEquals(LocalDate.now().plusDays(365), endowment.getEndDate());
    }

    @Test
    void distributeGift_Then_UnsufficientBalanceCompanyException_Test() {

        // Given
        Company company = Company.builder().id(1L).balance(100).build();
        User user = User.builder().id(1L).username("foo").endowments(new ArrayList<>()).build();
        when(companyRepository.findById(1L)).thenReturn(company);
        doNothing().when(companyRepository).save(company);
        doNothing().when(userRepository).save(user);

        // When/then
        Assertions.assertThrows(UnsufficientBalanceCompanyException.class, () -> endowmentService.distributeGift(1L, 1L, 500));
    }

    @Test
    void distributeMeal_Test() {

        // Given
        Company company = Company.builder().id(1L).balance(100).build();
        User user = User.builder().id(1L).username("foo").endowments(new ArrayList<>()).build();
        when(companyRepository.findById(1L)).thenReturn(company);
        when(userRepository.findById(1L)).thenReturn(user);
        Endowment endowment = new Meal(50, company);
        doNothing().when(companyRepository).save(company);
        doNothing().when(userRepository).save(user);

        // When
        User userReturned = endowmentService.distributeMeal(1L, 1L, 50);

        // Test
        Assertions.assertNotNull(userReturned);
        Assertions.assertEquals(1, userReturned.getEndowments().size());
        var nextYear = Year.of(LocalDate.now().getYear() + 1);
        Assertions.assertEquals(LocalDate.of(nextYear.getValue(), Month.FEBRUARY, (nextYear.isLeap() ? 29 : 28)), endowment.getEndDate());

    }

    @Test
    void distributeMeal_Then_UnsufficientBalanceCompanyException_Test() {

        // Given
        Company company = Company.builder().id(1L).balance(100).build();
        User user = User.builder().id(1L).username("foo").endowments(new ArrayList<>()).build();
        when(companyRepository.findById(1L)).thenReturn(company);
        doNothing().when(companyRepository).save(company);
        doNothing().when(userRepository).save(user);

        // When/then
        Assertions.assertThrows(UnsufficientBalanceCompanyException.class, () -> endowmentService.distributeGift(1L, 1L, 500));
    }
}