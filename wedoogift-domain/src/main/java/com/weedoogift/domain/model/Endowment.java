package com.weedoogift.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class Endowment {

    private Long id;
    private LocalDate endDate;
    private LocalDate startDate;
    private int amount;
    private Company company;

    public boolean isExpired() {
        return this.endDate.isBefore(LocalDate.now());
    }

    protected Endowment(int amount, Company company, LocalDate expirationDate) {
        this.startDate = LocalDate.now();
        this.endDate = expirationDate;
        this.amount = amount;
        this.company = company;
    }
}
