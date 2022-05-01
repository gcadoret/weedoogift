package com.weedoogift.infra.mapper;

import com.weedoogift.domain.model.Endowment;
import com.weedoogift.infra.model.EndownentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface EndowmentMapper {
    Endowment entityToDomain(EndownentEntity endownentEntity);
    EndownentEntity domainToEntity(Endowment endowment);
    List<Endowment> entityToDomain(List<EndownentEntity> endownentEntities);
    List<EndownentEntity> domainToEntity(List<Endowment> endowmentList);
}
