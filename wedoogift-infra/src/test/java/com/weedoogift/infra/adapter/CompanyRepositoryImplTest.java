package com.weedoogift.infra.adapter;

import com.weedoogift.domain.model.Company;
import com.weedoogift.infra.mapper.CompanyMapper;
import com.weedoogift.infra.model.CompanyEntity;
import com.weedoogift.infra.persistence.CompanyJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompanyRepositoryImplTest {

    @Mock
    private CompanyJpaRepository companyJpaRepository;

    @Mock
    private CompanyMapper companyMapper;

    @InjectMocks
    private CompanyRepositoryImpl companyRepository;

    @Test
    void findById_Test() {
        // Given
        CompanyEntity companyEntity = CompanyEntity.builder().id(1L).build();
        when(companyJpaRepository.findById(1L)).thenReturn(Optional.of(companyEntity));
        Company company = Company.builder().id(1L).build();
        when(companyMapper.entityToDomain(companyEntity)).thenReturn(company);

        // When
        Company companyReturned = companyRepository.findById(1L);

        // Test
        Assertions.assertEquals(1L, companyReturned.getId());
    }


}