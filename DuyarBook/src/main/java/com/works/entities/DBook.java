package com.works.entities;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class DBook {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bid;

    private Long cid;

    @Size(min = 2, max = 50)
    @NotEmpty
    @NotNull
    private String title;


    @Size(min = (3) , max = 75)
    @NotEmpty
    @NotNull
    private String description;

    @Size(min = 2, max = 50)
    @NotEmpty
    @NotNull
    private String author;


    @Size(min = 2, max = 50)
    @NotEmpty
    @NotNull
    private String publishdate;


    @Max(5000000)
    @Min(1)
    @NotNull
    private BigDecimal price;


    @ManyToOne
    private Customer owner;



}
