package com.api.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Fare")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fare;
    @Column
    private String currencyType;

    public Fare(String fare, String currencyType) {
    }
}
