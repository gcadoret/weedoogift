package com.weedoogift.infra.mapper;

import com.weedoogift.domain.model.Company;
import com.weedoogift.domain.model.User;
import com.weedoogift.infra.model.CompanyEntity;
import com.weedoogift.infra.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface UserMapper {
    User entityToDomain(UserEntity userEntity);
    UserEntity domainToEntity(User user);
}
