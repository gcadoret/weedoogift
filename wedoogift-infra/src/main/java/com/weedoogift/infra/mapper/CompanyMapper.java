package com.weedoogift.infra.mapper;

import com.weedoogift.domain.model.Company;
import com.weedoogift.infra.model.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CompanyMapper {
    Company entityToDomain(CompanyEntity companyEntity);
    CompanyEntity domainToEntity(Company company);
}
