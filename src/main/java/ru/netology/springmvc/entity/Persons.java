package ru.netology.springmvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Persons {

    @EmbeddedId
    private PK pk;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String cityOfLiving;
}
