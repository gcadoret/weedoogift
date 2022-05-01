package com.weedoogift.infra.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "endownent")
public class EndownentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate startDate;
    LocalDate endDate;
    Long amount;
    @ManyToOne
    UserEntity user;
    @ManyToOne
    CompanyEntity company;
}
