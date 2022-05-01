package com.weedoogift.web.config;

import com.weedoogift.domain.port.CompanyRepository;
import com.weedoogift.domain.port.UserRepository;
import com.weedoogift.domain.service.endowment.EndowmentService;
import com.weedoogift.domain.service.endowment.EndowmentServiceImpl;
import com.weedoogift.domain.service.user.UserService;
import com.weedoogift.domain.service.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

    @Bean
    EndowmentService endowmentService(CompanyRepository companyRepository, UserRepository userRepository) {
        return new EndowmentServiceImpl(companyRepository, userRepository);
    }
}
