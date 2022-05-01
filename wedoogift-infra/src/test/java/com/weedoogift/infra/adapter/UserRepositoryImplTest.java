package com.weedoogift.infra.adapter;

import com.weedoogift.domain.model.User;
import com.weedoogift.infra.mapper.UserMapper;
import com.weedoogift.infra.model.UserEntity;
import com.weedoogift.infra.persistence.UserJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserRepositoryImplTest {

    @Mock
    private UserJpaRepository userJpaRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserRepositoryImpl userRepository;

    @Test
    void findById_Test() {

        // Given
        UserEntity userEntity = UserEntity.builder().id(1L).build();
        when(userJpaRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        User user = User.builder().id(1L).build();
        when(userMapper.entityToDomain(userEntity)).thenReturn(user);

        // When
        User userReturned = userRepository.findById(1L);

        // Test
        Assertions.assertEquals(1L, userReturned.getId());
    }




}