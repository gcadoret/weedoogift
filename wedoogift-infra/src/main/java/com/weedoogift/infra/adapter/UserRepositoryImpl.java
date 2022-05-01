package com.weedoogift.infra.adapter;

import com.weedoogift.domain.exception.UserNotFoundException;
import com.weedoogift.domain.model.User;
import com.weedoogift.domain.port.UserRepository;
import com.weedoogift.infra.mapper.UserMapper;
import com.weedoogift.infra.model.UserEntity;
import com.weedoogift.infra.persistence.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public User findById(Long idUser) {
        final UserEntity userEntity = userJpaRepository.findById(idUser).orElseThrow(UserNotFoundException::new);
        return userMapper.entityToDomain(userEntity);
    }

    @Override
    public void save(User user) {
        userJpaRepository.save(userMapper.domainToEntity(user));
    }
}
