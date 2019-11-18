package com.tekup.gym.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Descipline {
    enum Desp {
        KICKBOXING,
        ZUMBA,
        TAEBOO,
        DANCE,
        CARDIO
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Desp libelle;
}
