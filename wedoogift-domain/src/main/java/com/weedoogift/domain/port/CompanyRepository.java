package com.weedoogift.domain.port;

import com.weedoogift.domain.model.Company;

public interface CompanyRepository {
    Company findById(Long idCompany);
    void save(Company company);
}
