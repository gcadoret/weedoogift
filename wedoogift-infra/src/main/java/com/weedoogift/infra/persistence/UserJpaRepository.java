package com.weedoogift.infra.persistence;

import com.weedoogift.infra.model.CompanyEntity;
import com.weedoogift.infra.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

}
