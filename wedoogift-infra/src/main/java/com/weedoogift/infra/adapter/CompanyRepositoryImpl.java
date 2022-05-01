package com.weedoogift.infra.adapter;

import com.weedoogift.infra.model.CompanyEntity;
import com.weedoogift.infra.persistence.CompanyJpaRepository;
import com.weedoogift.domain.exception.CompanyNotFoundException;
import com.weedoogift.domain.model.Company;
import com.weedoogift.domain.port.CompanyRepository;
import com.weedoogift.infra.mapper.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

    private final CompanyJpaRepository companyJpaRepository;
    private final CompanyMapper companyMapper;

    @Override
    public Company findById(Long idCompany) {
        return companyMapper.entityToDomain(companyJpaRepository.findById(idCompany).orElseThrow(CompanyNotFoundException::new));
    }

    @Override
    public void save(Company company) {
        companyJpaRepository.save(companyMapper.domainToEntity(company));
    }
}
