package com.lab4.more_tables.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tv_table")
@Data
public class Tv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private String name;

    @Column
    private float price;
}
