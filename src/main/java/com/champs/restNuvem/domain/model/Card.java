package com.champs.restNuvem.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String number;
    @Column(nullable = false)
    private Integer ccv;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> type;
    @Column(name ="additional_limit", scale = 2, precision = 13)
    // precision = total number of digits, scale = number of digits after the decimal point
    private BigDecimal limit;
}
