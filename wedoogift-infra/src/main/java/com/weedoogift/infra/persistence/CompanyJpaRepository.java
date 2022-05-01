package com.weedoogift.infra.persistence;

import com.weedoogift.infra.model.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<CompanyEntity, Long> {

}
