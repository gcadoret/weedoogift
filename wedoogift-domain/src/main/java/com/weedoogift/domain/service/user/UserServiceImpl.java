package com.weedoogift.domain.service.user;

import com.weedoogift.domain.model.User;
import com.weedoogift.domain.port.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public int computeBalance(Long idUser) {
        User user = userRepository.findById(idUser);
        return user.computeBalance();
    }
}
