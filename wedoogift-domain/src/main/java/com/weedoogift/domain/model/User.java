package com.weedoogift.domain.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    Long id;
    String username;
    List<Endowment> endowments = new ArrayList<>();

    public int computeBalance() {
        return endowments != null ? endowments.stream()
                .filter(endowment -> !endowment.isExpired())
                .map(Endowment::getAmount)
                .mapToInt(Integer::intValue)
                .sum() : 0;
    }
}
