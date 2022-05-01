package com.weedoogift.web.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class UserBalanceDto {
    int balance;
}
