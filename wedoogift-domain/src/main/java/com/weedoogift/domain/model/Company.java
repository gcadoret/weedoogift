package com.weedoogift.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Company {
    Long id;
    String name;
    int balance;
    public void debit(int value){
        if (value <= this.balance){
            this.balance-=value;
        }
    }
}
