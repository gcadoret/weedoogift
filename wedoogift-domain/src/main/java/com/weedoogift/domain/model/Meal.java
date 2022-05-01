package com.weedoogift.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;


@Getter
@Setter
public class Meal extends Endowment {

    public Meal(int amount, Company company) {
        super(amount, company, getExpirationDateForMeal());
    }

    private static LocalDate getExpirationDateForMeal() {
        var currentDate = LocalDate.now();
        var nextYear = Year.of(currentDate.getYear() + 1);
        return LocalDate.of(nextYear.getValue(), Month.FEBRUARY, (nextYear.isLeap() ? 29 : 28));
    }
}
