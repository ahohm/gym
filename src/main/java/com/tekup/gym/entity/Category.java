package com.tekup.gym.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String  libelle;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Abonnement> abonnements;


//    ---
//    @OneToMany
//    private List<Descipline> listDesciplines= new ArrayList<>();
}
