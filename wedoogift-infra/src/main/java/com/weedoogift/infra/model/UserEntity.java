package com.weedoogift.infra.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @OneToMany( cascade = {CascadeType.ALL})
    private List<EndownentEntity> endowments = new ArrayList<>();
}
