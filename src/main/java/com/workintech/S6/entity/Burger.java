package com.workintech.S6.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "burger", schema = "spring")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    //Sadece NotBlank kullansakta olur çünkü hem isim boş bırakılırsa hem de hiç eklenmezse validate yapmıyor.
    //Ama NotNull isimin boş bırakıldığı kısmı yakalamıyor.
    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Min(value = 100)
    @Column(name = "price")
    private double price;
    @Column(name = "is_Vegan")
    private boolean isVegan;
    @Enumerated(EnumType.STRING)
    private BreadType breadType;
    @Column(name = "contents")
    private List<String> contents;

}
