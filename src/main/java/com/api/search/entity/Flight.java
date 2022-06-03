package com.api.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String flightNumber;
    @Column
    private String origin;
    @Column
    private String destination;
    @Column
    private String flightDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Inventory_ID")
    private Inventory inventory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Fare_ID")
    private Fare  fare;


    public Flight(String flightNumber, String origin, String destination, String flightDate,  Inventory inventory,Fare fare) {
    }
}
