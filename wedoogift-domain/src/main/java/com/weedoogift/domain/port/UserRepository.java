package com.weedoogift.domain.port;

import com.weedoogift.domain.model.User;

public interface UserRepository {
    User findById(Long idUser);

    void save(User user);
}
