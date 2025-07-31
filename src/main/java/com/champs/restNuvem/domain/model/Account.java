package com.champs.restNuvem.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name= "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String number;
    private String agency;
    @Column(scale = 2, precision = 13)
    private BigDecimal balance;
    @Column(name = "available_limit",scale = 2, precision = 13)
    private BigDecimal limit;
}
