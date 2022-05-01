package com.weedoogift.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Gift extends Endowment {
    public Gift(int amount, Company company) {
        super(amount, company, LocalDate.now().plusDays(365));
    }
}
